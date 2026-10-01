public class Strings {
    public static void main(String[] args) {
        String s = "Yeditepe University";
        System.out.println(s.length());
        System.out.println(s.charAt(0));
        System.out.println(s.substring(9));
        System.out.println(s.toUpperCase());
        System.out.println(s.indexOf("Uni"));

        String a = "java";
        String b = new String("java");
        System.out.println(a == b);       // compares references!
        System.out.println(a.equals(b));  // compares contents

        System.out.println(String.format("%-6s|%5.2f|", "pi", Math.PI));
    }
}
