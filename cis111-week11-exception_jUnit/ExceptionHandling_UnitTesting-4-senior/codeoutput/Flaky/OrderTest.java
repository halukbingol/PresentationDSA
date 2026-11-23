import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
class OrderTest {
	static int[] scores = {70, 80, 90};                 // shared by every test

	@Test
	void curve() {
		for (int i = 0; i < scores.length; i++) {
			scores[i] += 5;                                  // changes the shared array
		}
		assertEquals(75, scores[0]);
	}

	@Test
	void average() {
		assertEquals(80, (scores[0] + scores[1] + scores[2]) / 3);
	}
}
