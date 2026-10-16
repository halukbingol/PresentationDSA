public class Underflow {
    public static void main(String[] args) {
        IntStack s = new IntStack(3);
        s.push(1);
        System.out.println(s.pop());
        System.out.println(s.pop());     // nothing left
    }
}
