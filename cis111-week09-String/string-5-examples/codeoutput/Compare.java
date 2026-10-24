public class Compare {
    public static void main(String[] args) {
        String a = "java";
        String b = "Java";
        String c = new String("java");
        System.out.println(a == c);  // same object?
        System.out.println(a.equals(c));           // same text?
        System.out.println(a.equals(b));
        System.out.println(a.equalsIgnoreCase(b));
        System.out.println(a.compareTo(b));        // 'j' - 'J'
        System.out.println("apple".compareTo("banana"));
        System.out.println("app".compareTo("apple"));
        System.out.println(b.compareToIgnoreCase(a));
    }
}
