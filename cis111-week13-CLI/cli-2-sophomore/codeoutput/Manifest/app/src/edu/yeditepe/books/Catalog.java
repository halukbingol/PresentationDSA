package edu.yeditepe.books;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    /** Reads books.csv from the class path (inside the JAR). */
    public static List<Book> load() throws IOException {
        List<Book> books = new ArrayList<>();
        var in = Catalog.class.getResourceAsStream("/books.csv");
        try (var r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String line;
            while ((line = r.readLine()) != null) {
                String[] f = line.split(";");
                books.add(new Book(f[0], f[1], Integer.parseInt(f[2])));
            }
        }
        return books;
    }
}
