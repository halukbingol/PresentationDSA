/** A stack of int values in a fixed-size array. */
public class IntStack {
    private final int[] a;    // the elements are a[0] .. a[top]
    private int top = -1;     // index of the top element; -1 when empty

    public IntStack(int capacity) {
        a = new int[capacity];
    }

    public void push(int x) {
        if (top == a.length - 1) throw new IllegalStateException("overflow: stack is full");
        a[++top] = x;
    }

    public int pop() {
        if (top == -1) throw new IllegalStateException("underflow: stack is empty");
        return a[top--];
    }

    public int peek() {
        if (top == -1) throw new IllegalStateException("underflow: stack is empty");
        return a[top];
    }

    public boolean isEmpty() { return top == -1; }
    public int size()        { return top + 1; }

    @Override
    public String toString() {                // bottom ... top
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) sb.append(i > 0 ? ", " : "").append(a[i]);
        return sb.append("] <- top").toString();
    }
}
