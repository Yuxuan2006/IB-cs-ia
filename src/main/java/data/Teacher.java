package data;

public class Teacher extends User {
    private String teacherId;
    private String age;
    private String position; 
   

    
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

   
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    
   
}