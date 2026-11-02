import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

/** Runs the JUnit 5 tests of one class and prints one line per test. */
public class RunTests {
	public static void main(String[] args) throws Exception {
		Launcher launcher = LauncherFactory.create();
		int[] count = new int[2];                       // passed, failed
		launcher.execute(LauncherDiscoveryRequestBuilder.request()
				.selectors(selectClass(Class.forName(args[0]))).build(),
				new TestExecutionListener() {
					@Override
					public void executionFinished(TestIdentifier id, TestExecutionResult r) {
						if (!id.isTest()) {
							return;
						}
						if (r.getStatus() == TestExecutionResult.Status.SUCCESSFUL) {
							count[0]++;
							System.out.println("  ok    " + id.getDisplayName());
						} else {
							count[1]++;
							System.out.println("  FAIL  " + id.getDisplayName());
							r.getThrowable().ifPresent(
									t -> System.out.println("        " + t.getMessage()));
						}
					}
				});
		System.out.println((count[0] + count[1]) + " tests: " + count[0] + " passed, "
				+ count[1] + " failed");
	}
}
