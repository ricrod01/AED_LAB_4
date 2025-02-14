public class StackFactory
{
    public enum StackType
    {
        ARRAY_LIST, VECTOR, LINKED_LIST
    }

    public static <T> Stack<T> createStack(StackType type, ListFactory<T> listFactory, ListFactory.ListType listType)
    {
        switch (type) {
            case ARRAY_LIST:
                return new StackArrayList<>();
            case VECTOR:
                return new StackVector<>();
            case LINKED_LIST:
                if (listFactory == null)
                {
                    throw new IllegalArgumentException("Se requiere un ListFactory para crear StackList");
                }
                return new StackList<>(listFactory.createList(listType));
            default:
                throw new IllegalArgumentException("Tipo de Stack no válido");
        }
    }
}
