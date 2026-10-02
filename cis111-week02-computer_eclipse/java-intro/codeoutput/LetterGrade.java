public class LetterGrade {
    public static void main(String[] args) {
        int[] scores = {95, 82, 74, 61, 40};
        for (int score : scores) {
            String letter;
            if (score >= 90) {
                letter = "A";
            } else if (score >= 80) {
                letter = "B";
            } else if (score >= 70) {
                letter = "C";
            } else if (score >= 60) {
                letter = "D";
            } else {
                letter = "F";
            }
            System.out.println(score + " -> " + letter);
        }
    }
}
