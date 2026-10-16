public class ArrayTree {
    static String[] a = {"A", "B", "C", "D", "E", "F"};      // level by level

    static int left(int i)   { return 2 * i + 1; }
    static int right(int i)  { return 2 * i + 2; }
    static int parent(int i) { return (i - 1) / 2; }

    static void preorder(int i) {
        if (i >= a.length) return;                          // no such node
        System.out.print(a[i] + " ");
        preorder(left(i));
        preorder(right(i));
    }

    public static void main(String[] args) {
        for (int i = 0; i < a.length; i++) {
            String l = left(i) < a.length ? a[left(i)] : "-";
            String r = right(i) < a.length ? a[right(i)] : "-";
            String p = i > 0 ? a[parent(i)] : "-";
            System.out.printf("a[%d] = %s   left %s   right %s   parent %s%n", i, a[i], l, r, p);
        }
        System.out.print("preorder:    ");
        preorder(0);
        System.out.println();
        System.out.println("level order: the array itself, " + String.join(" ", a));
    }
}
