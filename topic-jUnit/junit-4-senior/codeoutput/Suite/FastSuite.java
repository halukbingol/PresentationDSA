import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Fast tests of the grades module")
@SelectPackages("grades")
@IncludeTags("fast")
public class FastSuite {
}
