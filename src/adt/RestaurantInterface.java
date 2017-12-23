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
public interface RestaurantInterface<T> {
    
    boolean addItemToMenu(T Item);
    T getItemFromMenu(T Item);
    boolean removeItemFromMenu(T Item);
    
    
}
