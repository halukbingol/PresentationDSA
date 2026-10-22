import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class UpperCaseTest {
    static final Map<String, String> CASES = Map.of(
            "istanbul", "İSTANBUL",
            "ılık", "ILIK",
            "çiçek", "ÇİÇEK");

    @TestFactory
    Stream<DynamicTest> turkishUpperCase() {
        return CASES.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> dynamicTest(e.getKey() + " -> " + e.getValue(), () ->
                        assertEquals(e.getValue(),
                                e.getKey().toUpperCase(java.util.Locale.forLanguageTag("tr")))));
    }

    @TestFactory
    Stream<DynamicTest> englishUpperCase() {
        return Stream.of("istanbul").map(w -> dynamicTest(w, () ->
                assertEquals("İSTANBUL", w.toUpperCase(java.util.Locale.ENGLISH))));
    }
}
