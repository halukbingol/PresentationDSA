import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegistrationTest {
    StudentRepository repo = new InMemoryStudentRepository()
            .with("20230001", 240)
            .with("20230002", 210);
    Registration registration = new Registration(repo);

    @Test
    void enoughCredits() {
        assertEquals("yes", registration.canGraduate("20230001"));
    }

    @Test
    void missingCredits() {
        assertEquals("no: 30 ECTS missing", registration.canGraduate("20230002"));
    }

    @Test
    void unknownStudent() {
        assertEquals("unknown student", registration.canGraduate("19990000"));
    }
}
