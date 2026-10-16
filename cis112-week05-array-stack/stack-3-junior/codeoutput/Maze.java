import java.util.ArrayDeque;
import java.util.Deque;

public class Maze {
    static String[] maze = {
        "#########",
        "#S..#...#",
        "#.#.#.#.#",
        "#.#...#.#",
        "#.#####.#",
        "#...#..E#",
        "#########" };

    public static void main(String[] args) {
        char[][] g = new char[maze.length][];
        for (int r = 0; r < maze.length; r++) g[r] = maze[r].toCharArray();
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};       // E, S, W, N

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {1, 1});                              // S
        int visited = 0;
        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            char c = g[p[0]][p[1]];
            if (c == 'E') break;
            if (c == '#' || c == '*') continue;                    // wall or seen
            g[p[0]][p[1]] = c == 'S' ? 'S' : '*';
            visited++;
            for (int[] m : moves) stack.push(new int[] {p[0] + m[0], p[1] + m[1]});
        }
        for (char[] row : g) System.out.println(new String(row));
        System.out.println("cells visited: " + visited);
    }
}
