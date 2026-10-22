import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Zones {
    public static void main(String[] args) {
        ZonedDateTime meeting = ZonedDateTime.of(2026, 10, 15, 14, 30, 0, 0,
                                                 ZoneId.of("Europe/Istanbul"));
        for (String z : new String[] {"Europe/Istanbul", "Europe/London",
                                      "America/New_York", "Asia/Tokyo"})
            System.out.println(meeting.withZoneSameInstant(ZoneId.of(z)));

        // 02:30 does not exist in New York on 8 March 2026: clocks jump 02:00 -> 03:00
        System.out.println(ZonedDateTime.of(LocalDateTime.of(2026, 3, 8, 2, 30),
                                            ZoneId.of("America/New_York")));
    }
}
