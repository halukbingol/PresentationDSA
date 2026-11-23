import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LifecycleTest {
	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll: once");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("  beforeEach");
	}

	@Test
	void first() {
		System.out.println("    first");
	}

	@Test
	void second() {
		System.out.println("    second");
	}

	@AfterEach
	void afterEach() {
		System.out.println("  afterEach");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("afterAll: once");
	}
}
