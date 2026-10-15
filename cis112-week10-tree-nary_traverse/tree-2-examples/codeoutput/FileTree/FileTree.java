import java.io.File;
import java.util.Arrays;

public class FileTree {
    /** preorder: print the folder before its contents; postorder: its size after them */
    static long walk(File f, String indent) {
        if (f.isFile()) {
            System.out.printf("%s%s  (%d bytes)%n", indent, f.getName(), f.length());
            return f.length();
        }
        System.out.println(indent + f.getName() + "/");
        File[] kids = f.listFiles();
        Arrays.sort(kids);                              // same order on every system
        long total = 0;
        for (File k : kids) total += walk(k, indent + "  ");
        System.out.printf("%s= %s/ total %d bytes%n", indent, f.getName(), total);
        return total;
    }

    public static void main(String[] args) {
        walk(new File(args[0]), "");
    }
}
