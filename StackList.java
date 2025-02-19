/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase para el Stack tipo List.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 16/02/2025
 */

public class StackList<T> extends abstractStack<T>
{
    private List<T> list;

    /**
    * @param list Lista que se creará.
    */

    public StackList(List<T> list)
    {
        this.list = list;
    }

    /**
     * @param item Objeto a agregar al stack.
    */

    @Override
    public void push(T item)
    {
        list.add(item);
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
        return list.remove(list.size() - 1);
    }

    /**
     * @return Devuelve el último elmento del stack.
    */

    @Override
    public T peek()
    {
        if (isEmpty()) {
            throw new RuntimeException("El Stack está vacío.");
        }
        return list.get(list.size() - 1);
    }
}
