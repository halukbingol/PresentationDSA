public class Check {
    public static void main(String[] args) {
        int age = Integer.parseInt(args[0]);
        assert age >= 0 : "age must not be negative: " + age;
        System.out.println("age = " + age);
    }
}
