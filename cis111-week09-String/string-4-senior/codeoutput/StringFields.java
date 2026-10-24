import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class StringFields {
    public static void main(String[] args) {
        for (Field f : String.class.getDeclaredFields()) {
            int mod = f.getModifiers();
            if (!Modifier.isStatic(mod)) {
                System.out.println(Modifier.toString(mod) + " "
                        + f.getType().getSimpleName() + " " + f.getName());
            }
        }
    }
}
