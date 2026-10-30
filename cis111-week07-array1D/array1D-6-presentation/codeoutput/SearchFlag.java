public class SearchFlag {
	public static void main(String[] args) {
		int[] scores = {72, 85, 90, 64, 95};
		int wanted = 64;
		int pos = 0;
		boolean found = false;
		while (pos < scores.length && !found) {
			if (scores[pos] == wanted) {
				found = true;               // stop here
			} else {
				pos++;                      // look further
			}
		}
		if (found) { System.out.println("at index " + pos); }
		else       { System.out.println("not found"); }
	}
}
