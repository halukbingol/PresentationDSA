public class Shop {
    static int price(int n) {
        return 10 * n;
    }

    static int discount(int n) {
        return price(n) - "5";
    }

    public static void main(String[] args) {
        System.out.println("price(3) = " + price(3));
        System.out.println("discount(3) = " + discount(3));
    }
}
