package edu.yeditepe.shop;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.add(new Item("pencil", 12.50));
        cart.add(new Item("notebook", 45.00));
        System.out.printf("%d items, total %.2f TL%n", cart.size(), cart.total());
    }
}
