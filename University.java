import java.io.*;
import java.util.*;

public class University implements School, Serializable {
    private static final long serialVersionUID = 1L;
    private String universityName;
    private String motto;

    private ArrayList<Person> people;

    private String[] majors;
    private String[] courses;

    public University(String universityName, String motto) {
        this.universityName = universityName;
        this.motto = motto;
        people = new ArrayList<>();
        majors = new String[] {
                "Hardware Architecture",
                "Information Analytics",
                "Quantum Computing",
                "Undecided"
        };

        courses = new String[] {
                "Computers",
                "Advance Physics",
                "Quantum Entanglement",
                "Parallel Programming",
                "Advance Algorithms",
                "FPGA Programming",
                "Hardware Design",
                "Embedded Systems",
                "Signal Processing",
                "Artificial Intelligence",
                "Bayesian Logic",
                "Probability"
        };

        if (!loadData()) {
            loadInitialData();
            saveData();
        }
    }

    public boolean saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(universityName + ".ser"))) {
            oos.writeObject(people);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loadData() {
        File file = new File("UniversityPersons.ser");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                people = (ArrayList<Person>) ois.readObject();
                return true;
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        people = new ArrayList<Person>();
        return false;
    }


    @Override
    public Student findStudent(String fn, String ln) {
        for (Person p : people) {
            if (p instanceof Student student) {
                if (student.getFirstName().equalsIgnoreCase(fn) && student.getLastName().equalsIgnoreCase(ln)) {
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public Faculty findFaculty(String fn, String ln) {
        for (Person p : people) {
            if (p instanceof Faculty faculty) {
                if (faculty.getFirstName().equalsIgnoreCase(fn) && faculty.getLastName().equalsIgnoreCase(ln)) {
                    return faculty;
                }
            }
        }
        return null;
    }

    @Override
    public Faculty hire(Person p) {
        if (p instanceof Faculty faculty) {
            people.add(faculty);
            return faculty;
        }
        return null;
    }

    @Override
    public Student admit(Person p) {
        if (p instanceof Student student) {
            people.add(student);
            return student;
        }
        return null;
    }

    @Override
    public ArrayList<Person> getAllPersons() {
        return new ArrayList<Person>(people);
    }

    @Override
    public String[] getAllMajors() {
        return majors;
    }

    @Override
    public String[] getAllCourses() {
        return courses;
    }

    @Override
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        for (Person p : people) {
            if (p instanceof Student student) {
                students.add(student);
            }
        }
        return students;
    }

    @Override
    public ArrayList<Faculty> getFaculty() {
        ArrayList<Faculty> faculties = new ArrayList<Faculty>();
        for (Person p : people) {
            if (p instanceof Faculty faculty) {
                faculties.add(faculty);
            }
        }
        return faculties;
    }

    @Override
    public void fireFaculty(Faculty f) {
        if (f instanceof Faculty faculty) {
            people.remove(faculty);
        }
    }

    @Override
    public void expelStudent(Student s) {
        if (s instanceof Student) {
            people.remove(s);
        }

    }

    public String getName() {
        return universityName;
    }

    public String getMotto() {
        return motto;
    }


    public void loadInitialData() {
        people.add(new Faculty("Bruce", "Wayne", 9,27,1995, new String[]
                {"Bayesian Logic", "Artificial Intelligence","Hardware Design"}
        ));
        people.add(new Faculty("Diana", "Prince", 11,5,2006, new String[]
                {"Hardware Design", "FPGA Programming", "Embedded Systems"}
        ));
        people.add(new Faculty("Barbara", "Gordon", 5,23,1980, new String[]
                {"Probability", "Signal Processing", "Advance Algorithms"}
        ));
        people.add(new Faculty("Charles", "Xavier", 11,5,1966, new String[]
                {"Signal Processing", "Embedded Systems", "Parallel Programming"}
        ));

        people.add(new Student("Billy", "Baston", 7, 12, 1990, "Information Analytics"));
        people.add(new Student("Carol", "Danvers", 4, 9, 1992, "Quantum Computing"));
        people.add(new Student("Clark", "Kent", 5, 5, 1994 , "Hardware Architecture"));
        people.add(new Student("Kara", "Zorel", 4, 13, 1989, "Hardware Architecture"));
        people.add(new Student("Peter","Parker", 6, 25, 1997, "Quantum Computing"));
        people.add(new Student("Tony","Stark", 2, 2, 2004, "Hardware Architecture"));
        people.add(new Student("Stephen","Strange", 12, 15, 1976, "Quantum Computing"));
        people.add(new Student("Bruce","Banner", 9, 9, 2000, "Undecided"));
    }
}