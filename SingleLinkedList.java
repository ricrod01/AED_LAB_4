/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase para las listas simplemente enlazadas.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 16/02/2025
 */

public class SingleLinkedList<T> extends abstractList<T>
{

    // Clase que define el nodo.

    private class Node
    {
        T data;
        Node next;

        /**
        * @param data Objeto que estará en el nodo.
        */

        Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Constructor

    public SingleLinkedList()
    {
        this.head = null;
    }

    /**
     * @param item Objeto a agregar a la lista.
    */

    @Override
    public void add(T item)
    {
        Node newNode = new Node(item);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        count++;
    }

    /**
     * @param index Posición del objeto a quitar de la lista.
     * @return Objeto a quitar de la lista.
    */

    @Override
    public T remove(int index)
    {
        if (index < 0 || index >= count)
        {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node temp = head;
        if (index == 0)
        {
            head = head.next;
        } 
        else
        {
            Node prev = null;
            for (int i = 0; i < index; i++)
            {
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
        }
        count--;
        return temp.data;
    }

    /**
     * @param index Índice del elemento requerido.
     * @return Objeto en la posición del índice.
    */

    @Override
    public T get(int index)
    {
        if (index < 0 || index >= count)
        {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node temp = head;
        for (int i = 0; i < index; i++)
        {
            temp = temp.next;
        }
        return temp.data;
    }
}
