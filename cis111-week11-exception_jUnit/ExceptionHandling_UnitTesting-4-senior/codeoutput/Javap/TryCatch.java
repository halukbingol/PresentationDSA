public class TryCatch {
	static int parse(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return -1;
		} finally {
			done();
		}
	}

	static void done() {
		System.out.println("done");
	}
}
