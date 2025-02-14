public abstract class abstractStack<T> implements Stack<T>
{
    protected int count;

    public abstractStack()
    {
        this.count = 0;
    }

    @Override
    public boolean isEmpty()
    {
        return count == 0;
    }

    @Override
    public int size()
    {
        return count;
    }
}