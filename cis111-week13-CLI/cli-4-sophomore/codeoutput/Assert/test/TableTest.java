import edu.yeditepe.util.Table;

public class TableTest {
    public static void main(String[] args) {
        String out = new Table().add("a", "bb").add("ccc", "d").render();
        String[] lines = out.split(System.lineSeparator());
        assert lines.length == 2 : "two rows expected";
        assert lines[0].equals("a    bb  ") : "column 1 is 3 wide + 2 spaces";
        assert lines[1].endsWith("d") : "no padding after the last column";
        System.out.println("all tests passed");
    }
}
