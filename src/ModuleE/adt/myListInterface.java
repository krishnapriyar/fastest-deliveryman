/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleE.adt;

/**
 *
 * @author chong
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
