import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Reload {
    /** Reads bundles from a folder (not the class path), as UTF-8, and lets them expire. */
    static class FolderControl extends ResourceBundle.Control {
        public List<String> getFormats(String base) { return FORMAT_PROPERTIES; }
        public long getTimeToLive(String base, Locale l) { return 0; }      // check every time
        public boolean needsReload(String b, Locale l, String f, ClassLoader c,
                                   ResourceBundle old, long loaded) { return true; }
        public ResourceBundle newBundle(String base, Locale l, String format,
                                        ClassLoader c, boolean reload) throws IOException {
            Path p = Path.of("texts", toBundleName(base, l) + ".properties");
            if (!Files.exists(p)) return null;
            try (Reader r = Files.newBufferedReader(p)) { return new PropertyResourceBundle(r); }
        }
    }
    public static void main(String[] args) throws IOException {
        FolderControl control = new FolderControl();
        Locale tr = Locale.of("tr");
        System.out.println(ResourceBundle.getBundle("Texts", tr, control).getString("hi"));
        Files.writeString(Path.of("texts/Texts_tr.properties"), "hi=Selam\n");  // a translator edits
        System.out.println(ResourceBundle.getBundle("Texts", tr, control).getString("hi"));
    }
}
