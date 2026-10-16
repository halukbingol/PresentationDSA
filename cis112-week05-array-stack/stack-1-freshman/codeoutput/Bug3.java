public class Bug3 {
    static int[] a = new int[3];
    static int top = -1;

    static void push(int x) { a[++top] = x; }

    static int pop() {
        return a[top--];       // BUG: no check for an empty stack
    }

    public static void main(String[] args) {
        push(1);
        System.out.println(pop());
        System.out.println(pop());
    }
}
