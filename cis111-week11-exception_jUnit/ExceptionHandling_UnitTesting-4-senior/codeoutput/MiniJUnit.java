import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class MiniJUnit {
	@Retention(RetentionPolicy.RUNTIME)
	@interface Check { }                              // our own @Test

	static class SampleChecks {                       // a "test class"
		@Check void passes() { expect(4, 2 + 2); }
		@Check void fails() { expect(5, 2 + 2); }
		@Check void crashes() { Integer.parseInt("x"); }
		void helper() { }                             // no @Check: not run
	}

	static void expect(int expected, int actual) {
		if (expected != actual) {
			throw new AssertionError("expected " + expected + " but was " + actual);
		}
	}

	public static void main(String[] args) throws Exception {
		Method[] methods = SampleChecks.class.getDeclaredMethods();
		Arrays.sort(methods, Comparator.comparing(Method::getName));
		for (Method m : methods) {
			if (!m.isAnnotationPresent(Check.class)) {
				continue;
			}
			Object instance = SampleChecks.class.getDeclaredConstructor().newInstance();
			try {
				m.invoke(instance);                       // a new instance per test
				System.out.println("ok     " + m.getName());
			} catch (InvocationTargetException wrapper) {
				Throwable t = wrapper.getCause();         // what the test threw
				String kind = (t instanceof AssertionError) ? "FAIL " : "ERROR";
				System.out.println(kind + "  " + m.getName() + ": " + t);
			}
		}
	}
}
