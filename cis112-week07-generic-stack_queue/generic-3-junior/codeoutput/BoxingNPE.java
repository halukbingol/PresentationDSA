public class BoxingNPE {
    public static void main(String[] args) {
        Integer a = null;
        try {
            int sum = a + 1;    // unboxing -> NPE
            System.out.println(sum);
        } catch (NullPointerException e) {
            System.out.println("NPE: " + e.getMessage());
        }
    }
}