import java.util.Arrays;
public class Anatomy {
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64},
		             {55, 61, 70, 80},
		             {90, 88, 93, 99}};
		System.out.println(s.length);
		System.out.println(s[0].length);
		System.out.println(s[1][2]);
		System.out.println(Arrays.toString(s[1]));
		System.out.println(s[2][3]);
	}
}
