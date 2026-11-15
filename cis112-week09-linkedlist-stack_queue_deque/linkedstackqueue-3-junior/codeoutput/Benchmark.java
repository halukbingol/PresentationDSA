import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Benchmark {
    public static void main(String[] args) {
        int N = 10_000_000;
        
        long t0 = System.nanoTime();
        Deque<Integer> array = new ArrayDeque<>();
        for (int i = 0; i < N; i++) array.addLast(i);
        while (!array.isEmpty()) array.removeLast();
        long t1 = System.nanoTime();
        
        Deque<Integer> linked = new LinkedList<>();
        long t2 = System.nanoTime();
        for (int i = 0; i < N; i++) linked.addLast(i);
        while (!linked.isEmpty()) linked.removeLast();
        long t3 = System.nanoTime();
        
        System.out.println("ArrayDeque : " + (t1 - t0) / 1_000_000 + " ms");
        System.out.println("LinkedList : " + (t3 - t2) / 1_000_000 + " ms");
    }
}
