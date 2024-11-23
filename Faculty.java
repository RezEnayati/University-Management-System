import java.io.Serializable;

public class Faculty extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String[] courses;
    public Faculty(String firstName, String lastName, int monthBirth, int dayBirth, int yearBirth, String[] courses) {
        super(firstName, lastName, monthBirth, dayBirth, yearBirth);
        this.courses = courses;
    }

    public String[] getCourses() {
        return courses;
    }

}
