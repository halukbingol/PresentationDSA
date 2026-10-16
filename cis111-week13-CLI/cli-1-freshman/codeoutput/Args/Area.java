public class Area {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("usage: java Area <width> <height>");
            return;
        }
        try {
            double w = Double.parseDouble(args[0]);
            double h = Double.parseDouble(args[1]);
            System.out.println("area = " + (w * h));
        } catch (NumberFormatException e) {
            System.out.println("not a number: " + e.getMessage());
        }
    }
}
