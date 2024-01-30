package StudentCourseRegistrationSystem;
public class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return code + ": " + title + " - " + description + " (" + schedule + "), Capacity: " + capacity;
    }
}
