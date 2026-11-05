import java.util.*;

public class CommonElements {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 5, 6, 7};

	Set<Integer> aSet = new HashSet<>();

	for (int i=0; i<a.length; i++) {
		aSet.add(a[i]);
	}

	Set<Integer> common = new HashSet<>();

	for (int i=0; i<b.length; i++) {
		if (aSet.contains(b[i])) {
			common.add(b[i]);	
		}
		
	}
	
        System.out.println(common);  // [3, 4, 5]
    }
}
