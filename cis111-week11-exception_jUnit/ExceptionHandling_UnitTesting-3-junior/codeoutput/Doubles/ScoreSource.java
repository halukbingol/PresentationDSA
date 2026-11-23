import java.io.IOException;

/** Where scores come from. */
public interface ScoreSource {
	int[] read() throws IOException;
}
