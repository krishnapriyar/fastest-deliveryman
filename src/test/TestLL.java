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
        
       LinkedQueue<RestaurantItem> ll = new LinkedQueue();
        
        RestaurantItem item = new RestaurantItem();
        RestaurantItem item1 = new RestaurantItem();
        RestaurantItem item2 = new RestaurantItem();
        RestaurantItem item3 = new RestaurantItem();
        item.setItemID(20001);
        item1.setItemID(20002);
        item2.setItemID(20003);
        item3.setItemID(20004);
        
        ll.enqueue(item);
        ll.enqueue(item1);
        ll.enqueue(item2);
        ll.enqueue(item3);
        System.out.println("List"+ll);
        
        
        
        System.out.println("Dequeue"+ll.dequeue()+"\n");

        System.out.println("List"+ll);
        System.out.println("Dequeue2"+ll.dequeue()+"\n");

        System.out.println("Dequeue3"+ll.dequeue()+"\n");

        System.out.println("List"+ll);
        System.out.println("Dequeue4"+ll.dequeue()+"\n");
        System.out.println("Dequeue5"+ll.dequeue()+"\n");

        System.out.println("List"+ll);
        

        
        
    }
    
}
