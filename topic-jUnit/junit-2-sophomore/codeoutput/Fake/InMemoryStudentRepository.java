import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class InMemoryStudentRepository implements StudentRepository {
    private final Map<String, Integer> credits = new HashMap<>();

    InMemoryStudentRepository with(String id, int ects) {
        credits.put(id, ects);
        return this;
    }

    @Override
    public Optional<Integer> creditsOf(String studentId) {
        return Optional.ofNullable(credits.get(studentId));
    }
}
