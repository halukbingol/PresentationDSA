public class Reminder {
    private final GradeService grades;
    private final Mailer mailer;

    public Reminder(GradeService grades, Mailer mailer) {
        this.grades = grades;
        this.mailer = mailer;
    }

    public void remind(String student) {
        int missing = grades.missingHomework(student);
        if (missing > 0) {
            mailer.send(student + "@std.yeditepe.edu.tr", "missing homework: " + missing);
        }
    }
}
