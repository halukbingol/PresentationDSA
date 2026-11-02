import java.util.Arrays;

public class MirrorIndex {
	static void reverse(int[] a) {
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			int temp = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = temp;
		}
	}

	static boolean isPalindrome(int[] a) {
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			if (a[i] != a[n - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		reverse(a);
		System.out.println("reversed: " + Arrays.toString(a));
		int[] p = {3, 1, 4, 1, 3};
		System.out.println("palindrome? " + isPalindrome(p));
	}
}
