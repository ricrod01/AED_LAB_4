public class ListFactory<T>
{
    public enum ListType 
    {
        SINGLE_LINKED, DOUBLE_LINKED
    }

    public List<T> createList(ListType type)
    {
        switch (type)
        {
            case SINGLE_LINKED:
                return new SingleLinkedList<>();
            case DOUBLE_LINKED:
                return new DoubleLinkedList<>();
            default:
                throw new IllegalArgumentException("Tipo de List no válido");
        }
    }
}
