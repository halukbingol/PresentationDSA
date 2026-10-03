public class Capacity {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int last = sb.capacity();
        System.out.println("length   0  capacity " + last);
        for (int i = 1; i <= 600; i++) {
            sb.append('x');
            if (sb.capacity() != last) {
                last = sb.capacity();
                System.out.printf("length %3d  capacity %d%n",
                                  i, last);
            }
        }
    }
}
