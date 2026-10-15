public class Trace {
    public static void main(String[] args) {
        IntStack s = new IntStack(4);
        s.push(5);
        System.out.println("push(5)  " + s);
        s.push(8);
        System.out.println("push(8)  " + s);
        System.out.println("pop()  = " + s.pop() + "    " + s);
        s.push(2);
        System.out.println("push(2)  " + s);
        s.push(7);
        System.out.println("push(7)  " + s);
        System.out.println("peek() = " + s.peek() + "    " + s);
        System.out.println("size() = " + s.size());
    }
}
