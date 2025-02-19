/**
 * @author Ricardo Rodríguez
 * @version 1
 * Interfase de la lista.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 16/02/2025
 */

public interface List<T> 
{
    // Método para agregar objetos a la lista.

    void add(T item);

    // Método para quitar objetos de la lista.

    T remove(int index);

    // Método para obtener un objeto de la lista.

    T get(int index);

    // Método para determinar si la lista está vacía.

    boolean isEmpty();

    // Método para determinar la cantidad de objetos presentes en la lista.
    
    int size();
}
