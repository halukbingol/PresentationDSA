import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SharedStateTest {
    static List<String> names = new ArrayList<>();

    @Test
    @Order(1)
    void addsAName() {
        names.add("Ali");
        assertEquals(1, names.size());
    }

    @Test
    @Order(2)
    void startsEmpty() {
        assertTrue(names.isEmpty());
    }
}
