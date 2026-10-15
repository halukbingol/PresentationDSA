public class AvlDemo {
    public static void main(String[] args) {
        Avl t = new Avl();
        for (int k = 1; k <= 7; k++) {
            t.insert(k);
            System.out.println("insert " + k + ": height " + Avl.h(t.root) + ", rotations so far " + t.rotations);
        }
        System.out.print(t.sideways());
    }
}
