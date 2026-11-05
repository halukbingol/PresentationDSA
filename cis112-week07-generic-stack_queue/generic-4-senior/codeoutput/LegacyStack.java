import java.util.Stack;
import java.util.Vector;

public class LegacyStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1); s.push(2); s.push(3);

        Vector<Integer> v = s;                  // Stack IS-A Vector
        System.out.println("is Vector: " + (v == s));
        System.out.println("get(0) via Vector = " + v.get(0));

        System.out.println("search(2) = " + s.search(2));
        System.out.println("search(1) = " + s.search(1));

        v.add(0, 99);                           // insert at index 0 of a "stack"
        System.out.println("after add(0, 99): " + s);

        System.out.println("pop via Stack = " + s.pop());
    }
}