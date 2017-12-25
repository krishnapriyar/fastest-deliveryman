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
public interface StackInterface<T> {

    void push(T newEntry);

    T pop();

    T peek();

    boolean isEmpty();

    void clear();

} // end StackInterface

