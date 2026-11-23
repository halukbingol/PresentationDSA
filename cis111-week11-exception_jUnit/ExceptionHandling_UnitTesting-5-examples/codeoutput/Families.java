public class Families {
	public static void main(String[] args) {
		String[] cases = {"x", "-1", "null"};
		for (String c : cases) {
			try {
				run(c);
			} catch (IllegalArgumentException e) {   // and its family
				System.out.println(c + ": IllegalArgument...: "
						+ e.getClass().getSimpleName());
			} catch (RuntimeException e) {           // all others
				System.out.println(c + ": RuntimeException: "
						+ e.getClass().getSimpleName());
			}
		}
	}

	static void run(String c) {
		if (c.equals("x")) {
			Integer.parseInt(c);
		} else if (c.equals("-1")) {
			int[] a = new int[3];
			a[-1] = 0;
		} else {
			String s = null;
			s.length();
		}
	}
}
