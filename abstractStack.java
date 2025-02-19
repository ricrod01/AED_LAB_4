/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase del ADT del Stack.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 16/02/2025
 */

public abstract class abstractStack<T> implements Stack<T>
{
    protected int count;

    // Constructor

    public abstractStack()
    {
        this.count = 0;
    }

    /**
     * @return Devuelve True si está vacío y False en caso contrario.
    */

    @Override
    public boolean isEmpty()
    {
        return count == 0;
    }

    /**
     * @return Devuelve el tamaño del stack.
    */

    @Override
    public int size()
    {
        return count;
    }
}