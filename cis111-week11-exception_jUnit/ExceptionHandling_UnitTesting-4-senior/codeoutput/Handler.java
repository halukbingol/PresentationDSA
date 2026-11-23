public class Handler {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler((thread, e) -> {
			String id = Integer.toHexString(e.hashCode() & 0xfff);  // incident number
			System.out.println("Sorry, something went wrong (incident " + id + ").");
			System.err.println("incident " + id + " in " + thread.getName() + ": " + e);
		});
		System.out.println("starting");
		Object[] report = new Object[2];
		System.out.println(report[1].toString());     // a bug
	}
}
