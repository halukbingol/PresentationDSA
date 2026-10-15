import java.util.List;

public class Walker {
    static void a() { b(); }
    static void b() { c(); }
    static void c() {
        List<String> frames = StackWalker.getInstance()
            .walk(s -> s.map(f -> f.getMethodName() + ":" + f.getLineNumber()).toList());
        System.out.println("call stack, top first: " + frames);
        System.out.println("caller of c(): "
            + StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass());
    }

    public static void main(String[] args) {
        a();
    }
}
