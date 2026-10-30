/** A String[] is also an Object[] ... */
public class Covariance {
	public static void main(String[] args) {
		String[] names = new String[2];
		Object[] objects = names;    // compiles
		objects[0] = "Ada";          // fine
		System.out.println(names[0]);
		objects[1] = 42;             // compiles; checked at run time
	}
}
