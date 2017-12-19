/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import adt.*;
import entity.*;
/**
 *
 * @author Priya
 */
public class TestLL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedList<RestaurantItem> ll = new LinkedList();
        
        RestaurantItem item = new RestaurantItem();
        RestaurantItem item1 = new RestaurantItem();
        RestaurantItem item2 = new RestaurantItem();
        item.setItemID(20001);
        item1.setItemID(20002);
        item2.setItemID(20003);
        
        ll.add(item);
        ll.add(item1);
        ll.add(item2);
        ll.remove(item2);
        
        System.out.println(ll.getEntry(3));
        
        
    }
    
}
