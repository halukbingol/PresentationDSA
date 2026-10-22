public class Grade {
    public static String letter(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("score: " + score);
        }
        if (score >= 90) {
            return "AA";
        } else if (score >= 70) {
            return "BB";
        } else if (score >= 50) {
            return "CC";
        }
        return "FF";
    }
}
