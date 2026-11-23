public class TextBlock {
    public static void main(String[] args) {
        String json = """
            {
              "name": "Ayşe",
              "year": 1
            }
            """;
        System.out.print(json);
        System.out.println("lines: " + json.lines().count());
        String html = """
            <p>Hello, \
            World</p>""";
        System.out.println(html);
    }
}
