public class LinkList {
    private Link first;

    public LinkList() { first = null; }
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }
    public Link deleteFirst() {
        if (first == null) return null;
        Link temp = first;
        first = first.next;
        return temp;
    }
    public void displayList() {
        System.out.print("List (first-->last): ");
        for (Link current = first; current != null; current = current.next)
            current.displayLink();
        System.out.println();
    }
    public Link find(int key) {
        for (Link current = first; current != null; current = current.next)
            if (current.iData == key) return current;
        return null;
    }
    public Link delete(int key) {
        Link current = first, previous = null;
        while (current != null && current.iData != key) {
            previous = current;
            current = current.next;
        }
        if (current == null) return null;
        if (previous == null) first = first.next;
        else previous.next = current.next;
        return current;
    }
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insertFirst(1, 1.0);
        list.insertFirst(2, 2.0);
        list.insertFirst(3, 3.0);
        list.displayList();
        System.out.println("find 2 -> " + (list.find(2) != null));
        System.out.println("find 9 -> " + (list.find(9) != null));
        System.out.println("delete 2 -> " + (list.delete(2) != null));
        list.displayList();
        list.deleteFirst();
        list.displayList();
    }
}
