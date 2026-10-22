import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TaggedTest {
    @Test
    void fast() {
        assertEquals(4, 2 + 2);
    }

    @Test
    @Tag("slow")
    void slow() throws InterruptedException {
        Thread.sleep(1500);
        assertTrue(true);
    }

    @Test
    @Tag("database")
    void needsADatabase() {
        assertNotNull(System.getenv("DATABASE_URL"), "DATABASE_URL");
    }
}
