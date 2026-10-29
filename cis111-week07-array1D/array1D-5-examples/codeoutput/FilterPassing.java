public class FilterPassing {
	public static void main(String[] args) {
		int[] scores = {72, 45, 90, 58, 66, 39};
		int count = 0;                   // pass 1: count
		for (int s : scores) {
			if (s >= 60) {
				count++;
			}
		}
		int[] passing = new int[count];  // the right size
		int k = 0;                       // pass 2: copy
		for (int s : scores) {
			if (s >= 60) {
				passing[k] = s;
				k++;
			}
		}
		System.out.println(java.util.Arrays.toString(passing));
	}
}
