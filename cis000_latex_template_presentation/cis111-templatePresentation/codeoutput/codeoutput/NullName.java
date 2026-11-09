public class NullName {
    static String name;                      // not set: null

    public static void main(String[] args) {
        System.out.println("name is " + name);
        System.out.println(name.length());
    }
}
