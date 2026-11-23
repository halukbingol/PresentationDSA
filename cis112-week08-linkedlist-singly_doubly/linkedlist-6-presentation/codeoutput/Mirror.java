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
