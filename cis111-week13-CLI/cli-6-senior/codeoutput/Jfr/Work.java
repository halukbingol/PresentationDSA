import java.util.HashMap;
import java.util.Map;

public class Work {
    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<>();
        long sum = 0;
        for (int round = 0; round < 40; round++) {
            for (int i = 0; i < 200_000; i++)
                m.put(i, "v" + i);                     // allocates a lot
            sum += m.get(round).length();
            m.clear();
        }
        System.out.println("sum = " + sum);
    }
}
