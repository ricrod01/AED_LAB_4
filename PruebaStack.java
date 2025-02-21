/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase principal.
 * fecha_creación = 20/02/2025
 * fecha_modificación = 20/02/2025
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PruebaStack
{

    // Se prueba el método push y el método pop.
    
    @Test
    public void testPush_testPop()
    {
        Stack<Integer> stack = new StackVector<>();
        stack.push(2);
        stack.push(7);
        assertEquals(7, stack.pop());
        assertEquals(2, stack.pop());
    }

    // Se prueba el método peek.

    @Test
    public void testPeek() 
    {
        Stack<Integer> stack = new StackArrayList<>();
        stack.push(4);
        assertEquals(4, stack.peek());
        assertFalse(stack.isEmpty());
    }

    // Se prueba el método isEmpty.

    @Test
    public void testIsEmpty()
    {
        Stack<Integer> stack = new StackVector<>();
        assertTrue(stack.isEmpty());
        stack.push(22);
        assertFalse(stack.isEmpty());
    }

    // Se prueba el método size.

    @Test
    public void testSize()
    {
        Stack<Integer> stack = new StackArrayList<>();
        assertEquals(0, stack.size());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

}

