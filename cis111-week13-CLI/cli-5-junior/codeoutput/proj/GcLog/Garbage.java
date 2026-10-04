import java.util.ArrayList;
import java.util.List;

public class Garbage {
    public static void main(String[] args) {
        List<int[]> keep = new ArrayList<>();
        for (int i = 0; i < 2_000; i++) {
            int[] block = new int[25_000];       // 100 KB each
            if (i % 10 == 0) keep.add(block);    // keep 10 %
        }
        System.out.println("kept " + keep.size() + " blocks");
    }
}
