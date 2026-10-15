public class Bug4 {
    static int[] a = new int[3];
    static int top = -1;

    static void push(int x) {
        if (top == a.length) {          // BUG: full is top == a.length - 1
            System.out.println("full!");
            return;
        }
        a[++top] = x;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            push(i);
            System.out.println("pushed " + i);
        }
    }
}
