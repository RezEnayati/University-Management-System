import java.io.Serializable;

public class Person implements Serializable  {
    private static final long serialVersionUID = 1L;
    protected String firstName;
    protected String lastName;
    protected int monthBirth;
    protected int dayBirth;
    protected int yearBirth;

    public Person(String firstName, String lastName, int monthBirth, int dayBirth, int yearBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthBirth = monthBirth;
        this.dayBirth = dayBirth;
        this.yearBirth = yearBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDOB() {
        return monthBirth + "/" + dayBirth + "/" + yearBirth;
    }
}
