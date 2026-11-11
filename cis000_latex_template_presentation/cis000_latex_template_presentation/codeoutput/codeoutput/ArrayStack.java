/** A stack of int values in an array. */
public class ArrayStack {
    private int[] a = new int[4];
    private int top = 0;              // number of elements

    public void push(int x) {
        if (top == a.length) {        // full: double the array
            a = java.util.Arrays.copyOf(a, 2 * a.length);
        }
        a[top++] = x;
    }

    public int pop() {
        if (top == 0) throw new IllegalStateException("empty stack");
        return a[--top];
    }

    public boolean isEmpty() { return top == 0; }

    public static void main(String[] args) {
        ArrayStack s = new ArrayStack();
        for (int x : new int[] {15, 6, 2, 9}) s.push(x);
        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());
        s.push(17);
        while (!s.isEmpty()) System.out.print(s.pop() + " ");
        System.out.println();
    }
}
