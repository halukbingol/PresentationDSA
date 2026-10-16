public class UseStack {
    public static void main(String[] args) {
        StackADT<String> s = new ArrayStack<>();      // program to the interface
        for (String w : "to be or not".split(" ")) s.push(w);
        System.out.println(s + "  size " + s.size());

        for (String w : s) System.out.print(w + " ");  // Iterable: for-each works
        System.out.println();

        while (!s.isEmpty()) System.out.print(s.pop() + " ");
        System.out.println();

        try {
            s.peek();
        } catch (StackUnderflowException e) {
            System.out.println("caught: " + e.getMessage());
        }
    }
}
