public class FailOpen {
	public static void main(String[] args) {
		String token = "corrupted";
		System.out.println("fail open:   may edit? " + canEditOpen(token));
		System.out.println("fail closed: may edit? " + canEditClosed(token));
	}

	static boolean canEditOpen(String token) {
		try {
			return checkToken(token);
		} catch (RuntimeException e) {
			return true;             // "never block a user"
		}
	}

	static boolean canEditClosed(String token) {
		try {
			return checkToken(token);
		} catch (RuntimeException e) {
			return false;            // in doubt: no
		}
	}

	static boolean checkToken(String token) {
		if (!token.startsWith("tok-")) {
			throw new IllegalArgumentException("malformed token");
		}
		return token.endsWith("-editor");
	}
}
