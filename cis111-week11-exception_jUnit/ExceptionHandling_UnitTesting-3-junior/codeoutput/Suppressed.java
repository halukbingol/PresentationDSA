public class Suppressed {
	static class Connection implements AutoCloseable {
		@Override
		public void close() {
			throw new IllegalStateException("close failed");
		}
	}

	public static void main(String[] args) {
		try (Connection c = new Connection()) {
			throw new IllegalArgumentException("work failed");
		} catch (RuntimeException e) {
			System.out.println("caught:     " + e);
			for (Throwable s : e.getSuppressed()) {
				System.out.println("suppressed: " + s);
			}
		}
	}
}
