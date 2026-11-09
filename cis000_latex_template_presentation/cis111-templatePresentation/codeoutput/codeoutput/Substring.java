public class Substring {
    public static void main(String[] args) {
        String s = "Hello, World";
        System.out.println(s.substring(7));        // to the end
        System.out.println(s.substring(0, 5));     // [0, 5)
        System.out.println(s.substring(7, 12));
        System.out.println(s.substring(3, 3).isEmpty());
        String file = "report.final.pdf";
        int dot = file.lastIndexOf('.');
        System.out.println(file.substring(0, dot));
        System.out.println(file.substring(dot + 1));
    }
}
