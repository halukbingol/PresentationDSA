import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class ReminderTest {
    GradeService grades = mock(GradeService.class);
    Mailer mailer = mock(Mailer.class);
    Reminder reminder = new Reminder(grades, mailer);

    @Test
    void mailsAStudentWithMissingHomework() {
        when(grades.missingHomework("ayse")).thenReturn(2);

        reminder.remind("ayse");

        verify(mailer).send("ayse@std.yeditepe.edu.tr", "2 homework missing");
    }

    @Test
    void staysSilentOtherwise() {
        when(grades.missingHomework("ali")).thenReturn(0);

        reminder.remind("ali");

        verify(mailer, never()).send(anyString(), anyString());
    }
}
