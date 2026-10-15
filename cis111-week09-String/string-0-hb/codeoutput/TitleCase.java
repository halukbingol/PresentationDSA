public class TitleCase {
    public static void main(String[] args) {
        String s = "the quick brown fox";
        StringBuilder sb = new StringBuilder();
        for (String w : s.split(" ")) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(Character.toUpperCase(w.charAt(0)));
            sb.append(w.substring(1));
        }
        System.out.println(sb);
        System.out.println(new StringBuilder(s).reverse());
        long os = s.chars().filter(c -> c == 'o').count();
        System.out.println(os + " o's");
    }
}
