public class DayType {
    public static void main(String[] args) {
        String[] days = {"MON", "WED", "SAT", "SUN", "XYZ"};
        for (String day : days) {
            String type = switch (day) {
                case "MON", "TUE", "WED", "THU", "FRI" -> "weekday";
                case "SAT", "SUN" -> "weekend";
                default -> "unknown";
            };
            System.out.println(day + " -> " + type);
        }
    }
}
