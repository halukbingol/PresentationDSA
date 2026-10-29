package grades;

import java.util.List;
import java.util.Map;

public class Gpa {
    static final Map<String, Double> POINTS = Map.of("AA", 4.0, "BA", 3.5, "BB", 3.0, "CB", 2.5,
            "CC", 2.0, "DC", 1.5, "DD", 1.0, "FF", 0.0);

    public static double of(List<Course> courses) {
        double points = 0;
        int credits = 0;
        for (Course c : courses) {
            Double p = POINTS.get(c.letter());
            if (p == null) throw new IllegalArgumentException("unknown letter grade " + c.letter());
            points += p * c.credits();
            credits += c.credits();
        }
        return credits == 0 ? 0 : points / credits;
    }
}
