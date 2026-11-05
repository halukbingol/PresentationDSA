import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class RingBuffer {
    private final long[] slots;
    private final int mask;
    private long producerIdx;
    private long consumerIdx;

    private static final VarHandle PRODUCER;
    private static final VarHandle CONSUMER;
    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            PRODUCER = l.findVarHandle(RingBuffer.class, "producerIdx", long.class);
            CONSUMER = l.findVarHandle(RingBuffer.class, "consumerIdx", long.class);
        } catch (ReflectiveOperationException e) { throw new ExceptionInInitializerError(e); }
    }

    public RingBuffer(int capacity) {
        if (Integer.bitCount(capacity) != 1)
            throw new IllegalArgumentException("capacity must be a power of two");
        slots = new long[capacity];
        mask = capacity - 1;
    }

    public boolean tryPublish(long value) {
        long p = (long) PRODUCER.getAcquire(this);
        long c = (long) CONSUMER.getAcquire(this);
        if (p - c >= slots.length) return false;
        slots[(int) (p & mask)] = value;
        PRODUCER.setRelease(this, p + 1);
        return true;
    }

    public Long tryConsume() {
        long c = (long) CONSUMER.getAcquire(this);
        long p = (long) PRODUCER.getAcquire(this);
        if (c >= p) return null;
        long value = slots[(int) (c & mask)];
        CONSUMER.setRelease(this, c + 1);
        return value;
    }

    public static void main(String[] args) {
        RingBuffer rb = new RingBuffer(4);
        for (int i = 1; i <= 6; i++)
            System.out.println("publish " + i + ": " + rb.tryPublish(i));
        Long x;
        while ((x = rb.tryConsume()) != null) System.out.println("consume " + x);
        for (int i = 7; i <= 9; i++)
            System.out.println("publish " + i + ": " + rb.tryPublish(i));
        while ((x = rb.tryConsume()) != null) System.out.println("consume " + x);
    }
}