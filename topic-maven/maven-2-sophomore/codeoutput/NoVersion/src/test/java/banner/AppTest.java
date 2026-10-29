package banner;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void propertiesAreFiltered() throws Exception {
        java.util.Properties p = new java.util.Properties();
        p.load(App.class.getResourceAsStream("/app.properties"));
        assertTrue(p.getProperty("version").endsWith("SNAPSHOT"));
    }
}
