public class PushPop {
    public static void main(String[] args) {
        IntStack s = new IntStack(5);
        System.out.println("new        " + s);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("3 pushes   " + s + "   size " + s.size());
        System.out.println("peek()   = " + s.peek());
        System.out.println("pop()    = " + s.pop());
        System.out.println("pop()    = " + s.pop());
        System.out.println("now        " + s);
        s.push(40);
        System.out.println("push(40)   " + s);
        while (!s.isEmpty()) {
            System.out.println("pop()    = " + s.pop());
        }
        System.out.println("isEmpty  = " + s.isEmpty());
    }
}
