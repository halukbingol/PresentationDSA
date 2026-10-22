import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParallelTest {
    void work(String name) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(name + " done");
    }

    @Test
    void a() throws InterruptedException {
        work("a");
    }

    @Test
    void b() throws InterruptedException {
        work("b");
    }

    @Test
    void c() throws InterruptedException {
        work("c");
    }

    @Test
    void d() throws InterruptedException {
        work("d");
    }
}
