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
