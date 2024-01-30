package StudentCourseRegistrationSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationSystem {
    public List<Course> courseDatabase;
    public List<Student> studentDatabase;

    public CourseRegistrationSystem() {
        this.courseDatabase = new ArrayList<>();
        this.studentDatabase = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courseDatabase.add(course);
    }
//    public void registerStudent() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter student ID: ");
//        String studentId = scanner.next();
//        System.out.print("Enter student name: ");
//        String studentName = scanner.next();
//
//        Student newStudent = new Student(studentId, studentName);
//        studentDatabase.add(newStudent);
//
//        System.out.println("Student registered successfully!");
//    }
    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courseDatabase) {
            System.out.println(course);
        }
    }

    public void registerStudent(Student student, Course course) {
        if (course.capacity > 0) {
            student.registeredCourses.add(course);
            course.capacity--;
            System.out.println("Registration successful!");
        } else {
            System.out.println("Course is full. Registration failed.");
        }
    }

    public void removeRegistration() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();

        // Find the student
        Student foundStudent = null;
        for (Student student : studentDatabase) {
            if (student.id.equals(studentId)) {
                foundStudent = student;
                break;
            }
        }

        // Find the course
        Course foundCourse = null;
        for (Course course : courseDatabase) {
            if (course.code.equals(courseCode)) {
                foundCourse = course;
                break;
            }
        }

        // Remove registration if both student and course are found
        if (foundStudent != null && foundCourse != null) {
            if (foundStudent.registeredCourses.contains(foundCourse)) {
                foundStudent.registeredCourses.remove(foundCourse);
                foundCourse.capacity++;
                System.out.println("Course removed successfully.");
            } else {
                System.out.println("Student is not registered for this course.");
            }
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void registerStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter student name: ");
        String studentName = scanner.next();

        Student newStudent = new Student(studentId, studentName);
        studentDatabase.add(newStudent);

        System.out.println("Student registered successfully!");
    }
}
