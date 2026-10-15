public class Receipt {
    public static void main(String[] args) {
        double price = 1249.9;
        int count = 3;
        System.out.printf("Price: %.2f%n", price);
        System.out.printf("Total: %,.2f%n", price * count);
        System.out.println("Plain: " + price * count);    // + never localizes
    }
}
