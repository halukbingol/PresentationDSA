public class Leaky {
	static final String DB = "jdbc:mysql://10.0.0.7/grades?user=admin&password=S3cret!";

	public static void main(String[] args) {
		try {
			findStudent("20261234");
		} catch (IllegalStateException e) {
			System.out.println("Error: " + e.getMessage());     // shown to the user
		}
	}

	static String findStudent(String id) {
		throw new IllegalStateException("cannot connect to " + DB + " for id " + id);
	}
}
