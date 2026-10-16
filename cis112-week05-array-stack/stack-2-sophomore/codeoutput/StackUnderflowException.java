/** Thrown by pop() and peek() on an empty stack. */
public class StackUnderflowException extends RuntimeException {
    public StackUnderflowException(String operation) {
        super(operation + "() on an empty stack");
    }
}
