/**
 * @author Ricardo Rodríguez
 * @version 1
 * Interfase del Stack.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 16/02/2025
 */

public interface Stack<T>
{

    // Método para agregar un elemento.

    void push(T elemento);

    // Método para eliminar un elemento.

    T pop();

    // Método para obtener el tamaño del array.

    int size();

    // Método para determinar si el stack está vacío.

    boolean isEmpty();

    // Método para obtener el último elemento del array.

    T peek();
}