import java.util.Locale;

public class SwitchString {
    static String kind(String day) {
        return switch (day.toLowerCase(Locale.ROOT)) {
            case "saturday", "sunday" -> "weekend";
            case "monday", "tuesday", "wednesday",
                 "thursday", "friday" -> "weekday";
            default -> "unknown: " + day;
        };
    }

    public static void main(String[] args) {
        String[] days = {"Monday", "SUNDAY", "FRIDAY", "Funday"};
        for (String d : days) {
            System.out.println(d + " -> " + kind(d));
        }
    }
}
