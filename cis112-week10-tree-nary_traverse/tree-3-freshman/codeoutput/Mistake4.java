public class Mistake4 {
    public static void main(String[] args) {
        IntNode root = new IntNode(8);
        IntNode a = new IntNode(3);
        IntNode b = new IntNode(10);
        root.left = a;
        root.left = b;                     // meant root.right
        System.out.println("left  " + root.left.value);
        System.out.println("right " + root.right.value);
    }
}
