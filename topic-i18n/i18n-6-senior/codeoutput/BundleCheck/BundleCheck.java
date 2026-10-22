import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;
import java.util.stream.Stream;

/** Compares every translation with the base bundle: keys and placeholders. */
public class BundleCheck {
    static Properties load(Path p) throws IOException {
        Properties props = new Properties();
        try (Reader r = Files.newBufferedReader(p)) { props.load(r); }   // UTF-8
        return props;
    }
    static int values(String pattern) { return new MessageFormat(pattern).getFormats().length; }

    public static void main(String[] args) throws IOException {
        Properties base = load(Path.of(args[0] + ".properties"));
        List<Path> files;
        try (Stream<Path> all = Files.list(Path.of("."))) {
            files = all.filter(p -> p.getFileName().toString().startsWith(args[0] + "_"))
                       .sorted().toList();
        }
        for (Path f : files) {
            Properties t = load(f);
            for (String k : new TreeSet<>(base.stringPropertyNames())) {
                if (!t.containsKey(k)) System.out.println(f + ": missing " + k);
                else if (values(t.getProperty(k)) != values(base.getProperty(k)))
                    System.out.println(f + ": " + k + " has " + values(t.getProperty(k))
                        + " values, base has " + values(base.getProperty(k)));
            }
            for (String k : new TreeSet<>(t.stringPropertyNames()))
                if (!base.containsKey(k)) System.out.println(f + ": unknown key " + k);
        }
    }
}
