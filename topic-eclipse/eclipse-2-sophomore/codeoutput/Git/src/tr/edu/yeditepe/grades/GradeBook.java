package tr.edu.yeditepe.grades;

import java.util.ArrayList;
import java.util.List;

public class GradeBook {
    private final List<Student> students = new ArrayList<>();

    public void add(Student s) {
        students.add(s);
    }

    public double averageMidterm() {
        int sum = 0;
        for (Student s : students) {
            sum += s.midterm();
        }
        return sum / students.size();
    }
}
