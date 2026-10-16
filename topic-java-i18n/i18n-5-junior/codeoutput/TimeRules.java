import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRules;
import java.time.zone.ZoneRulesProvider;

public class TimeRules {
    public static void main(String[] args) {
        System.out.println("time zone data: " + ZoneRulesProvider.getVersions("UTC").lastKey());
        ZoneRules ist = ZoneId.of("Europe/Istanbul").getRules();
        for (String t : new String[] {"2015-01-15", "2015-07-15", "2017-01-15", "2026-07-15"})
            System.out.println("Istanbul " + t + ": UTC" + ist.getOffset(Instant.parse(t + "T12:00:00Z")));

        LocalDateTime twice = LocalDateTime.of(2026, 10, 25, 2, 30);    // clocks go back at 03:00
        ZoneId berlin = ZoneId.of("Europe/Berlin");
        System.out.println("Berlin 02:30 offsets: " + berlin.getRules().getValidOffsets(twice));
        ZonedDateTime first = ZonedDateTime.of(twice, berlin);
        System.out.println("earlier: " + first.toInstant() + "  later: "
            + first.withLaterOffsetAtOverlap().toInstant());
    }
}
