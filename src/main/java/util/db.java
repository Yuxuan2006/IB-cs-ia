package util;

import data.Student;
import data.Teacher;
import data.User;
import data.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class db {

    // Database connection method with improved error handling
    public static Connection getCon() {
        try {
            // Use the new MySQL driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Use environment variables or configuration for connection details
            String url = "jdbc:mysql://localhost:3306/mydb";
            String user = "root";
            String password = "20061029";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
            throw new RuntimeException("Database driver error", e);
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            throw new RuntimeException("Database connection error", e);
        }
    }

    // Improved resource closing method
    private static void closeResources(Connection con, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println("Error closing ResultSet: " + e.getMessage());
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                System.err.println("Error closing PreparedStatement: " + e.getMessage());
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println("Error closing Connection: " + e.getMessage());
            }
        }
    }

    // Enhanced addUser method to handle different user types
    public static void addUser(User user) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getCon();
            String query = "INSERT INTO user (id, name, password, className, email, teacher_id, class_id, student_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);

            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getClassName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getTeacher_id());
            ps.setString(7, user.getClass_id());
            ps.setString(8, user.getStudent_id());

            ps.executeUpdate();
            System.out.println("User added successfully: " + user.getName());
        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
            throw e;
        } finally {
            closeResources(con, ps, null);
        }
    }

    // Enhanced method to get user by email with more robust retrieval
    public static User getUserByEmail(String email) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getCon();
            String query = "SELECT * FROM user WHERE email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);

            rs = ps.executeQuery();

            if (rs.next()) {
                // Determine user type based on additional fields
                String teacherId = rs.getString("teacher_id");
                String studentId = rs.getString("student_id");

                User user;
                if (teacherId != null) {
                    Teacher teacher = new Teacher();
                    teacher.setTeacherId(teacherId);
                    user = teacher;
                } else if (studentId != null) {
                    Student student = new Student();
                    student.setStudentId(studentId);
                    user = student;
                } else {
                    user = new User();
                }

                // Set common user fields
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setClassName(rs.getString("className"));
                user.setEmail(rs.getString("email"));
                user.setTeacher_id(teacherId);
                user.setClass_id(rs.getString("class_id"));
                user.setStudent_id(studentId);

                return user;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("Error retrieving user: " + e.getMessage());
            throw e;
        } finally {
            closeResources(con, ps, rs);
        }
    }

    // New method to get student by student ID
    public static Student getStudentById(String studentId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getCon();
            String query = "SELECT * FROM users WHERE student_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, studentId);

            rs = ps.executeQuery();

            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setClassName(rs.getString("className"));
                student.setEmail(rs.getString("email"));
                student.setStudentId(studentId);
                student.setScore(rs.getString("score")); // Assuming score column exists
                student.setGrade(rs.getString("grade")); // Assuming grade column exists
                student.setClass_id(rs.getString("class_id"));
                student.setTeacher_id(rs.getString("teacher_id"));

                return student;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("Error retrieving student: " + e.getMessage());
            throw e;
        } finally {
            closeResources(con, ps, rs);
        }
    }

    // New method to get all students in a specific class
    public static List<Student> getStudentsByClass(String classId) throws SQLException {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Student> students = new ArrayList<>();
    try {
        con = getCon();
        // Corrected SQL query using student_id in the user table and id in the student table
        String query = "SELECT u.id, u.name, u.className, u.email, s.id AS student_id, s.score, s.grade " +
                       "FROM user u " +
                       "LEFT JOIN student s ON u.student_id = s.id " +  // Join on user.student_id and student.id
                       "WHERE u.class_id = ? AND u.student_id IS NOT NULL";  // Ensure only users with student_id are considered
        
        ps = con.prepareStatement(query);
        ps.setString(1, classId);

        rs = ps.executeQuery();

        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getString("id")); // From user table
            student.setName(rs.getString("name")); // From user table
            student.setClassName(rs.getString("className")); // From user table
            student.setEmail(rs.getString("email")); // From user table
            student.setStudentId(rs.getString("student_id")); // From student table (via alias)
            student.setScore(rs.getString("score")); // From student table
            student.setGrade(rs.getString("grade")); // From student table
            student.setClass_id(classId); // Set the class ID passed to the method

            students.add(student);
        }

        return students;
    } catch (SQLException e) {
        System.err.println("Error retrieving students: " + e.getMessage());
        throw e;
    } finally {
        closeResources(con, ps, rs);
    }
}



    // Add a Class to the database
    public static void addClass(data.Class classObj) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getCon();
            String query = "INSERT INTO class (id, name, level, course) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(query);

            ps.setString(1, classObj.getClassId());
            ps.setString(2, classObj.getName());
            ps.setString(3, classObj.getLevel());
            ps.setString(4, classObj.getCourse());
            //ps.setString(5, classObj.getTeacherId());

            ps.executeUpdate();
            System.out.println("Class added successfully: " + classObj.getName());
        } catch (SQLException e) {
            System.err.println("Error adding class: " + e.getMessage());
            throw e;
        } finally {
            closeResources(con, ps, null);
        }
    }

// Retrieve a Class by its ID
    public static data.Class getClassById(String classId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getCon();
            String query = "SELECT * FROM class WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, classId);

            rs = ps.executeQuery();
            if (rs.next()) {
                data.Class classObj = new data.Class();
                classObj.setClassId(rs.getString("id"));
                classObj.setName(rs.getString("name"));
                classObj.setLevel(rs.getString("level"));
                classObj.setCourse(rs.getString("course"));
                classObj.setTeacherId(rs.getString("teacher_id"));
                return classObj;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("Error retrieving class: " + e.getMessage());
            throw e;
        } finally {
            closeResources(con, ps, rs);
        }
    }

// Add a Teacher to the database
    public static void addTeacher(Teacher teacher) throws SQLException {
    Connection con = null;
    PreparedStatement ps = null;
    try {
        con = getCon();
        String query = "INSERT INTO teacher (id,  position,  age ) VALUES (?, ?, ? )";
        ps = con.prepareStatement(query);
        
        ps.setString(1, teacher.getId());
        
        ps.setString(2, teacher.getPosition());
        
        ps.setString(3, teacher.getAge());
        
        
        int rowsInserted = ps.executeUpdate();
        addUser(teacher);
        if (rowsInserted > 0) {
            System.out.println("Teacher added successfully: " + teacher.getName());
        } else {
            System.err.println("Error adding teacher: No rows were inserted.");
        }
    } catch (SQLException e) {
        System.err.println("Error adding teacher: " + e.getMessage());
        throw e;
    } finally {
        closeResources(con, ps, null);
    }
}
    
    public static void addStudent(Student stu) throws SQLException {
    Connection con = null;
    PreparedStatement ps = null;
    try {
        con = getCon();
        String query = "INSERT INTO student (id,  score,  grade ) VALUES (?, ?, ? )";
        ps = con.prepareStatement(query);
        
        ps.setString(1, stu.getId());
        
        ps.setString(2, stu.getScore());
        
        ps.setString(3, stu.getGrade());
        
        
        int rowsInserted = ps.executeUpdate();
        addUser(stu);
        if (rowsInserted > 0) {
            System.out.println("stu added successfully: " + stu.getName());
        } else {
            System.err.println("Error adding stu: No rows were inserted.");
        }
    } catch (SQLException e) {
        System.err.println("Error adding stu: " + e.getMessage());
        throw e;
    } finally {
        closeResources(con, ps, null);
    }
}

// Retrieve a Teacher by their ID
    public static Teacher getTeacherById(String teacherId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getCon();
            String query = "SELECT * FROM teachers WHERE teacher_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, teacherId);

            rs = ps.executeQuery();
            if (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherId(rs.getString("teacher_id"));
                teacher.setName(rs.getString("name"));
                teacher.setAge(rs.getString("age"));
                teacher.setPosition(rs.getString("position"));
             
                teacher.setEmail(rs.getString("email"));
                return teacher;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("Error retrieving teacher: " + e.getMessage());
            throw e;
        } finally {
            closeResources(con, ps, rs);
        }
    }

// Add a Question to the database
    public static void addQuestion(Question question) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getCon();
            String query = "INSERT INTO questions (id, question_context, answer, difficulty, topic, context_a, context_b, context_c, context_d) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);

            ps.setString(1, question.getId());
            ps.setString(2, question.getQuestionContext());
            ps.setString(3, question.getAnswer());
            ps.setString(4, question.getDifficulty());
            ps.setString(5, question.getTopic());
            ps.setString(6, question.getQuestionContexta());
            ps.setString(7, question.getQuestionContextb());
            ps.setString(8, question.getQuestionContextc());
            ps.setString(9, question.getQuestionContextd());

            ps.executeUpdate();
            System.out.println("Question added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding question: " + e.getMessage());
            throw e;
        } finally {
            closeResources(con, ps, null);
        }
    }

// Retrieve a Question by its ID
    public static Question getQuestionById(String questionId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getCon();
            String query = "SELECT * FROM questions WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, questionId);

            rs = ps.executeQuery();
            if (rs.next()) {
                Question question = new Question();
                question.setId(rs.getString("id"));
                question.setQuestionContext(rs.getString("question_context"));
                question.setAnswer(rs.getString("answer"));
                question.setDifficulty(rs.getString("difficulty"));
                question.setTopic(rs.getString("topic"));
                question.setQuestionContexta(rs.getString("context_a"));
                question.setQuestionContextb(rs.getString("context_b"));
                question.setQuestionContextc(rs.getString("context_c"));
                question.setQuestionContextd(rs.getString("context_d"));
                return question;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("Error retrieving question: " + e.getMessage());
            throw e;
        } finally {
            closeResources(con, ps, rs);
        }
    }
    
    // Add Score and Grade to the User
public static void addScoreGrade(int scorePercentage, User user) throws SQLException {
    Connection con = null;
    PreparedStatement ps = null;

    // Determine the grade based on score percentage
    String grade = calculateGrade(scorePercentage);
    
    try {
        // Set the score and grade for the user
        con = getCon();
        
        // Assuming you want to update the grade and score in the user table
        String query = "UPDATE student SET score = ?, grade = ? WHERE id = ?";
        ps = con.prepareStatement(query);
        
        ps.setInt(1, scorePercentage);  // Set the score
        ps.setString(2, grade);          // Set the grade
        ps.setString(3, user.getId());   // Set the user ID

        // Execute the update
        int rowsUpdated = ps.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Score and grade updated successfully for user: " + user.getName());
        } else {
            System.err.println("Error updating score and grade: No rows were updated.");
        }
    } catch (SQLException e) {
        System.err.println("Error updating score and grade: " + e.getMessage());
        throw e;
    } finally {
        closeResources(con, ps, null);
    }
}

// Helper method to calculate the grade based on the score percentage
private static String calculateGrade(int scorePercentage) {
    if (scorePercentage > 90) {
        return "A";
    } else if (scorePercentage > 80) {
        return "B";
    } else if (scorePercentage > 70) {
        return "C";
    } else {
        return "D";
    }
}


    // Existing addQuestion and getQuestionById methods remain the same
    public static void main(String[] args) {
        try {
            // Example usage of new methods
            // Add a user
            User newUser = new Student();
            newUser.setId(UUID.randomUUID().toString());
            newUser.setName("John Doe");
            newUser.setEmail("john.doe@example.com");
            newUser.setPassword("securePassword123");
            newUser.setClassName("10A");

            // If it's a student
            if (newUser instanceof Student) {
                ((Student) newUser).setStudentId(UUID.randomUUID().toString());
                ((Student) newUser).setScore("85");
                ((Student) newUser).setGrade("A");
            }

            addUser(newUser);

            // Retrieve user by email
            User retrievedUser = getUserByEmail("john.doe@example.com");
            if (retrievedUser != null) {
                System.out.println("Retrieved user: " + retrievedUser.getName());
            }

            // If the retrieved user is a student, demonstrate additional methods
            if (retrievedUser instanceof Student) {
                Student student = (Student) retrievedUser;
                System.out.println("Student Score: " + student.getScore());
                System.out.println("Student Grade: " + student.getGrade());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
