public class TcKimlik {
    public static boolean isValid(String id) {
        if (!id.matches("[1-9][0-9]{10}")) {
            return false;
        }
        int[] d = new int[11];
        for (int i = 0; i < 11; i++) {
            d[i] = id.charAt(i) - '0';
        }
        int odd = d[0] + d[2] + d[4] + d[6] + d[8];
        int even = d[1] + d[3] + d[5] + d[7];
        int sum = odd + even + d[9];
        return Math.floorMod(odd * 7 - even, 10) == d[9] && sum % 10 == d[10];
    }
}
