import java.util.NoSuchElementException;

public class FindThrow {
	public static void main(String[] args) {
		String[] names = {"Ada", "Alan", "Grace"};
		int[] ages = {36, 41, 85};
		System.out.println(ages[find(names, "Grace")]);
		System.out.println(ages[find(names, "Linus")]);
	}

	static int find(String[] a, String x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(x)) {
				return i;
			}
		}
		throw new NoSuchElementException("no name " + x);
	}
}
