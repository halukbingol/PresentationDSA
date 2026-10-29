import java.util.Scanner;

public class ScanGrades {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useDelimiter("\\s*[,;\\n]\\s*");
        int sum = 0, count = 0;
        while (in.hasNext()) {
            if (in.hasNext("\\d{1,3}")) {
                sum += Integer.parseInt(in.next());
                count++;
            } else {
                System.out.println("skipped: " + in.next());
            }
        }
        System.out.println(count + " grades, average " + (double) sum / count);
    }
}
