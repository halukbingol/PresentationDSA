public class TableTypes {
	public static void main(String[] args) {
		int[][] t = new int[2][3];
		System.out.println(t.getClass().getName());
		System.out.println(t[0].getClass().getName());
		System.out.println(t.getClass().getComponentType());
		Object[] rows = t;              // rows are objects
		System.out.println(rows.length);
		System.out.println(rows[1] instanceof int[]);
	}
}
