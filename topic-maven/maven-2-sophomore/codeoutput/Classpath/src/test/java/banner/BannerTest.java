package banner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BannerTest {
    @Test
    void shortTextIsCentered() {
        assertEquals("********\n   ab   \n********", Banner.make("ab", 8));
    }

    @Test
    void longTextIsAbbreviated() {
        assertEquals("abc...", Banner.make("abcdefghij", 10).split("\n")[1].trim());
    }
}
