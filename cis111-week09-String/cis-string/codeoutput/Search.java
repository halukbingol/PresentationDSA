public class Search {
    public static void main(String[] args) {
        String s = "she sells sea shells";
        System.out.println(s.indexOf("se"));
        System.out.println(s.indexOf("se", 5));    // start at 5
        System.out.println(s.lastIndexOf('s'));
        System.out.println(s.indexOf("fish"));
        System.out.println(s.contains("sea"));
        System.out.println(s.startsWith("she"));
        System.out.println(s.endsWith("lls"));
        int count = 0;
        int i = s.indexOf('s');
        while (i >= 0) {               // every occurrence
            count++;
            i = s.indexOf('s', i + 1);
        }
        System.out.println("'s' occurs " + count + " times");
    }
}
