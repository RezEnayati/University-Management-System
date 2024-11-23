import java.io.Serializable;
public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String major;
    public Student(String firstName, String lastName, int monthBirth, int dayBirth, int yearBirth, String major) {
        super(firstName, lastName, monthBirth, dayBirth, yearBirth);
        this.major = major;
    }
    public String getMajor() {
        return major;
    }
}
