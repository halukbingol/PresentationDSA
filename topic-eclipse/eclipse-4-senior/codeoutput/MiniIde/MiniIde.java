import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import org.eclipse.jdt.core.compiler.batch.BatchCompiler;

public class MiniIde {
    public static void main(String[] args) throws Exception {
        String file = args[0];
        StringWriter problems = new StringWriter();
        String options = "-17 -proc:none -d bin " + file;
        PrintWriter out = new PrintWriter(System.out);
        PrintWriter err = new PrintWriter(problems);
        boolean ok = BatchCompiler.compile(options, out, err, null);
        System.out.println("compiled " + file + ": " + ok);
        if (!ok) {
            System.out.print(problems);
            return;
        }
        String name = file.replace(".java", "");
        URL bin = Path.of("bin").toUri().toURL();
        try (URLClassLoader loader = new URLClassLoader(new URL[] { bin })) {
            Class<?> c = loader.loadClass(name);
            c.getMethod("main", String[].class)
             .invoke(null, (Object) new String[0]);
        }
    }
}
