import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

/**
 * Runs the JUnit tests of the classes named on the command line and prints one line per test,
 * like the JUnit view of Eclipse: ok, FAIL (an assertion was false), ERROR (an exception)
 * or SKIP (a disabled test).
 * Tests run in the order of their method names.
 */
public class RunTests {
	public static void main(String[] args) throws Exception {
		Launcher launcher = LauncherFactory.create();
		int[] count = new int[3];                       // runs, errors, failures
		LauncherDiscoveryRequestBuilder request = LauncherDiscoveryRequestBuilder.request()
				.configurationParameter("junit.jupiter.testmethod.order.default",
						"org.junit.jupiter.api.MethodOrderer$MethodName");
		for (String name : args) {
			request.selectors(selectClass(Class.forName(name)));
		}
		launcher.execute(request.build(), new TestExecutionListener() {
			@Override
			public void executionSkipped(TestIdentifier id, String reason) {
				System.out.println("  SKIP   " + id.getDisplayName() + "  (" + reason + ")");
			}

			@Override
			public void executionFinished(TestIdentifier id, TestExecutionResult r) {
				if (!id.isTest()) {
					return;
				}
				count[0]++;
				if (r.getStatus() == TestExecutionResult.Status.SUCCESSFUL) {
					System.out.println("  ok     " + id.getDisplayName());
					return;
				}
				Throwable t = r.getThrowable().orElse(null);
				if (t instanceof AssertionError) {
					count[2]++;
					System.out.println("  FAIL   " + id.getDisplayName());
					System.out.println("         " + t.getMessage());
				} else {
					count[1]++;
					System.out.println("  ERROR  " + id.getDisplayName());
					System.out.println("         " + t);
				}
			}
		});
		System.out.println("Runs: " + count[0] + "   Errors: " + count[1] + "   Failures: " + count[2]);
		System.exit(0);                                 // also ends threads of timed-out tests
	}
}
