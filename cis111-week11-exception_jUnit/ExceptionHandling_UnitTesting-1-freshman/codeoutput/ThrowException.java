public class ThrowException {
	public static void main(String[] args) {
		System.out.println(area(3, 4));
	}

	static int area(int w, int h) {
		if (w < 0 || h < 0) {
			throw new Exception("negative side");
		}
		return w * h;
	}
}
