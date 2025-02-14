public class StackList<T> extends abstractStack<T>
{
    private List<T> list;

    public StackList(List<T> list)
    {
        this.list = list;
    }

    @Override
    public void push(T item)
    {
        list.add(item);
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
        return list.remove(list.size() - 1);
    }
}
