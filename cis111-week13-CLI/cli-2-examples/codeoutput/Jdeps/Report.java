import java.sql.Date;
import java.util.logging.Logger;

public class Report {
    public static void main(String[] args) {
        Logger.getLogger("report").info("today is " + new Date(System.currentTimeMillis()));
    }
}
