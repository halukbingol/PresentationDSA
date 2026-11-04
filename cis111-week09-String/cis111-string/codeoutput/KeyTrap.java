import java.util.HashSet;
import java.util.Set;

public class KeyTrap {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("ali");
        String typed = new String("ali");    // another object
        System.out.println(names.contains(typed));
        Set<StringBuilder> builders = new HashSet<>();
        builders.add(new StringBuilder("ali"));
        StringBuilder probe = new StringBuilder("ali");
        System.out.println(builders.contains(probe));
        StringBuilder key = new StringBuilder("ali");
        builders.add(key);
        key.append("ce");          // changes inside the set!
        System.out.println(builders.contains(key));
    }
}
