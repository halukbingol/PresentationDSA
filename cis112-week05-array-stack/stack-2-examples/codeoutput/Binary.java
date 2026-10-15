public class Binary {
    static String toBinary(int n) {
        IntStack s = new IntStack(32);
        do {
            s.push(n % 2);         // remainders come out last digit first
            n = n / 2;
        } while (n > 0);
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) sb.append(s.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int n : new int[] {0, 5, 13, 2026}) {
            System.out.println(n + " = " + toBinary(n) + "   check: " + Integer.toBinaryString(n));
        }
    }
}
