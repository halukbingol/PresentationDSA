import java.util.Arrays;

/** A char[] password can be wiped; a String cannot. */
public class ClearSecret {
	static boolean check(char[] pw) {
		return Arrays.equals(pw, "s3cret".toCharArray());
	}

	public static void main(String[] args) {
		char[] pw = {'s', '3', 'c', 'r', 'e', 't'};
		try {
			System.out.println("valid: " + check(pw));
		} finally {
			Arrays.fill(pw, '\0');         // wipe it
		}
		String s = Arrays.toString(pw).replace('\0', '_');
		System.out.println("after: " + s);
	}
}
