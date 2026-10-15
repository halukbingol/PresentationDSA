import java.util.*;

public class Serialize {
    static String write(Node<String> t) {                // preorder, # for null
        return t == null ? "#" : t.value + " " + write(t.left) + " " + write(t.right);
    }

    static Node<String> read(Iterator<String> tokens) {
        String s = tokens.next();
        if (s.equals("#")) return null;
        Node<String> left = read(tokens);
        Node<String> right = read(tokens);
        return new Node<>(s, left, right);
    }

    public static void main(String[] args) {
        String text = write(Node.example());
        System.out.println(text);
        Node<String> copy = read(Arrays.asList(text.split(" ")).iterator());
        System.out.println("read back, written again: " + write(copy).equals(text));
    }
}
