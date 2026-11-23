public class CloseOrder {
	public static void main(String[] args) {
		try (Resource in = new Resource("input");
				Resource out = new Resource("output")) {
			System.out.println("use both");
			throw new IllegalStateException("a problem");
		} catch (IllegalStateException e) {
			System.out.println("catch: " + e.getMessage());
		}
	}

	static class Resource implements AutoCloseable {
		private final String name;

		Resource(String name) {
			this.name = name;
			System.out.println("open " + name);
		}

		@Override
		public void close() {
			System.out.println("close " + name);
		}
	}
}
