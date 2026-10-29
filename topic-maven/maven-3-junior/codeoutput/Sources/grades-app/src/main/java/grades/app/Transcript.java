package grades.app;

import grades.Course;
import grades.Gpa;
import java.util.ArrayList;
import java.util.List;

public class Transcript {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        for (String a : args) {                          // CSE101:6:AA
            String[] p = a.split(":");
            courses.add(new Course(p[0], Integer.parseInt(p[1]), p[2]));
            System.out.printf("%-8s %2s credits  %s%n", p[0], p[1], p[2]);
        }
        System.out.printf("GPA %.2f%n", Gpa.of(courses));
    }
}
