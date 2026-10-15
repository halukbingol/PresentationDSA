public class UseWalk {
    public static void main(String[] args) {
        Node<String> t = Node.example();
        System.out.println("preorder  " + Walk.toList(t, "pre"));
        System.out.println("inorder   " + Walk.toList(t, "in"));
        System.out.println("postorder " + Walk.toList(t, "post"));

        StringBuilder sb = new StringBuilder();
        Walk.preorder(t, v -> sb.append(v.toLowerCase()));      // any action
        System.out.println("lower case, preorder: " + sb);

        int[] count = {0};
        Walk.inorder(t, v -> count[0]++);
        System.out.println("counted " + count[0] + " nodes");
    }
}
