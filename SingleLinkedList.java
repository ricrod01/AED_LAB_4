public class SingleLinkedList<T> extends abstractList<T>
{
    private class Node
    {
        T data;
        Node next;

        Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SingleLinkedList()
    {
        this.head = null;
    }

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
