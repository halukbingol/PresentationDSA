import java.util.ArrayDeque;
import java.util.Deque;

public class Undo {
    static String text = "";
    static Deque<String> undo = new ArrayDeque<>();
    static Deque<String> redo = new ArrayDeque<>();

    static void type(String s) {
        undo.push(text);         // remember the text before
        redo.clear();            // a new edit forgets the redo history
        text = text + s;
        show("type \"" + s + "\"");
    }

    static void undo() {
        redo.push(text);
        text = undo.pop();
        show("undo");
    }

    static void redo() {
        undo.push(text);
        text = redo.pop();
        show("redo");
    }

    static void show(String what) {
        System.out.printf("%-13s %-20s undo %d redo %d%n",
                          what, "\"" + text + "\"", undo.size(), redo.size());
    }

    public static void main(String[] args) {
        type("Hello");
        type(" world");
        type("!");
        undo();
        undo();
        redo();
        type(" Java");
    }
}
