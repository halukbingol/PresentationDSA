import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntStackTest {
    @Test
    void popReturnsTheLastPushed() {
        IntStack stack = new IntStack();     // arrange
        stack.push(1);
        stack.push(2);

        int top = stack.pop();               // act

        assertEquals(2, top);                // assert
        assertFalse(stack.isEmpty());
    }

    @Test
    void popOnEmptyThrows() {
        IntStack stack = new IntStack();
        IllegalStateException e =
                assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("pop on an empty stack", e.getMessage());
    }
}
