public class TestEverything {
    public static void main(String[] args) {
        ArrayStack<Integer> s = new ArrayStack<>(1);
        s.push(1); s.push(2); s.push(3);
        System.out.println("stack       = " + s + "  top = " + s.peek());

        ArrayQueue<String> q = new ArrayQueue<>(1);
        q.enqueue("A"); q.enqueue("B"); q.enqueue("C");
        System.out.println("queue       = " + q);

        ArraySet<String> set = new ArraySet<>(1);
        set.add("x"); set.add("y"); set.add("x");
        System.out.println("set         = " + set);

        System.out.println("all empty?  stack=" + s.isEmpty()
                         + " queue=" + q.isEmpty()
                         + " set="   + set.isEmpty());
    }
}