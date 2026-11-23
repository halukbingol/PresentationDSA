public class GenericArrayWarn {
    @SuppressWarnings("unchecked")
    static <T> T[] makeArray(int n) {
        return (T[]) new Object[n];
    }

    public static void main(String[] args) {
        String[] s = makeArray(3);
        s[0] = "ok";
        System.out.println("assigned ok");
        Object[] o = s;               // fine
        o[1] = 42;                    // BUG: Integer into a String[]
        System.out.println(s[1]);
    }
}