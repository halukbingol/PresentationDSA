public class TryScope {
	public static void main(String[] args) {
		try {
			int n = Integer.parseInt("42");
		} catch (NumberFormatException e) {
			System.out.println("not a number");
		}
		System.out.println(n + 1);
	}
}
