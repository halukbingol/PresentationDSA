public class Brackets {
    static String check(String text) {
        ArrayStack<Character> s = new ArrayStack<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                s.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (s.isEmpty()) return "extra '" + c + "' at " + i;
                char open = s.pop();
                if ("([{".indexOf(open) != ")]}".indexOf(c))
                    return "'" + open + "' closed by '" + c + "' at " + i;
            }
        }
        return s.isEmpty() ? "balanced" : s.size() + " left open";
    }

    public static void main(String[] args) {
        String[] tests = {"(a[i] + b)", "{ [ ( ) ] }", "( ]", "( ( )", ") (", "f(a[0], {1, 2})"};
        for (String t : tests) System.out.printf("%-16s %s%n", t, check(t));
    }
}
