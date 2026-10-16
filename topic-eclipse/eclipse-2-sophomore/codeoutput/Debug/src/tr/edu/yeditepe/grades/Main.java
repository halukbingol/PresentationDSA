package tr.edu.yeditepe.grades;

public class Main {
    public static void main(String[] args) {
        GradeBook book = new GradeBook();
        book.add(new Student("Ayşe", 70, 80));
        book.add(new Student("Ali", 75, 60));
        System.out.println("Midterm average: " + book.averageMidterm());
    }
}
