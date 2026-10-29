public class Dollar {
    public static void main(String[] args) {
        String template = "Total: PRICE";
        System.out.println(template.replace("PRICE", "$5"));
        System.out.println(template.replaceAll("PRICE", "\\$5"));
        System.out.println(template.replaceAll("PRICE", "$5"));
    }
}
