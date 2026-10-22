public class Registration {
    private final StudentRepository repo;

    public Registration(StudentRepository repo) {
        this.repo = repo;
    }

    public String canGraduate(String studentId) {
        return repo.creditsOf(studentId)
                .map(c -> c >= 240 ? "yes" : "no: " + (240 - c) + " ECTS missing")
                .orElse("unknown student");
    }
}
