/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.adt;

/**
 *
 * @author Priya
 */
public interface QueueInterface<T> {

    void enqueue(T newEntry);

    T dequeue();

    T getFront();

    boolean isEmpty();

    void clear();
}
