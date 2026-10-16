import java.util.ArrayList;
import java.util.List;

public class Legacy {
    public static void main(String[] args) {
        List names = new ArrayList();
        names.add("Ali");
        int unused = 0;
        String s = (String) names.get(0);
        System.out.println(s);
    }
}
