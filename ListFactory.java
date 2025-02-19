/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase que crea distintos tipos e listas (simple o doblemente enlazadas).
 * fecha_creación = 14/02/2025
 * fecha_modificación = 16/02/2025
 */

public class ListFactory<T>
{

    // Se enumeran los tipos de listas.

    public enum ListType 
    {
        SINGLE_LINKED, DOUBLE_LINKED
    }

    /**
     * @param type Tipo de lista a crear.
     * @return Lista creada, con el tipo requerido.
    */

    public List<T> createList(ListType type)
    {
        switch (type)
        {
            case SINGLE_LINKED:
                return new SingleLinkedList<>();
            case DOUBLE_LINKED:
                return new DoubleLinkedList<>();
            default:
                throw new IllegalArgumentException("Tipo de List no válido");
        }
    }
}
