package edu.yeditepe.books;

import edu.yeditepe.util.Table;

public class Main {
    public static void main(String[] args) throws Exception {
        Table t = new Table().add("Title", "Author", "Year");
        for (Book b : Catalog.load()) {
            t.add(b.title(), b.author(), String.valueOf(b.year()));
        }
        System.out.print(t.render());
    }
}
