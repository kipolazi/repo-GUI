import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Course> courseList;

    public Student(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
}