import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class ReportTest {

	@Test
	void average() {
		ScoreSource fake = () -> new int[] {70, 80, 90};          // a stub: fixed answers
		assertEquals("3 scores, average 80", new Report(fake).summary());
	}

	@Test
	void empty() {
		assertEquals("no scores", new Report(() -> new int[0]).summary());
	}

	@Test
	void sourceFails() {
		ScoreSource broken = () -> {                              // a stub that fails
			throw new IOException("server down");
		};
		assertEquals("no data: server down", new Report(broken).summary());
	}

	@Test
	void readsOnlyOnce() {
		int[] calls = {0};
		ScoreSource spy = () -> {                                 // a spy: counts the calls
			calls[0]++;
			return new int[] {50};
		};
		new Report(spy).summary();
		assertEquals(1, calls[0]);
	}
}
