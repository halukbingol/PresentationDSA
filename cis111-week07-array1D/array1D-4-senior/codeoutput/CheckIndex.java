import java.util.Objects;

/** Check an index that comes from outside. */
public class CheckIndex {
	static final String[] ROOMS = {"A101", "A102", "B201"};

	static String room(int index) {
		Objects.checkIndex(index, ROOMS.length);
		return ROOMS[index];
	}

	public static void main(String[] args) {
		System.out.println(room(2));
		System.out.println(room(7));     // e.g. typed by a user
	}
}
