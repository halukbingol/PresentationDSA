package edu.yeditepe.shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item) { items.add(item); }
    public int size() { return items.size(); }

    public double total() {
        double t = 0;
        for (Item i : items) t += i.price();
        return t;
    }
}
