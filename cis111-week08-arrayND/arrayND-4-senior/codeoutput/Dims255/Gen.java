/** Prints a class with one field of n dimensions: java Gen.java n */
public class Gen {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println("public class D" + n + " { int" + "[]".repeat(n) + " x; }");
	}
}
