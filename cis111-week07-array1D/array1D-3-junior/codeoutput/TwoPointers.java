import java.util.Arrays;

/** Two indices that walk toward each other. */
public class TwoPointers {
	static void reverse(int[] a) {
		int left = 0;
		int right = a.length - 1;
		while (left < right) {
			int temp = a[left];
			a[left] = a[right];
			a[right] = temp;
			left++;
			right--;
		}
	}

	static boolean isPalindrome(int[] a) {
		int left = 0;
		int right = a.length - 1;
		while (left < right) {
			if (a[left] != a[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		reverse(a);
		System.out.println(Arrays.toString(a));
		System.out.println(isPalindrome(new int[] {3, 1, 4, 1, 3}));
		System.out.println(isPalindrome(new int[] {3, 1, 4, 4, 1}));
	}
}
