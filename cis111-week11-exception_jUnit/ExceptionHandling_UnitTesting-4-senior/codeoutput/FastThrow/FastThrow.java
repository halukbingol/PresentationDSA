public class FastThrow {
	public static void main(String[] args) {
		String text = null;
		for (int i = 1; i <= 200_000; i++) {
			try {
				text.length();                     // the same NPE, again and again
			} catch (NullPointerException e) {
				if (e.getStackTrace().length == 0) {
					System.out.println("call " + i + ": message " + e.getMessage()
							+ ", " + e.getStackTrace().length + " frames");
					return;
				}
			}
		}
		System.out.println("every exception kept its trace");
	}
}
