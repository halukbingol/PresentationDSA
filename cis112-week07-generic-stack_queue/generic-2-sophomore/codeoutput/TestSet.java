public class TestSet {
    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>(2);
        System.out.println(s.add("apple"));   // true
        System.out.println(s.add("banana"));  // true
        System.out.println(s.add("apple"));   // false: duplicate
        System.out.println(s);
        System.out.println("contains(\"banana\") = " + s.contains("banana"));
        System.out.println("remove(\"apple\")  = " + s.remove("apple"));
        System.out.println(s);
        System.out.println("size = " + s.size());
    }
}