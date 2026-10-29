import java.util.regex.Pattern;

public class ReplaceFn {
    public static void main(String[] args) {
        String prices = "Tea 15 TL, simit 20 TL, ayran 25 TL";
        String raised = Pattern.compile("(\\d+) TL").matcher(prices)
                .replaceAll(m -> Math.round(Integer.parseInt(m.group(1)) * 1.2) + " TL");
        System.out.println(raised);

        String names = "ayşe yılmaz, ali kaya";
        String title = Pattern.compile("\\b(\\p{L})(\\p{L}*)").matcher(names)
                .replaceAll(m -> m.group(1).toUpperCase() + m.group(2));
        System.out.println(title);
    }
}
