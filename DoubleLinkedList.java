/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase para las listas doblemente enlazadas.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 16/02/2025
 */

public class DoubleLinkedList<T> extends abstractList<T> 
{
    
    // Clase que define el nodo.

    private class Node
    {
        T data;
        Node prev;
        Node next;

        /**
        * @param data Objeto que estará en el nodo.
        */

        Node(T data)
        {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // Constructor

    public DoubleLinkedList()
    {
        this.head = null;
        this.tail = null;
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
            head = tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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
            if (head != null)
            {
                head.prev = null;
            }
            else
            {
                tail = null;
            }
        }
        else if (index == count - 1)
        {
            temp = tail;
            tail = tail.prev;
            tail.next = null;
        } 
        else 
        {
            for (int i = 0; i < index; i++)
            {
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
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
