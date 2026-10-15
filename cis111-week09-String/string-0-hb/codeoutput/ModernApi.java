import java.util.Arrays;

public class ModernApi {
    public static void main(String[] args) {
        String s = "  Java  ";
        System.out.println("[" + s.strip() + "] [" + s.stripTrailing() + "]");      // 11
        System.out.println("   ".isBlank() + " " + "ab".repeat(3));                   // 11
        System.out.println("a\nb\nc".lines().count());                // 11
        System.out.print("x\ny\n".indent(2));                                        // 12
        String loud = "java".transform(t -> t.toUpperCase() + "!");                 // 12
        System.out.println(loud);
        System.out.println("%d%% done".formatted(42));                                // 15
        String[] parts = "a1b22c".splitWithDelimiters("\\d+", 0);                     // 21
        System.out.println(Arrays.toString(parts));
        System.out.println(new StringBuilder().repeat("ab", 3).repeat('-', 2));      // 21
        System.out.println("hello".indexOf('l', 0, 3));                               // 21
    }
}
