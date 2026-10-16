package edu.yeditepe.util;

import java.util.ArrayList;
import java.util.List;

/** A plain-text table with aligned columns. */
public class Table {
    private final List<String[]> rows = new ArrayList<>();

    /** Creates an empty table. */
    public Table() { }
    /** Adds a row; the first row is the header. */
    public Table add(String... cells) {
        rows.add(cells);
        return this;
    }

    /** Renders the table as text, one line per row. */
    public String render() {
        int[] w = new int[rows.get(0).length];
        for (String[] r : rows)
            for (int i = 0; i < w.length; i++) w[i] = Math.max(w[i], r[i].length());
        StringBuilder sb = new StringBuilder();
        for (String[] r : rows) {
            for (int i = 0; i < w.length; i++)
                sb.append(String.format("%-" + (w[i] + 2) + "s", r[i]));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
