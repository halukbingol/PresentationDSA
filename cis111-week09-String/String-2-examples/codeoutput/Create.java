public class Create {
    public static void main(String[] args) {
        String a = "Yeditepe";                  // literal
        String b = new String("Yeditepe");      // new object
        char[] letters = {'J', 'a', 'v', 'a'};
        String c = new String(letters);         // from chars
        String d = String.valueOf(2026);        // from a number
        String e = "" + 3.14;  // by concatenation
        String f = """
            Faculty of Computer
            and Information Sciences""";        // text block
        System.out.println(a + " | " + b + " | " + c);
        System.out.println(d + " | " + e);
        System.out.println(f);
    }
}
