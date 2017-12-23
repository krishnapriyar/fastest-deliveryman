/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Lysan Chen
 */
public interface StackInterface<T> {
     public void push(T newEntry);

  /**
   * Task: Removes and returns the stack's top entry.
   *
   * @return either the object at the top of the stack or, if the stack is empty
   * before the operation, null
   */
  public T pop();

  /**
   * Task: Retrieves the stack's top entry.
   *
   * @return either the object at the top of the stack or null if the stack is
   * empty
   */
  public T peek();

  /**
   * Task: Detects whether the stack is empty.
   *
   * @return true if the stack is empty
   */
  public boolean isEmpty();

  /**
   * Task: Removes all entries from the stack
   */
  public void clear();
  
  
} // end StackInterface

