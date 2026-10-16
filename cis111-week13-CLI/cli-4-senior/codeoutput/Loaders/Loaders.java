public class Loaders {
    public static void main(String[] args) throws Exception {
        show(Loaders.class);                          // our code
        show(Class.forName("java.sql.Driver"));       // JDK, not java.base
        show(String.class);                           // java.base
        ClassLoader l = Loaders.class.getClassLoader();
        for (; l != null; l = l.getParent())
            System.out.println("  chain: " + l.getName());
    }
    static void show(Class<?> c) {
        ClassLoader l = c.getClassLoader();
        System.out.printf("%-8s loaded by %s%n", c.getSimpleName(),
                          l == null ? "bootstrap" : l.getName());
    }
}
