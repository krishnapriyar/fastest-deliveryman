/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.adt;


public interface QueueInterface<T> {
    /**
   * Task: Adds a new entry to the back of the queue.
   *
   * @param newEntry an object to be added
   */
  public void enqueue(T newEntry);

  /**
   * Task: Removes and returns the entry at the front of the queue.
   *
   * @return either the object at the front of the queue or, if the queue is
   * empty before the operation, null
   */
  public T dequeue();

  /**
   * Task: Retrieves the entry at the front of the queue.
   *
   * @return either the object at the front of the queue or, if the queue is
   * empty, null
   */

  public boolean isEmpty();

  /**
   * Task: Removes all entries from the queue.
   */
  public void clear();
  
  public int getSize();
}
