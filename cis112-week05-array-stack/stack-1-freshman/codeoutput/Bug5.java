public class Bug5 {
    static int[] a = new int[3];
    static int top = -1;

    static void push(int x) { a[++top] = x; }
    static int pop()        { return a[top--]; }

    static void print() {
        for (int i = 0; i < a.length; i++)    // BUG: should stop at top
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        pop();
        pop();
        print();
    }
}
