import java.util.ArrayList;

interface School {
    //Find the student from first name and last name
    Student findStudent(String fn, String ln);

    //Find the faculty from first name and last name
    Faculty findFaculty(String fn, String ln);

    //add a faculty to the Person Array
    Faculty hire(Person p);

    //admit a student to the university
    Student admit(Person p);

    //return everyone in the university, both students and faculty
    ArrayList<Person> getAllPersons();

    //return all the majors from the university
    String[] getAllMajors();

    //return all the courses in the university
    String[] getAllCourses();

    //return only the students in the university
    ArrayList<Student> getStudents();

    //return all the faculties in the university
    ArrayList<Faculty> getFaculty();

    //Extras
    //Fire A faculty
    void fireFaculty(Faculty f);

    //Expel a Student
    void expelStudent(Student s);

}
