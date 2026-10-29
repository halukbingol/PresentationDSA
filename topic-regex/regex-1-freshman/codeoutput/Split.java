import java.util.Arrays;

public class Split {
    public static void main(String[] args) {
        String names = "Ayşe,Ali,  Zeynep ,Can";
        System.out.println(Arrays.toString(names.split(",")));
        System.out.println(Arrays.toString(names.split("\\s*,\\s*")));

        String sentence = "Java   is    fun";
        System.out.println(Arrays.toString(sentence.split(" ")));
        System.out.println(Arrays.toString(sentence.split("\\s+")));

        String ip = "192.168.1.10";
        System.out.println(Arrays.toString(ip.split(".")));
        System.out.println(Arrays.toString(ip.split("\\.")));
    }
}
