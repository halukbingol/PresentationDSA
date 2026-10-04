public class Props {
    public static void main(String[] args) {
        System.out.println("greeting  : " + System.getProperty("greeting", "Hello"));
        System.out.println("COURSE    : " + System.getenv("COURSE"));
        System.out.println("java      : " + System.getProperty("java.version"));
        System.out.println("os.name   : " + System.getProperty("os.name"));
        System.out.println("separators: " + System.getProperty("file.separator")
                + " and " + System.getProperty("path.separator"));
    }
}
