/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Priya
 */
public interface DeliverymanInterface<T> {
    
    boolean addDelivery(T delivery);
    boolean removeDelivery(T delivery);
    ListInterface<T> getDeliveryList();
    
}
