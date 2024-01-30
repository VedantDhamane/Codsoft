package StudentCourseRegistrationSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        Course c1 = new Course("CSCI101", "Introduction to Programming", "Basic programming concepts", 30, "Mon/Wed/Fri 10:00 AM");
        Course c2 = new Course("MATH201", "Calculus I", "Limits and derivatives", 25, "Tue/Thu 2:00 PM");
        Course c3 = new Course("COMP202", "Java Programming", "Intermediate Java concepts", 20, "Mon/Wed/Fri 1:00 PM");
        Course c4 = new Course("COMP203", "Python Programming", "Python for beginners", 25, "Tue/Thu 10:00 AM");
        Course c5 = new Course("COMP204", "C++ Programming", "Advanced C++ programming", 15, "Mon/Wed 3:00 PM");
        Course c6 = new Course("WEB101", "Web Development Basics", "HTML, CSS, and JavaScript", 30, "Tue/Thu 1:00 PM");
        Course c7 = new Course("WEB201", "Advanced Web Development", "Frameworks and libraries", 20, "Mon/Wed/Fri 2:00 PM");

        system.addCourse(c1);
        system.addCourse(c2);
        system.addCourse(c3);
        system.addCourse(c4);
        system.addCourse(c5);
        system.addCourse(c6);
        system.addCourse(c7);


        Scanner scanner = new Scanner(System.in);

        while (true) {
        	 System.out.println("\n1. Display Courses");
             System.out.println("2. Register Student for Course");
             System.out.println("3. Remove Student from Course");
             System.out.println("4. Register New Student");
             System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayCourses();
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.next();
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.next();

                    Student student = new Student(studentId, "Student");
                    Course course = null;

                    for (Course c : system.courseDatabase) {
                        if (c.code.equals(courseCode)) {
                            course = c;
                            break;
                        }
                    }

                    if (course != null) {
                        system.registerStudent(student, course);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
              
                case 3:
                    system.removeRegistration();
                    break;

                case 4:
                    system.registerStudent();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
