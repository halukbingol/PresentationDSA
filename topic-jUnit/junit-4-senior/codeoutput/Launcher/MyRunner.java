import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

public class MyRunner {
    public static void main(String[] args) throws Exception {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(Class.forName(args[0])))
                .build();
        TestExecutionListener printer = new TestExecutionListener() {
            @Override
            public void executionFinished(TestIdentifier id, TestExecutionResult result) {
                if (id.isTest()) {
                    System.out.println(result.getStatus() + " " + id.getDisplayName());
                }
            }
        };
        SummaryGeneratingListener summary = new SummaryGeneratingListener();
        Launcher launcher = LauncherFactory.create();
        launcher.execute(request, printer, summary);
        System.out.println("found " + summary.getSummary().getTestsFoundCount()
                + ", failed " + summary.getSummary().getTestsFailedCount());
    }
}
