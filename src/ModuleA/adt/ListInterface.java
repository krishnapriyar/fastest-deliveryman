/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;


/**
 *
 * @author Lysan Chen
 */
public interface ListInterface<T> {
    void add(T newEntry);
    boolean remove(T anEntry);
    T getEntry(int index);
    boolean contains(T anEntry);
    boolean isEmpty();
    String toString();
    
}
