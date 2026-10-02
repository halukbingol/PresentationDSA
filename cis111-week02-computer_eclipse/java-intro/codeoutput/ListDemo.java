import java.util.ArrayList;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("CSE 101");
        courses.add("CSE 211");
        courses.add("MATH 151");
        System.out.println(courses + " size=" + courses.size());

        courses.remove("MATH 151");
        courses.add(1, "CSE 112");    // insert at index 1
        System.out.println(courses);
        System.out.println(courses.contains("CSE 211"));

        for (String c : courses) {
            System.out.println("- " + c);
        }
    }
}
