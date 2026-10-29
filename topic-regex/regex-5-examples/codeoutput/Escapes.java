import java.util.Arrays;

public class Escapes {
    public static void main(String[] args) {
        String regex = "\\d+\\.\\d+";
        System.out.println("Java literal \"\\\\d+\\\\.\\\\d+\" is the regex " + regex);
        System.out.println("3.14".matches(regex) + " " + "3x14".matches(regex));

        String ip = "192.168.1.10";
        System.out.println(Arrays.toString(ip.split(".")));
        System.out.println(Arrays.toString(ip.split("\\.")));

        String path = "C:\\Users\\ayse";
        System.out.println(path + " -> " + Arrays.toString(path.split("\\\\")));
    }
}
