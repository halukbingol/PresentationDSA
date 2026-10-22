import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MessagesTest {
    record Student(String name, int midterm, int fin) { }

    Student ayse = new Student("Ayşe", 70, 80);

    @Test
    void oneAtATime() {
        assertEquals("Ayse", ayse.name(), "name");
        assertEquals(75, ayse.midterm(), "midterm");
    }

    @Test
    void allAtOnce() {
        assertAll("student",
                () -> assertEquals("Ayse", ayse.name(), "name"),
                () -> assertEquals(75, ayse.midterm(), "midterm"),
                () -> assertEquals(80, ayse.fin(), "final"));
    }
}
