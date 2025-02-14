import java.util.ArrayList;

public class StackArrayList<T> extends abstractStack<T>
{
    private ArrayList<T> stack;

    public StackArrayList()
    {
        stack = new ArrayList<>();
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
            throw new RuntimeException("Stack está vacío");
        }
        count--;
        return stack.remove(stack.size() - 1);
    }

}
