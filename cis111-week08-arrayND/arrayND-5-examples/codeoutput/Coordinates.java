public class Coordinates {
	public static void main(String[] args) {
		char[][] map = new char[3][6];   // map[y][x]
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				map[y][x] = '.';
			}
		}
		int x = 4;
		int y = 1;
		map[y][x] = '*';  // the point (x, y) = (4, 1)
		for (int r = 0; r < map.length; r++) {
			System.out.println(new String(map[r]));
		}
	}
}
