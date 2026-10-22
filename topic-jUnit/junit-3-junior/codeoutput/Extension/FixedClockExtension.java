import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestWatcher;

public class FixedClockExtension implements ParameterResolver, TestWatcher {
    static final Clock CLOCK = Clock.fixed(Instant.parse("2026-10-17T06:30:00Z"),
            ZoneId.of("Europe/Istanbul"));

    @Override
    public boolean supportsParameter(ParameterContext p, ExtensionContext c) {
        return p.getParameter().getType() == Clock.class;
    }

    @Override
    public Object resolveParameter(ParameterContext p, ExtensionContext c) {
        return CLOCK;
    }

    @Override
    public void testFailed(ExtensionContext c, Throwable cause) {
        System.out.println("FAILED " + c.getDisplayName() + " at " + CLOCK.instant());
    }

    @Override
    public void testSuccessful(ExtensionContext c) {
        System.out.println("passed " + c.getDisplayName());
    }
}
