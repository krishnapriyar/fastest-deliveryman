package ModuleD.adt;

public interface DMListInterface<T> {

    public boolean addNewEntry(T newEntry);
    public T retrieveAllEntry(int position);
    public boolean containAnEntry(T anEntry);
    public int retrieveSize();
    public boolean isEmpty();

}
