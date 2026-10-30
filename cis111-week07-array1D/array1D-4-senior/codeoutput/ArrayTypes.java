import java.io.Serializable;

/** An array is an object; the JVM makes its class. */
public class ArrayTypes {
	public static void main(String[] args) {
		int[] a = new int[3];
		Object[] all = {a, new double[1], new boolean[1],
				new char[1], new String[1]};
		for (Object x : all) {
			System.out.println(x.getClass().getName());
		}
		Class<?> c = a.getClass();
		System.out.println(c.getSuperclass().getName());
		System.out.println(a instanceof Cloneable);
		System.out.println(a instanceof Serializable);
		System.out.println(a);           // class name @ hash
	}
}
