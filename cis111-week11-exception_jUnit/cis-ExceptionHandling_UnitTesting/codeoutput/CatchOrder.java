public class CatchOrder {
	public static void main(String[] args) {
		try {
			int i = Integer.parseInt("x");
			System.out.println(i);
		} catch (Exception e) {
			System.out.println("something went wrong");
		} catch (NumberFormatException e) {
			System.out.println("not a number");
		}
	}
}
