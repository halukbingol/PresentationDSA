package banner;

import org.apache.commons.lang3.StringUtils;

public class Banner {
    public static String make(String text, int width) {
        String line = StringUtils.repeat('*', width);
        String middle = StringUtils.center(StringUtils.abbreviate(text, width - 4), width);
        return line + "\n" + middle + "\n" + line;
    }
}
