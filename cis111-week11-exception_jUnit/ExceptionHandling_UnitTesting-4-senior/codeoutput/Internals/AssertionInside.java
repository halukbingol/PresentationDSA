import static org.junit.jupiter.api.Assertions.assertEquals;

import org.opentest4j.AssertionFailedError;

public class AssertionInside {
	public static void main(String[] args) {
		try {
			assertEquals("B", "C");                      // outside a test
		} catch (AssertionFailedError e) {
			System.out.println("message:  " + e.getMessage());
			System.out.println("expected: " + e.getExpected().getValue());
			System.out.println("actual:   " + e.getActual().getValue());
			Class<?> c = e.getClass();
			while (c != Object.class) {
				System.out.println("  is a " + c.getSimpleName());
				c = c.getSuperclass();
			}
		}
	}
}
