public class UseBst {
    public static void main(String[] args) {
        Bst<Integer> t = new Bst<>();
        for (int k : new int[] {50, 30, 70, 20, 40, 60, 80, 35}) t.insert(k);
        System.out.print(t.sideways());
        System.out.print("for-each (inorder):");
        for (int k : t) System.out.print(" " + k);
        System.out.println("\ncontains 60? " + t.contains(60) + "   contains 65? " + t.contains(65));

        t.delete(20);                         // a leaf
        t.delete(40);                         // one child (35)
        t.delete(50);                         // two children: the root
        System.out.println("after deleting 20, 40, 50:");
        System.out.print(t.sideways());
    }
}
