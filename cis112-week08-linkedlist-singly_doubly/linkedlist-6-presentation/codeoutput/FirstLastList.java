public class FirstLastList {
    private Link first;
    private Link last;
    public boolean isEmpty() { return first == null; }
    public void insertLast(int id, double dd) {
        Link newLink = new Link(id, dd);
        if (isEmpty()) first = newLink;
        else           last.next = newLink;
        last = newLink;
    }
    public Link deleteFirst() {
        if (first == null) return null;
        Link temp = first;
        first = first.next;
        if (first == null) last = null;
        return temp;
    }
    public void displayList() {
        System.out.print("FirstLastList: ");
        for (Link c = first; c != null; c = c.next) c.displayLink();
        System.out.println();
    }
    public static void main(String[] args) {
        FirstLastList list = new FirstLastList();
        list.insertLast(1, 1.0);
        list.insertLast(2, 2.0);
        list.insertLast(3, 3.0);
        list.displayList();
        System.out.println("deleteFirst -> " + list.deleteFirst().iData);
        list.displayList();
    }
}
