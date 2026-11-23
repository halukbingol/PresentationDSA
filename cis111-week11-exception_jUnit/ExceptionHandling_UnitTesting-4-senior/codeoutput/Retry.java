import java.io.IOException;

public class Retry {
	static int calls = 0;

	/** A service that fails twice, then works. */
	static String fetch() throws IOException {
		calls++;
		if (calls <= 2) {
			throw new IOException("timeout");
		}
		return "grades of 42 students";
	}

	public static void main(String[] args) throws InterruptedException {
		int wait = 100;                                  // milliseconds
		for (int attempt = 1; attempt <= 4; attempt++) {
			try {
				String data = fetch();
				System.out.println(attempt + ": " + data);
				return;
			} catch (IOException e) {
				System.out.println(attempt + ": " + e.getMessage() + ", wait " + wait + " ms");
				Thread.sleep(wait);
				wait = wait * 2;                             // exponential backoff
			}
		}
		System.out.println("giving up");
	}
}
