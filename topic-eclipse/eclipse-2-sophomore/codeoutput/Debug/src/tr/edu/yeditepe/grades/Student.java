package tr.edu.yeditepe.grades;

public record Student(String name, int midterm, int fin) {
    public double total() {
        return 0.4 * midterm + 0.6 * fin;
    }
}
