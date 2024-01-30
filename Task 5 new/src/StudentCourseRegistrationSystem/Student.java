package StudentCourseRegistrationSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String id;
    String name;
    List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Registered Courses: " + registeredCourses.size();
    }
}
