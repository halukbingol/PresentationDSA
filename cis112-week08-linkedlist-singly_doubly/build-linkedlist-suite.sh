#!/usr/bin/env bash
set -euo pipefail

# ------------------------------------------------------------------
# linkedlist-0-concepts / codeoutput
# ------------------------------------------------------------------
mkdir -p linkedlist-0-concepts/codeoutput
cd linkedlist-0-concepts/codeoutput

cat > NodeChain.java <<'EOF'
public class NodeChain {
    static class Node {
        final int item; final Node next;
        Node(int item, Node next) { this.item = item; this.next = next; }
    }
    public static void main(String[] args) {
        Node third = new Node(30, null);
        Node second = new Node(20, third);
        Node first  = new Node(10, second);
        for (Node p = first; p != null; p = p.next)
            System.out.println(p.item);
    }
}
EOF
cat > StackOnNodes.java <<'EOF'
public class StackOnNodes {
    static class Node { final int item; final Node next;
        Node(int item, Node next) { this.item = item; this.next = next; } }
    Node top;
    void push(int x) { top = new Node(x, top); }
    int pop() {
        if (top == null) throw new RuntimeException("underflow");
        int x = top.item; top = top.next; return x;
    }
    boolean isEmpty() { return top == null; }
    public static void main(String[] args) {
        StackOnNodes s = new StackOnNodes();
        s.push(1); s.push(2); s.push(3);
        while (!s.isEmpty()) System.out.println(s.pop());
    }
}
EOF
cat > QueueOnNodes.java <<'EOF'
public class QueueOnNodes {
    static class Node { final int item; Node next;
        Node(int item) { this.item = item; } }
    Node head, tail;
    void enqueue(int x) {
        Node n = new Node(x);
        if (tail == null) { head = tail = n; }
        else { tail.next = n; tail = n; }
    }
    int dequeue() {
        if (head == null) throw new RuntimeException("underflow");
        int x = head.item; head = head.next;
        if (head == null) tail = null;
        return x;
    }
    boolean isEmpty() { return head == null; }
    public static void main(String[] args) {
        QueueOnNodes q = new QueueOnNodes();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        while (!q.isEmpty()) System.out.println(q.dequeue());
    }
}
EOF
cat > JavaContainers.java <<'EOF'
import java.util.LinkedList;
import java.util.Deque;
import java.util.Queue;

public class JavaContainers {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(2); list.addFirst(1); list.addLast(3);
        System.out.println("list: " + list);
        Deque<Integer> dq = list;
        System.out.println("deque: " + dq);
        Queue<Integer> q = list;
        q.offer(4); System.out.println("queue: " + q);
    }
}
EOF

# capture
for f in NodeChain StackOnNodes QueueOnNodes JavaContainers; do
  javac $f.java
  { echo "\$ javac $f.java"; echo "\$ java $f"; java $f; } > $f.txt
done
cd ../..

# ------------------------------------------------------------------
# linkedlist-1-freshman / codeoutput
# ------------------------------------------------------------------
mkdir -p linkedlist-1-freshman/codeoutput
cd linkedlist-1-freshman/codeoutput

cat > Link.java <<'EOF'
public class Link {
    public int iData;
    public double dData;
    public Link next;
    public Link(int id, double dd) { iData = id; dData = dd; }
    public void displayLink() {
        System.out.print("[" + iData + ", " + dData + "] ");
    }
}
EOF

cat > LinkedList.java <<'EOF'
public class LinkedList {
    private Link first;

    public LinkedList() { first = null; }

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
        LinkedList list = new LinkedList();
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
EOF

cat > FirstLastList.java <<'EOF'
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
EOF

cat > Bug1.java <<'EOF'
public class Bug1 {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        // BUG: no check for empty
        System.out.println(list.deleteFirst().iData);
    }
}
EOF

cat > Bug2.java <<'EOF'
public class Bug2 {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insertFirst(1, 1.0);
        list.insertFirst(2, 2.0);
        // BUG: forgot to update first, so this loses the list
        Link head = list.find(2);
        head.next = list.find(1);
        System.out.println("...");
    }
}
EOF

cat > Bug3.java <<'EOF'
public class Bug3 {
    public static void main(String[] args) {
        Link a = new Link(1, 1.0);
        Link b = new Link(2, 2.0);
        // BUG: assignment order matters
        a.next = b.next; b.next = a;   // wrong: b.next is now null
        System.out.println(a.iData + " " + b.iData);
    }
}
EOF

cat > Typos.txt <<'EOF'
$ javac Bug1.java
Bug1.java:5: error: cannot find symbol
        System.out.println(list.deleteFirst().iData);
                                ^
  symbol:   method deleteFirst()
  location: variable list of type LinkList
EOF

for f in LinkList FirstLastList; do
  javac $f.java
  { echo "\$ javac $f.java"; echo "\$ java $f"; java $f; } > $f.txt
done
javac Bug1.java 2> Bug1.txt || true
javac Bug2.java 2> Bug2.txt || true
javac Bug3.java 2> Bug3.txt || true
cd ../..

# ------------------------------------------------------------------
# linkedlist-2-sophomore / codeoutput
# ------------------------------------------------------------------
mkdir -p linkedlist-2-sophomore/codeoutput
cd linkedlist-2-sophomore/codeoutput

cat > LinkedListADT.java <<'EOF'
public interface LinkedListADT<T> {
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    boolean contains(T item);
    boolean isEmpty();
    int size();
}
EOF

cat > SinglyLinked.java <<'EOF'
import java.util.NoSuchElementException;

public class SinglyLinked<T> implements LinkedListADT<T>, Iterable<T> {
    private static final class Node<T> {
        final T item; Node<T> next;
        Node(T item, Node<T> next) { this.item = item; this.next = next; }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T item) {
        head = new Node<>(item, head);
        if (tail == null) tail = head;
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new NoSuchElementException();
        T x = head.item;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return x;
    }

    public boolean contains(T item) {
        for (Node<T> p = head; p != null; p = p.next)
            if (p.item.equals(item)) return true;
        return false;
    }

    public void addLast(T item) {
        Node<T> n = new Node<>(item, null);
        if (tail == null) head = tail = n; else { tail.next = n; tail = n; }
        size++;
    }

    public T removeLast() {
        if (tail == null) throw new NoSuchElementException();
        if (head == tail) { T x = head.item; head = tail = null; size--; return x; }
        Node<T> p = head;
        while (p.next != tail) p = p.next;
        T x = tail.item;
        p.next = null; tail = p; size--;
        return x;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            Node<T> p = head;
            public boolean hasNext() { return p != null; }
            public T next() {
                if (p == null) throw new NoSuchElementException();
                T x = p.item; p = p.next; return x;
            }
        };
    }

    public static void main(String[] args) {
        SinglyLinked<Integer> s = new SinglyLinked<>();
        s.addFirst(1); s.addFirst(2); s.addLast(3);
        System.out.println("contains 2: " + s.contains(2));
        for (int x : s) System.out.println(x);
        System.out.println("removeFirst: " + s.removeFirst());
        System.out.println("removeLast:  " + s.removeLast());
    }
}
EOF

cat > DoublyLinked.java <<'EOF'
import java.util.NoSuchElementException;

public class DoublyLinked<T> {
    private static final class Node<T> {
        T item; Node<T> next, prev;
        Node(T item) { this.item = item; }
    }
    private Node<T> head, tail;
    private int size;

    public void addFirst(T item) {
        Node<T> n = new Node<>(item);
        if (head == null) head = tail = n;
        else { n.next = head; head.prev = n; head = n; }
        size++;
    }

    public void addLast(T item) {
        Node<T> n = new Node<>(item);
        if (tail == null) head = tail = n;
        else { n.prev = tail; tail.next = n; tail = n; }
        size++;
    }

    public boolean remove(T item) {
        for (Node<T> p = head; p != null; p = p.next) {
            if (!p.item.equals(item)) continue;
            if (p.prev == null) head = p.next; else p.prev.next = p.next;
            if (p.next == null) tail = p.prev; else p.next.prev = p.prev;
            size--;
            return true;
        }
        return false;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public static void main(String[] args) {
        DoublyLinked<String> d = new DoublyLinked<>();
        d.addFirst("b"); d.addFirst("a"); d.addLast("c");
        System.out.println("size: " + d.size());
        System.out.println("remove b: " + d.remove("b"));
        System.out.println("remove z: " + d.remove("z"));
    }
}
EOF

cat > TestIterator.java <<'EOF'
public class TestIterator {
    public static void main(String[] args) {
        SinglyLinked<String> s = new SinglyLinked<>();
        s.addFirst("one"); s.addFirst("two"); s.addFirst("three");
        StringBuilder sb = new StringBuilder();
        for (String w : s) sb.append(w).append(' ');
        System.out.println("for-each: " + sb.toString().trim());
    }
}
EOF

cat > TestDoubly.java <<'EOF'
public class TestDoubly {
    public static void main(String[] args) {
        DoublyLinked<Integer> d = new DoublyLinked<>();
        for (int i = 1; i <= 3; i++) d.addLast(i);
        System.out.println("size: " + d.size());
        System.out.println("remove 2: " + d.remove(2));
        System.out.println("size: " + d.size());
    }
}
EOF

for f in SinglyLinked DoublyLinked TestIterator TestDoubly; do
  javac $f.java
  { echo "\$ javac $f.java"; echo "\$ java $f"; java $f; } > $f.txt
done
cd ../..

# ------------------------------------------------------------------
# linkedlist-3-junior / codeoutput
# ------------------------------------------------------------------
mkdir -p linkedlist-3-junior/codeoutput
cd linkedlist-3-junior/codeoutput

cat > BenchArrayVsLinked.java <<'EOF'
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BenchArrayVsLinked {
    static final int N = 1_000_000;
    public static void main(String[] args) {
        long t0 = System.nanoTime();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < N; i++) a.add(i);
        long sum = 0;
        for (int i = 0; i < N; i++) sum += a.get(i);
        long t1 = System.nanoTime();

        List<Integer> l = new LinkedList<>();
        long t2 = System.nanoTime();
        for (int i = 0; i < N; i++) l.add(i);
        long sum2 = 0;
        for (int i = 0; i < N; i++) sum2 += l.get(i);
        long t3 = System.nanoTime();

        System.out.printf("ArrayList  get(): %4d ms (sum %d)%n", (t1 - t0) / 1_000_000, sum);
        System.out.printf("LinkedList get(): %4d ms (sum %d)%n", (t3 - t2) / 1_000_000, sum2);
    }
}
EOF

cat > ReverseInPlace.java <<'EOF'
public class ReverseInPlace {
    static class Node { final int item; Node next;
        Node(int item, Node next) { this.item = item; this.next = next; } }

    static Node reverse(Node head) {
        Node prev = null, cur = head;
        while (cur != null) {
            Node n = cur.next;
            cur.next = prev;
            prev = cur;
            cur = n;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        head = reverse(head);
        for (Node p = head; p != null; p = p.next) System.out.print(p.item + " ");
        System.out.println();
    }
}
EOF

cat > CycleDetect.java <<'EOF'
public class CycleDetect {
    static class Node { int item; Node next;
        Node(int item) { this.item = item; } }

    static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node a = new Node(1), b = new Node(2), c = new Node(3);
        a.next = b; b.next = c; c.next = a;
        System.out.println("cycle: " + hasCycle(a));
        Node x = new Node(1), y = new Node(2);
        x.next = y;
        System.out.println("cycle: " + hasCycle(x));
    }
}
EOF

cat > MergeSorted.java <<'EOF'
public class MergeSorted {
    static class Node { final int item; Node next;
        Node(int item) { this.item = item; } }

    static Node merge(Node a, Node b) {
        Node dummy = new Node(0), t = dummy;
        while (a != null && b != null) {
            if (a.item <= b.item) { t.next = a; a = a.next; }
            else                   { t.next = b; b = b.next; }
            t = t.next;
        }
        t.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node a = new Node(1); a.next = new Node(4);
        Node b = new Node(2); b.next = new Node(3);
        Node m = merge(a, b);
        for (Node p = m; p != null; p = p.next) System.out.print(p.item + " ");
        System.out.println();
    }
}
EOF

cat > MiddleElement.java <<'EOF'
public class MiddleElement {
    static class Node { final int item; Node next;
        Node(int item, Node next) { this.item = item; this.next = next; } }

    static Node middle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        System.out.println("middle: " + middle(head).item);
    }
}
EOF

for f in BenchArrayVsLinked ReverseInPlace CycleDetect MergeSorted MiddleElement; do
  javac $f.java
  { echo "\$ javac $f.java"; echo "\$ java $f"; java $f; } > $f.txt
done
cd ../..

# ------------------------------------------------------------------
# linkedlist-4-senior / codeoutput
# ------------------------------------------------------------------
mkdir -p linkedlist-4-senior/codeoutput
cd linkedlist-4-senior/codeoutput

javap -p java.util.LinkedList | head -20 > JavapLinkedList.txt
javap -p java.util.ArrayList | head -20 > JavapArrayList.txt

cat > SentinelDemo.java <<'EOF'
public class SentinelDemo {
    static class Node {
        Integer item; Node next;
        Node(Integer item) { this.item = item; }
    }

    static Node head = new Node(null); // sentinel
    static void add(int x) {
        Node n = new Node(x);
        n.next = head.next; head.next = n;
    }
    static void print() {
        for (Node p = head.next; p != null; p = p.next) System.out.print(p.item + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        add(1); add(2); add(3);
        print();
    }
}
EOF

cat > MorrisTraversal.java <<'EOF'
public class MorrisTraversal {
    static class Node {
        int item; Node left, right;
        Node(int item) { this.item = item; }
    }

    static void inorder(Node root) {
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.item + " ");
                cur = cur.right;
            } else {
                Node p = cur.left;
                while (p.right != null && p.right != cur) p = p.right;
                if (p.right == null) { p.right = cur; cur = cur.left; }
                else {
                    p.right = null;
                    System.out.print(cur.item + " ");
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2); root.right = new Node(6);
        root.left.left = new Node(1); root.left.right = new Node(3);
        root.right.left = new Node(5); root.right.right = new Node(7);
        System.out.print("in-order: ");
        inorder(root);
    }
}
EOF

cat > MemoryLayout.java <<'EOF'
public class MemoryLayout {
    public static void main(String[] args) {
        long mb = 1024L * 1024;
        int n = 1_000_000;
        Runtime r = Runtime.getRuntime();

        long b0 = used(r);
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        long b1 = used(r) - b0;

        System.out.println("n = " + n);
        System.out.println("Integer[]: ~" + b1 / n + " bytes / element");
        System.out.println("free memory: ~" + r.freeMemory() / mb + " MB");
    }
    static long used(Runtime r) { System.gc(); return r.totalMemory() - r.freeMemory(); }
}
EOF

for f in SentinelDemo MorrisTraversal MemoryLayout; do
  javac $f.java
  { echo "\$ javac $f.java"; echo "\$ java $f"; java $f; } > $f.txt
done
cd ../..

# ------------------------------------------------------------------
# linkedlist-5-examples / codeoutput
# ------------------------------------------------------------------
mkdir -p linkedlist-5-examples/codeoutput
cd linkedlist-5-examples/codeoutput

cat > Stutter.java <<'EOF'
import java.util.LinkedList;

public class Stutter {
    static void stutter(LinkedList<Integer> list) {
        LinkedList<Integer> out = new LinkedList<>();
        for (int x : list) { out.add(x); out.add(x); }
        list.clear(); list.addAll(out);
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 4; i++) list.add(i);
        stutter(list);
        System.out.println(list);
    }
}
EOF

cat > Mirror.java <<'EOF'
import java.util.LinkedList;

public class Mirror {
    static void mirror(LinkedList<Integer> list) {
        LinkedList<Integer> copy = new LinkedList<>(list);
        java.util.Collections.reverse(copy);
        list.addAll(copy);
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 4; i++) list.add(i);
        mirror(list);
        System.out.println(list);
    }
}
EOF

cat > ReverseList.java <<'EOF'
public class ReverseList {
    static class Node { final int item; Node next;
        Node(int item, Node next) { this.item = item; this.next = next; } }
    static Node reverse(Node head) {
        Node prev = null, cur = head;
        while (cur != null) { Node n = cur.next; cur.next = prev; prev = cur; cur = n; }
        return prev;
    }
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        head = reverse(head);
        for (Node p = head; p != null; p = p.next) System.out.print(p.item + " ");
        System.out.println();
    }
}
EOF

cat > Palindrome.java <<'EOF'
import java.util.LinkedList;

public class Palindrome {
    static boolean isPalindrome(LinkedList<Character> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) if (!list.get(i++).equals(list.get(j--))) return false;
        return true;
    }
    public static void main(String[] args) {
        LinkedList<Character> a = new LinkedList<>(java.util.List.of('r','a','c','e','c','a','r'));
        LinkedList<Character> b = new LinkedList<>(java.util.List.of('a','b','c'));
        System.out.println(a + ": " + isPalindrome(a));
        System.out.println(b + ": " + isPalindrome(b));
    }
}
EOF

cat > Josephus.java <<'EOF'
import java.util.LinkedList;

public class Josephus {
    static int josephus(int n, int k) {
        LinkedList<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= n; i++) circle.add(i);
        int i = 0;
        while (circle.size() > 1) {
            i = (i + k - 1) % circle.size();
            circle.remove(i);
        }
        return circle.get(0);
    }
    public static void main(String[] args) {
        System.out.println("survivor: " + josephus(7, 3));
    }
}
EOF

cat > LruCache.java <<'EOF'
import java.util.LinkedHashMap;

public class LruCache {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> cache = new LinkedHashMap<>(3, 0.75f, true) {
            @Override protected boolean removeEldestEntry(java.util.Map.Entry<String, Integer> e) {
                return size() > 3;
            }
        };
        cache.put("a", 1); cache.put("b", 2); cache.put("c", 3);
        cache.get("a");
        cache.put("d", 4);   // evicts b (least recently used)
        System.out.println(cache);
    }
}
EOF

for f in Stutter Mirror ReverseList Palindrome Josephus LruCache; do
  javac $f.java
  { echo "\$ javac $f.java"; echo "\$ java $f"; java $f; } > $f.txt
done
cd ../..

echo "Done.  Six folders created."
