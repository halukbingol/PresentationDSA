public class Props {
    public static void main(String[] args) {
        String g = System.getProperty("greeting", "Hello"); // -D
        String c = System.getenv("COURSE");                 // env
        System.out.println(g + " from " + (c == null ? "?" : c));
        System.out.println(System.getProperty("os.name")
                + ", path.separator = "
                + System.getProperty("path.separator"));
    }
}
