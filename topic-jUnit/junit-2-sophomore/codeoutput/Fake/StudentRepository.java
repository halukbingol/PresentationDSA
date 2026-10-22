import java.util.Optional;

public interface StudentRepository {
    Optional<Integer> creditsOf(String studentId);
}
