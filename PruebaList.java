/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase principal.
 * fecha_creación = 20/02/2025
 * fecha_modificación = 20/02/2025
 */

 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.Test;

public class PruebaList
{

    // Se prueba el método add y el método get.
    
    @Test
    public void testAdd_testGet()
    {
        List<Integer> list = new SingleLinkedList<>();
        list.add(13);
        list.add(22);
        assertEquals(13, list.get(0));
        assertEquals(22, list.get(1));
    }

    // Se prueba el método remove.

    @Test
    public void testRemove()
    {
        List<Integer> list = new DoubleLinkedList<>();
        list.add(25);
        list.add(40);
        assertEquals(25, list.remove(0));
        assertEquals(40, list.get(0));
    }

    // Se prueba el método size.

    @Test
    public void testSize()
    {
        List<Integer> list = new SingleLinkedList<>();
        assertEquals(0, list.size());
        list.add(57);
        list.add(75);
        assertEquals(2, list.size());
    }

    // Se prueba el método isEmpty.

    @Test
    public void testIsEmpty()
    {
        List<Integer> list = new DoubleLinkedList<>();
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }
}