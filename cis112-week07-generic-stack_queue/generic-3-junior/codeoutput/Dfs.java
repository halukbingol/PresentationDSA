import java.util.ArrayDeque;
import java.util.Deque;

public class Dfs {
    public static void main(String[] args) {
        int[][] children = {
            {}, // 0 unused
            {2, 3, 4},
            {5, 6},
            {}, {}, {}, {}
        };
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        StringBuilder order = new StringBuilder();
        while (!stack.isEmpty()) {
            int n = stack.pop();
            order.append(n).append(' ');
            int[] ch = children[n];
            for (int i = ch.length - 1; i >= 0; i--) stack.push(ch[i]);
        }
        System.out.println("DFS order: " + order.toString().trim());
    }
}