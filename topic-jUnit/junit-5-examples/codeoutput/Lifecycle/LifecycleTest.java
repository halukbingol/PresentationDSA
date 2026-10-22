import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LifecycleTest {
    private int counter = 0;

    LifecycleTest() {
        System.out.println("  new LifecycleTest()");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("  @BeforeEach");
    }

    @Test
    void first() {
        counter++;
        System.out.println("    first, counter = " + counter);
    }

    @Test
    void second() {
        counter++;
        System.out.println("    second, counter = " + counter);
    }

    @AfterEach
    void afterEach() {
        System.out.println("  @AfterEach");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll");
    }
}
