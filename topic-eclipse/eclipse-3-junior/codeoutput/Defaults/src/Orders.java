import java.util.ArrayList;
import java.util.List;

public class Orders {
    public static void main(String[] args) {
        List orders = new ArrayList();
        int total = 0;
        String name = null;
        if (args.length > 0) {
            name = args[0];
        }
        System.out.println(name.length());
    }
}
