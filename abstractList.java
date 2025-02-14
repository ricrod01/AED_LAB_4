public abstract class abstractList<T> implements List<T>
{
    protected int count;

    public abstractList()
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
