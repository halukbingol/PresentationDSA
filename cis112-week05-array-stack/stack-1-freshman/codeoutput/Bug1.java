public class Bug1 {
    static int[] a = new int[3];
    static int top = -1;

    static void push(int x) {
        a[top++] = x;          // BUG: should be a[++top]
    }

    public static void main(String[] args) {
        push(10);
        System.out.println("pushed 10");
    }
}
