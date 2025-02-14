import java.util.Vector;

public class StackVector<T> extends abstractStack<T>
{
    private Vector<T> stack;

    public StackVector()
    {
        stack = new Vector<>();
    }

    @Override
    public void push(T item)
    {
        stack.add(item);
        count++;
    }

    @Override
    public T pop()
    {
        if (isEmpty())
        {
            throw new RuntimeException("Stack is empty");
        }
        count--;
        return stack.remove(stack.size() - 1);
    }
}
