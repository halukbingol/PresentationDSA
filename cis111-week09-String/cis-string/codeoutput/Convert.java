public class Convert {
    public static void main(String[] args) {
        int n = Integer.parseInt("42");
        double x = Double.parseDouble("2.5");
        System.out.println(n + 1);       // a number
        System.out.println("42" + 1);    // a string
        System.out.println(x * 2);
        String s = String.valueOf(n);    // int to String
        System.out.println(s.length());
        char[] cs = "hello".toCharArray();
        cs[0] = 'j';
        System.out.println(new String(cs));
        try {
            Integer.parseInt("4 2");
        } catch (NumberFormatException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
