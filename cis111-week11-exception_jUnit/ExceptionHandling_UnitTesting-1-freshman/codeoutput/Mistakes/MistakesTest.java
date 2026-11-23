import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MistakesTest {

	@Test
	void a_rightOrder() {
		assertEquals(212.0, Temperature.toFahrenheit(100), 1e-9);
	}

	@Test
	void b_swapped() {          // actual first!
		assertEquals(Temperature.toFahrenheit(100), 212.0, 1e-9);
	}

	void c_noAnnotation() {     // no @Test
		assertEquals(212.0, Temperature.toFahrenheit(100), 1e-9);
	}

	@Test
	void d_noAssert() {         // no assert
		Temperature.toFahrenheit(100);
	}

	@Test
	void e_sameCallTwice() {    // code vs code
		assertEquals(Temperature.toFahrenheit(100),
				Temperature.toFahrenheit(100));
	}

	@Test
	void f_exceptionByHand() {  // no fail()
		try {
			Temperature.coldest(new double[] {1});
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
}
