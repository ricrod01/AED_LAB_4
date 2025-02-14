public class DoubleLinkedList<T> extends abstractList<T> {
    private class Node
    {
        T data;
        Node prev;
        Node next;

        Node(T data)
        {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public DoubleLinkedList()
    {
        this.head = null;
        this.tail = null;
    }

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
