package ModuleE.adt;

/**
 *
 * @author chong kun ming RSD 3
 * @param <T>
 */
public interface SortedListInterface<T extends Comparable<T>> {
    
    public void addEntry(T newEntry);
    
    public T getEntry(int position);
    
    public int size();
    
    public boolean isEmpty();
    
}
