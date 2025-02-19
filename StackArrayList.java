/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase para el Stack tipo ArrayList.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 16/02/2025
 */

import java.util.ArrayList;

public class StackArrayList<T> extends abstractStack<T>
{
    private ArrayList<T> stack;

    // Constructor.

    public StackArrayList()
    {
        stack = new ArrayList<>();
    }

    /**
     * @param item Objeto a agregar al stack.
    */

    @Override
    public void push(T item)
    {
        stack.add(item);
        count++;
    }

    /**
     * @return Elimina el último elmento del stack y lo devuelve.
    */

    @Override
    public T pop()
    {
        if (isEmpty())
        {
            throw new RuntimeException("El Stack está vacío.");
        }
        count--;
        return stack.remove(stack.size() - 1);
    }

    /**
     * @return Devuelve el último elmento del stack.
    */

    @Override
    public T peek() 
    {
        if (isEmpty())
        {
            throw new RuntimeException("El Stack está vacío");
        }
        return stack.get(stack.size() - 1);
    }

}
