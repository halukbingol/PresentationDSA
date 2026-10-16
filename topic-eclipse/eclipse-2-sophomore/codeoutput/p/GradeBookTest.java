package tr.edu.yeditepe.grades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GradeBookTest {
    @Test
    void totalWeighsFinalMore() {
        assertEquals(76.0, new Student("Ayşe", 70, 80).total(), 1e-9);
    }

    @Test
    void averageOfTwo() {
        GradeBook book = new GradeBook();
        book.add(new Student("Ayşe", 70, 80));
        book.add(new Student("Ali", 75, 60));
        assertEquals(72.5, book.averageMidterm(), 1e-9);
    }
}
