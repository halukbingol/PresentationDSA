package report;

import java.sql.Date;
import java.util.logging.Logger;

public class Report {
    public static void main(String[] args) {
        Logger.getLogger("report").fine("hidden");
        System.out.println("Report of " + Date.valueOf("2026-10-02"));
    }
}
