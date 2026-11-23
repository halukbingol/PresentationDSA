public class BoxingDemo {
    public static void main(String[] args) {
        int[] prims = new int[1_000_000];
        long t0 = System.nanoTime();
        for (int i = 0; i < prims.length; i++) prims[i] = i;
        long sum1 = 0;
        for (int i = 0; i < prims.length; i++) sum1 += prims[i];
        long t1 = System.nanoTime();

        Integer[] boxes = new Integer[1_000_000];
        long t2 = System.nanoTime();
        for (int i = 0; i < boxes.length; i++) boxes[i] = i;
        long sum2 = 0;
        for (int i = 0; i < boxes.length; i++) sum2 += boxes[i];
        long t3 = System.nanoTime();

        System.out.println("primitive: " + (t1 - t0) / 1_000_000 + " ms, sum = " + sum1);
        System.out.println("boxed:     " + (t3 - t2) / 1_000_000 + " ms, sum = " + sum2);
    }
}