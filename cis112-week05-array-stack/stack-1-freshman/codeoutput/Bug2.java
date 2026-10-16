public class Bug2 {
    static int[] a = new int[3];
    static int top = -1;

    static void push(int x) { a[++top] = x; }

    static int pop() {
        return a[top];         // BUG: top is never decreased
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        System.out.println(pop() + " " + pop() + " " + pop());
    }
}
