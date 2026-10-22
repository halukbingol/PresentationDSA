import java.util.ArrayList;
import java.util.List;

public class IntStack {
    private final List<Integer> items = new ArrayList<>();

    public void push(int x) {
        items.add(x);
    }

    public int pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("pop on an empty stack");
        }
        return items.remove(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
