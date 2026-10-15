public class Pool {
    public static void main(String[] args) {
        String a = "java";
        String b = "java";
        String c = new String("java");
        String d = "ja" + "va";          // constant
        String half = "ja";
        String e = half + "va";          // computed at run time
        System.out.println("a == b: " + (a == b));
        System.out.println("a == c: " + (a == c));
        System.out.println("a == d: " + (a == d));
        System.out.println("a == e: " + (a == e));
        System.out.println("intern: " + (a == e.intern()));
        System.out.println("a.equals(e): " + a.equals(e));
    }
}
