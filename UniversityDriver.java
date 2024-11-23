import java.util.ArrayList;
import java.util.Scanner;

public class UniversityDriver {
    public static void main(String[] args) {
        University university =  new University("HERO UNIVERSITY", "ex tenebris ad lucem alis novis volabimus");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to " + university.getName());
        System.out.println(university.getMotto());
        System.out.println();
        String command;
        System.out.println("What would you like to do?\n" +
                "Enter \"hire\" to hire a new faculty member.\n" +
                "Enter \"admit\" to admit a new student.\n" +
                "Enter \"find student\" to list information about a student.\n" +
                "Enter \"find faculty\" to list information about a faculty member.\n" +
                "Enter \"list students\" to list the names of all students.\n" +
                "Enter \"list faculty\" to list the names of faculty members.\n" +
                "Enter \"fire faculty\" to fire a faculty member.\n" +
                "Enter \"expel student\" to expel a student \n" +
                "Enter \"quit\" to end this program and save data.");
        do {
            command = scanner.nextLine();

            switch (command.toLowerCase()) {

                case "list students":
                    printStudentList(university);
                    break;

                case "list faculty":
                    printFacultyList(university);
                    break;

                case "find student":
                    findStudent(university, scanner);
                    break;

                case "find faculty":
                    findFaculty(university, scanner);
                    break;

                case "hire":
                    hireFaculty(university, scanner);
                    break;

                case "admit":
                    admit(university, scanner);
                    break;

                case "quit":
                    university.saveData();
                    System.exit(0);
                    break;
                case "fire faculty":
                    fireFaculty(university, scanner);
                    break;

                case "expel student":
                    expelStudent(university, scanner);
                    break;

                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
                }



            }
            while (!command.equalsIgnoreCase("quit"));
            scanner.close();
        }

    private static void printStudentList(University university) {
        for (Student s : university.getStudents()) {
            System.out.println(s.firstName + " " + s.lastName);
        }
    }

    private static void printFacultyList(University university) {
        for (Faculty f : university.getFaculty()) {
            System.out.println(f.firstName + " " + f.lastName);
        }
    }

    private static void findStudent(University university, Scanner scanner) {
        System.out.println("What is the student's first name?");
        String firstName = scanner.nextLine().toLowerCase();
        System.out.println("What is the student's last name?");
        String lastName = scanner.nextLine().toLowerCase();
        Student student = university.findStudent(firstName, lastName);
        if (student != null) {
            System.out.println("Student: " + student.firstName + " " + student.lastName);
            System.out.println("DOB: " + student.getDOB());
            System.out.println("Major: " + student.getMajor());
        }
    }

    private static void findFaculty(University university, Scanner scanner) {
        System.out.println("What is the faculty's first name?");
        String firstName = scanner.nextLine().toLowerCase();
        System.out.println("What is the faculty's last name?");
        String lastName = scanner.nextLine().toLowerCase();
        Faculty faculty = university.findFaculty(firstName, lastName);
        if (faculty != null) {
            System.out.println("Faculty: " + faculty.firstName + " " + faculty.lastName);
            System.out.println("DOB: " + faculty.getDOB());
            System.out.println("Courses:");
            for (String course: faculty.getCourses()) {
                System.out.println(course);
            }
        } else {
          System.out.println("Faculty not found");
        }
    }

    private static void hireFaculty(University university, Scanner scanner) {
        System.out.println("What is the person's first name?");
        String firstName = scanner.nextLine().toLowerCase();
        System.out.println("What is the person's last name?");
        String lastName = scanner.nextLine().toLowerCase();
        System.out.println("What is the person's month of birth?");
        int month = scanner.nextInt();
        System.out.println("What is the person's day of birth?");
        int day = scanner.nextInt();
        System.out.println("What is the person's year of birth?");
        System.out.println("Enter an integer representing the year of birth (4 digits)");
        int year = scanner.nextInt();
        System.out.println("Assign a course to this Faculty");
        System.out.println("Enter \"Done\" of there are no other courses.");
        System.out.println("The courses offered are: ");
        for (String course: university.getAllCourses()) {
            System.out.println(course);
        }
        ArrayList<String> courses = new ArrayList<String>();
        String course;
        while (true) {
            course = scanner.nextLine().toLowerCase();
            if (course.equals("done")) {
                break;
            }
            boolean isCourseValid = false;
            for (String offeredCourses : university.getAllCourses()) {
                if (course.equalsIgnoreCase(offeredCourses)) {
                    isCourseValid = true;
                    break;
                }
            }
            if (isCourseValid) {
                courses.add(course);
            } else {
                System.out.println("That is not a course offered.");
            }
            System.out.println("Assign a course to this Faculty");
            System.out.println("Enter \"Done\" of there are no other courses.");
        }
        String[] coursesArray = courses.toArray(new String[courses.size()]);
        Faculty newFaculty = new Faculty(firstName, lastName, month, day, year, coursesArray );
        if (university.hire(newFaculty) != null) {
            System.out.println("Faculty has been successfully hired.");
        }
    }

    public static void admit(University university, Scanner scanner) {
        System.out.println("What is this person's Major?");
        System.out.println("The majors offered are:");
        for (String major: university.getAllMajors()) {
            System.out.println(major);
        }
        String major;
        while (true){
            major = scanner.nextLine().toLowerCase();
            boolean isValidMajor = false;
            for (String offeredMajor: university.getAllMajors()) {
                if (major.equalsIgnoreCase(offeredMajor)) {
                    isValidMajor = true;
                    break;
                }
            }
            if (isValidMajor) {
                break;
            } else {
                System.out.println("That is not a major offered.");
                System.out.println("What is this person's Major?");
            }
        }
        System.out.println("What is the person's first name?");
        String firstName = scanner.nextLine().toLowerCase();
        System.out.println("What is the person's last name?");
        String lastName = scanner.nextLine().toLowerCase();
        System.out.println("What is the person's month of birth?");
        int month = scanner.nextInt();
        System.out.println("What is the person's day of birth?");
        int day = scanner.nextInt();
        System.out.println("What is the person's year of birth?");
        System.out.println("Enter an integer representing the year of birth (4 digits)");
        int year = scanner.nextInt();

        Student newStudent = new Student(firstName, lastName, month, day, year, major);
        if (university.admit(newStudent) != null) {
            System.out.println("Student has been successfully admitted.");
        }
    }

    private static void fireFaculty(University university, Scanner scanner) {
        System.out.println("What is this person's first name?");
        String firstName = scanner.nextLine().toLowerCase();
        System.out.println("What is the person's last name?");
        String lastName = scanner.nextLine().toLowerCase();
        Faculty faculty = university.findFaculty(firstName, lastName);
        if (faculty == null) {
            System.out.println("That is not a valid faculty.");
        } else {
            university.fireFaculty(faculty);
            System.out.println("Faculty has been successfully fired.");
        }
    }

    private static void expelStudent(University university, Scanner scanner) {
        System.out.println("What is this person's first name?");
        String firstName = scanner.nextLine().toLowerCase();
        System.out.println("What is the person's last name?");
        String lastName = scanner.nextLine().toLowerCase();
        Student student = university.findStudent(firstName, lastName);
        if (student == null) {
            System.out.println("That is not a valid student.");
        } else {
            university.expelStudent(student);
            System.out.println("Student has been successfully expelled.");
        }

    }
}
