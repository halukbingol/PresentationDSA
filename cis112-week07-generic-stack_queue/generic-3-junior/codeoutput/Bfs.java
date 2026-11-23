import java.util.ArrayDeque;
import java.util.Queue;

public class Bfs {
    static final int N = 5;
    public static void main(String[] args) {
        int[][] grid = new int[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int visited = 0;
        while (!q.isEmpty()) {
            int[] c = q.poll();
            visited++;
            for (int[] d : dirs) {
                int r = c[0] + d[0], c2 = c[1] + d[1];
                if (r >= 0 && r < N && c2 >= 0 && c2 < N && grid[r][c2] == 0) {
                    grid[r][c2] = grid[c[0]][c[1]] + 1;
                    q.offer(new int[]{r, c2});
                }
            }
        }
        System.out.println("visited = " + visited);
        System.out.println("distance to (4,4) = " + (grid[4][4] - 1));
    }
}