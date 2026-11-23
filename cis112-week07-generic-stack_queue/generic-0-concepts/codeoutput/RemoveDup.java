import java.util.*;

public class RemoveDup {
	public static void main(String[] args) {
        
		String[] words = {"a", "b", "a", "c", "b", "d"};
		HashSet<String> set = new HashSet<>();

		for (int i=0; i<words.length; i++) {
			set.add(words[i]);
		}
		
		System.out.println("before: " + Arrays.toString(words));
		System.out.println("after:  " + set);
	}
}
