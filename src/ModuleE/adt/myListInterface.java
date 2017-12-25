
package ModuleE.adt;

/**
 *
 * @author chong kun ming RSD 3
 */
public interface myListInterface<T> {
    public void addNewItem(T newItem);
    public boolean removeItem(int index);
    public T getAllData(int position);
    public boolean foundMatch(T newEntry);
    public T getSingleData(int index);
    public int getSize();
    public void clearList();
    public boolean isEmpty();
}
