import org.junit.jupiter.api.Test;

class GradeTest {
    @Test
    void runsEverything() {
        for (int score = 0; score <= 100; score += 10) {
            Grade.letter(score);
        }
    }
}
