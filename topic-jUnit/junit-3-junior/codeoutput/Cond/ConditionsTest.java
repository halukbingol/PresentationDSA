import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class ConditionsTest {
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void windowsPaths() {
        assertEquals("\\", java.io.File.separator);
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void macPaths() {
        assertEquals("/", java.io.File.separator);
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void linuxPaths() {
        assertEquals("/", java.io.File.separator);
    }

    @Test
    @EnabledOnJre(JRE.JAVA_21)
    void onlyOnJava21() {
        assertEquals(21, Runtime.version().feature());
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "CI", matches = "true")
    void onlyOnTheBuildServer() {
        fail("would talk to the real database");
    }
}
