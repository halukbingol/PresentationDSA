import java.util.List;
import java.util.regex.Pattern;

/** A simplified translation of one .gitignore pattern into a Java regex (no "!", no trailing "/"). */
public class GlobToRegex {
    static String toRegex(String glob) {
        boolean anchored = glob.indexOf('/') >= 0;          // a slash at the start or in the middle
        if (glob.startsWith("/")) glob = glob.substring(1);
        StringBuilder re = new StringBuilder(anchored ? "" : "(.*/)?");
        for (int i = 0; i < glob.length(); i++) {
            char c = glob.charAt(i);
            if (glob.startsWith("**/", i)) { re.append("(.*/)?"); i += 2; }
            else if (glob.startsWith("/**", i) && i + 3 == glob.length()) { re.append("/.*"); i += 2; }
            else if (c == '*') re.append("[^/]*");
            else if (c == '?') re.append("[^/]");
            else if (c == '[') {
                int end = glob.indexOf(']', i + 2);
                String set = glob.substring(i + 1, end);
                re.append('[').append(set.startsWith("!") ? "^" + set.substring(1) : set).append(']');
                i = end;
            } else re.append("\\.[]{}()+^$|".indexOf(c) >= 0 ? "\\" + c : String.valueOf(c));
        }
        return re.toString();
    }

    /** ignored if the path or one of its parent directories matches */
    static boolean ignored(Pattern p, String path) {
        for (int i = path.indexOf('/'); i >= 0; i = path.indexOf('/', i + 1)) {
            if (p.matcher(path.substring(0, i)).matches()) return true;
        }
        return p.matcher(path).matches();
    }

    public static void main(String[] args) {
        List<String> paths = List.of("build/out.txt", "src/build/Gen.java", "build.txt", "app.log", "logs/old/2.log");
        for (String glob : List.of("build", "/build", "*.log", "logs/**/*.log", "report[0-9].txt")) {
            Pattern p = Pattern.compile(toRegex(glob));
            System.out.printf("%-16s %-28s", glob, p.pattern());
            for (String path : paths) {
                if (ignored(p, path)) System.out.print(" " + path);
            }
            System.out.println();
        }
    }
}
