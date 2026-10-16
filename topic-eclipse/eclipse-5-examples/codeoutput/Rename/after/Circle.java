public class Circle {
    private static final double PI = 3.14159;

    public static void main(String[] args) {
        double radius = 2;
        System.out.println(area(radius));
        System.out.println(2 * PI * radius);
    }

    private static double area(double radius) {
        return PI * radius * radius;
    }
}
