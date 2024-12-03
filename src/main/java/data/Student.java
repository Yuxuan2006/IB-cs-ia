package data;

public class Student extends User {
    private String studentId;
    private String score;
    private String grade;

    // Getter for score
    public String getScore() {
        return score;
    }

    // Setter for score
    public void setScore(String newScore) {
        this.score = newScore;
    }

    // Getter for grade
    public String getGrade() {
        return grade;
    }

    // Setter for grade
    public void setGrade(String newGrade) {
        this.grade = newGrade;
    }

    // Getter for studentId
    public String getStudentId() {
        return studentId;
    }

    // Setter for studentId
    public void setStudentId(String newStudentId) {
        this.studentId = newStudentId;
    }
}
