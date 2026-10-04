public class Memory {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("max heap : " + rt.maxMemory() / (1024 * 1024) + " MB");
        System.out.println("CPUs     : " + rt.availableProcessors());
    }
}
