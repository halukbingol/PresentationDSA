import java.io.File;
import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IClassCoverage;
import org.jacoco.core.tools.ExecFileLoader;

public class Coverage {
    public static void main(String[] args) throws Exception {
        ExecFileLoader exec = new ExecFileLoader();
        exec.load(new File(args[0]));
        CoverageBuilder result = new CoverageBuilder();
        new Analyzer(exec.getExecutionDataStore(), result).analyzeAll(new File(args[1]));
        for (IClassCoverage c : result.getClasses()) {
            System.out.printf("%s: lines %d/%d, branches %d/%d%n", c.getName(),
                    c.getLineCounter().getCoveredCount(), c.getLineCounter().getTotalCount(),
                    c.getBranchCounter().getCoveredCount(), c.getBranchCounter().getTotalCount());
        }
    }
}
