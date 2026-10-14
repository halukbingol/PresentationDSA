import java.util.ArrayList;
import java.util.List;

public class Old {
    public static void main(String[] args) {
        List names = new ArrayList();      // raw type
        names.add("Ali");
        Integer n = new Integer(42);       // deprecated
        System.out.println(names + " " + n);
    }
}
