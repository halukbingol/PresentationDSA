import java.util.List;

public class Hello {
    public static void main(String[] args) {
        List<String> courses = List.of("CSE 101", "CSE 211", "CSE 344");
        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, courses.get(i));
        }
        System.out.println("Total: " + courses.size() + " courses");
    }
}
