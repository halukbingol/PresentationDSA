public class FindReturn {
	public static void main(String[] args) {
		String[] names = {"Ada", "Alan", "Grace"};
		int[] ages = {36, 41, 85};
		int i = find(names, "Linus");             // -1: not found
		if (i == -1) {                            // the caller checks ...
			System.out.println("checked: not found");
		} else {
			System.out.println("checked: " + ages[i]);
		}
		System.out.println("unchecked: " + ages[find(names, "Linus")]);   // ... or forgets
	}

	static int find(String[] a, String x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(x)) {
				return i;
			}
		}
		return -1;
	}
}
