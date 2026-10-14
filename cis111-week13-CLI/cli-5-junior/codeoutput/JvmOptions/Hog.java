import java.util.ArrayList;
import java.util.List;

public class Hog {
    public static void main(String[] args) {
        List<long[]> keep = new ArrayList<>();
        while (true) {
            keep.add(new long[1_000_000]);    // 8 MB each
            System.out.println("blocks: " + keep.size());
        }
    }
}
