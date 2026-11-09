import java.util.LinkedList;

public class JavaContainers {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("b");
        list.addFirst("a");
        list.addLast("c");

        System.out.println("list:       " + list);
        System.out.println("getFirst(): " + list.getFirst());
        System.out.println("getLast():  " + list.getLast());

        // Peel from the tail. Each removeLast() is O(1) because of prev;
        // a singly linked list would have to walk from head every time.
        System.out.print("peel:       ");
        while (!list.isEmpty()) {
            System.out.print(list.removeLast() + " ");
        }
        System.out.println();
        System.out.println("list:       " + list);
    }
}
