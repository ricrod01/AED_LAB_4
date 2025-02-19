/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase que permite crear los distintos tipos de stack.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 16/02/2025
 */

public class StackFactory
{
    public enum StackType
    {
        ARRAY_LIST, VECTOR, LINKED_LIST
    }

    public static <T> Stack<T> createStack(StackType type, ListFactory<T> listFactory, ListFactory.ListType listType)
    {
        switch (type) 
        {
            case ARRAY_LIST:
                return new StackArrayList<>();
            case VECTOR:
                return new StackVector<>();
            case LINKED_LIST:
                if (listFactory == null)
                {
                    throw new IllegalArgumentException("Se requiere un ListFactory para crear el StackList");
                }
                return new StackList<>(listFactory.createList(listType));
            default:
                throw new IllegalArgumentException("Tipo de Stack no válido");
        }
    }
}
