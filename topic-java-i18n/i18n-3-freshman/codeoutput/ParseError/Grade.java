public class Grade {
    public static void main(String[] args) {
        double g = Double.parseDouble(args[0]);   // Java syntax: point only
        System.out.println(g >= 60 ? "passed" : "failed");
    }
}
