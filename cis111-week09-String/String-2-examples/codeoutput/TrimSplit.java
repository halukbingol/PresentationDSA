import java.util.Arrays;

public class TrimSplit {
    public static void main(String[] args) {
        String raw = "   Ali , Ayşe,Can ,  Deniz  ";
        System.out.println("[" + raw.strip() + "]");
        String[] parts = raw.split(",");
        System.out.println(parts.length + " parts");
        System.out.println(Arrays.toString(parts));
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].strip();
        }
        System.out.println(Arrays.toString(parts));
        System.out.println(String.join(" - ", parts));
        String line = "one   two\tthree";
        System.out.println(Arrays.toString(line.split("\\s+")));
        System.out.println("   ".isBlank() + " " + "   ".isEmpty());
    }
}
