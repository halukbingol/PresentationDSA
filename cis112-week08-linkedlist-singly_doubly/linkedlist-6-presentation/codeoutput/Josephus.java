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
