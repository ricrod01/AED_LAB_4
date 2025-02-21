/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase principal.
 * fecha_creación = 20/02/2025
 * fecha_modificación = 20/02/2025
 */

 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.Test;

public class PruebaCalculadora
{

    // Se prueba el método Traductor.
    
    @Test
    public void testTraductor()
    {
        Stack<Double> stack1 = new StackArrayList<>();
        Stack<Character> stack2 = new StackArrayList<>();
        Calculadora calc = Calculadora.Instancia(stack1, stack2);
        assertEquals("1 4 + 5 3 + 2 ^ * 3 /", calc.Traductor("(1 + 4)*(5 + 3)^2/3"));
    }

    // Se prueba el método Resultado.

    @Test
    public void testResultado()
    {
        Stack<Double> stack1 = new StackArrayList<>();
        Stack<Character> stack2 = new StackArrayList<>();
        Calculadora calc = Calculadora.Instancia(stack1, stack2);
        assertEquals(32, calc.Resultado("(1 + 4)*(5 + 3)^2/10"));
    }

}