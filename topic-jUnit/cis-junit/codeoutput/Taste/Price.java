public class Price {
    public static int withVat(int net) {
        return net + net * 20 / 100;
    }
}
