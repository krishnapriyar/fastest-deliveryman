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
public interface ListInterface2<T> {
    void add(T Entry);
    boolean remove(T Entry);
    T getEntry(int index);
    boolean contains(T Entry);
  
}
