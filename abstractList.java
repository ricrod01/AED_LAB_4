/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase del ADT List.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 16/02/2025
 */

public abstract class abstractList<T> implements List<T>
{
    protected int count;

    // Constructor

    public abstractList()
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
     * @return Devuelve el tamaño de la lista.
    */

    @Override
    public int size() 
    {
        return count;
    }
}
