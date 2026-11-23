import org.junit.jupiter.api.Test;

class InstanceTest {
	static int made = 0;                 // objects made so far
	int count = 0;                       // a field of this object

	InstanceTest() {
		made++;
	}

	@Test
	void first() {
		count++;
		System.out.println("    first:  count " + count + ", objects " + made);
	}

	@Test
	void second() {
		count++;
		System.out.println("    second: count " + count + ", objects " + made);
	}
}
