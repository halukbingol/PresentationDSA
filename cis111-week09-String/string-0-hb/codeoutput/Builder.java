public class Builder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java");
        sb.append(' ').append(21).append('!');
        System.out.println(sb);
        sb.insert(0, "Hello ");
        System.out.println(sb);
        sb.setCharAt(0, 'h');
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb + " (length " + sb.length() + ")");
        System.out.println(new StringBuilder("stressed").reverse());
        String result = sb.toString();  // immutable again
        System.out.println(result.toUpperCase());
    }
}
