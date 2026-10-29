import java.util.regex.Pattern;

public class CourseCode {
    private static final Pattern CODE = Pattern.compile("[A-Z]{3,4}\\d{3}");

    public static boolean isValid(String s) {
        return CODE.matcher(s).matches();
    }
}
