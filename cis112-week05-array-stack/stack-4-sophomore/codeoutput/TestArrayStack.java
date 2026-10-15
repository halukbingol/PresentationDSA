import java.util.ArrayList;
import java.util.List;

public class TestArrayStack {
    static int passed, failed;

    static void check(String name, boolean ok) {
        if (ok) passed++; else failed++;
        System.out.println((ok ? "PASS " : "FAIL ") + name);
    }

    public static void main(String[] args) {
        StackADT<Integer> s = new ArrayStack<>();
        check("new stack is empty", s.isEmpty() && s.size() == 0);

        s.push(1);
        check("push then peek", s.peek() == 1 && s.size() == 1);
        check("push then pop", s.pop() == 1 && s.isEmpty());

        for (int i = 0; i < 1000; i++) s.push(i);
        check("1000 pushes", s.size() == 1000 && s.peek() == 999);

        boolean lifo = true;
        for (int i = 999; i >= 0; i--) lifo &= s.pop() == i;
        check("LIFO order", lifo && s.isEmpty());

        try { s.pop(); check("pop on empty throws", false); }
        catch (StackUnderflowException e) { check("pop on empty throws", true); }

        s.push(1); s.push(2); s.push(3);
        List<Integer> seen = new ArrayList<>();
        for (int x : s) seen.add(x);
        check("iterator goes top to bottom", seen.equals(List.of(3, 2, 1)));

        System.out.println(passed + " passed, " + failed + " failed");
    }
}
