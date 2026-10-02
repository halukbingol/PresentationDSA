import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] grades = {78, 91, 64, 85, 70};
        System.out.println("length: " + grades.length);
        System.out.println("first: " + grades[0]);
        System.out.println("last: " + grades[grades.length - 1]);

        grades[2] = 66;        // change one element
        Arrays.sort(grades);
        System.out.println(Arrays.toString(grades));
    }
}
