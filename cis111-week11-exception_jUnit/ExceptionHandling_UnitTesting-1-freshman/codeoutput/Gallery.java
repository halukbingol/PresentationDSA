import java.util.Scanner;

public class Gallery {
	public static void main(String[] args) {
		for (int k = 1; k <= 10; k++) {
			try {
				cause(k);
			} catch (RuntimeException e) {
				System.out.println(k + ". " + e);
			}
		}
	}

	static void cause(int k) {
		int[] a = {7, 8, 9};
		String name = null;
		int zero = 0;
		if (k == 1) {
			System.out.println(10 / zero);
		} else if (k == 2) {
			a[3] = 1;
		} else if (k == 3) {
			"Ada".charAt(5);
		} else if (k == 4) {
			name.length();
		} else if (k == 5) {
			Integer.parseInt("12a");
		} else if (k == 6) {
			new Scanner("abc").nextInt();
		} else if (k == 7) {
			new Scanner("").nextLine();
		} else if (k == 8) {
			int[] b = new int[-1];
		} else if (k == 9) {
			"Ada".substring(2, 1);
		} else {
			"-".repeat(-1);
		}
	}
}
