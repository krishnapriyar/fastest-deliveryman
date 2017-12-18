/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import adt.*;
/**
 *
 * @author Priya
 */
public class TestLL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedList<Character> ll = new LinkedList();
        
        ll.add('a');
        ll.add('b');
        ll.add('c');
        
        System.out.println(ll.getEntry(2));
        
        
    }
    
}
