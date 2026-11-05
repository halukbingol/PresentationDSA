import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class MemoryOrdering {
    private int data;
    private boolean ready;

    private static final VarHandle DATA;
    private static final VarHandle READY;
    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            DATA  = l.findVarHandle(MemoryOrdering.class, "data", int.class);
            READY = l.findVarHandle(MemoryOrdering.class, "ready", boolean.class);
        } catch (ReflectiveOperationException e) { throw new ExceptionInInitializerError(e); }
    }

    void write() {
        DATA.setOpaque(this, 42);         // plain-ish; not reordered by release below
        READY.setRelease(this, true);     // release: DATA write happens-before
    }

    int read() {
        if ((boolean) READY.getAcquire(this)) {   // acquire: sees DATA = 42
            return (int) DATA.getOpaque(this);
        }
        return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int round = 0; round < 3; round++) {
            MemoryOrdering m = new MemoryOrdering();
            Thread writer = new Thread(m::write);
            writer.start();
            writer.join();
            System.out.println("round " + round + ": read = " + m.read());
        }
    }
}