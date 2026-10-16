import java.util.*;

public class Navigable {
    public static void main(String[] args) {
        TreeMap<Integer, String> grade = new TreeMap<>(Map.of(
            0, "FF", 50, "DD", 55, "DC", 60, "CC", 65, "CB", 70, "BB", 80, "BA", 90, "AA"));
        for (int score : new int[] {42, 55, 68, 79, 90, 100})
            System.out.println(score + " -> " + grade.floorEntry(score).getValue());

        System.out.println("pass marks: " + grade.tailMap(60, true).keySet());
        System.out.println("descending: " + grade.descendingMap().values());
        System.out.println("ceiling(66) = " + grade.ceilingKey(66) + ", lower(60) = " + grade.lowerKey(60));
    }
}
