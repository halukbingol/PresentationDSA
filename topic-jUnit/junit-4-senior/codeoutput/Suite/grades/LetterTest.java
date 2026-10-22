package grades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LetterTest {
    @Test
    @Tag("fast")
    void aa() {
        assertEquals("AA", 95 >= 90 ? "AA" : "BB");
    }

    @Test
    @Tag("slow")
    void wholeYearOfData() throws InterruptedException {
        Thread.sleep(2000);
    }
}
