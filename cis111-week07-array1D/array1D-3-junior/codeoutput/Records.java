import java.util.Arrays;
import java.util.Comparator;

public class Records {
	record Student(String name, int score) { }

	public static void main(String[] args) {
		String[] names = {"Ayşe", "Mehmet", "Zeynep"};
		int[] scores = {72, 95, 64};       // parallel arrays
		Arrays.sort(scores);               // only one moves!
		System.out.println(names[0] + " " + scores[0]);

		Student[] all = {new Student("Ayşe", 72),
				new Student("Mehmet", 95),
				new Student("Zeynep", 64)};
		Arrays.sort(all, Comparator.comparingInt(
				Student::score).reversed());
		for (Student s : all) {
			System.out.println(s.name() + " " + s.score());
		}
	}
}
