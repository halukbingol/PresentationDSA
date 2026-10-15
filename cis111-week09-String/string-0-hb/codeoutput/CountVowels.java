public class CountVowels {
    public static void main(String[] args) {
        String text = "Bilgisayar Mühendisliği";
        String vowels = "aeıioöuüAEIİOÖUÜ";
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) >= 0) {
                count++;
            }
        }
        System.out.println(text);
        System.out.println("vowels: " + count);
    }
}
