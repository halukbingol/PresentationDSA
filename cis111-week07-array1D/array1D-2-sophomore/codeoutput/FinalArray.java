import java.util.Arrays;

public class FinalArray {
	static final int[] LIMITS = {50, 70, 90};

	public static void main(String[] args) {
		LIMITS[0] = 0;                 // allowed!
		System.out.println(Arrays.toString(LIMITS));
	}
}
