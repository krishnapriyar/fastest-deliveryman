/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import adt.*;
import entity.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author USHA
 */
public class PopulateDeliverymanList {

    Deliveryman dm1, dm2, dm3, dm4;
    CircularDoublyLinkedList<Deliveryman> dmList;

    private void setDMData() {
        try {
            
            dmList = new CircularDoublyLinkedList<Deliveryman>();

            dm1 = new Deliveryman(20031, "John Cena", "941207016467", "0167642876", "18 Jalan Ros|Taman Merah|81100|Johor Bahru", "Employed", "Available");
            dm2 = new Deliveryman(20032, "Farn Meng", "971130145623", "0161234567", "56 Jalan Mawar|Taman Kuning|81800|Ulu Tiram", "Employed", "Available");
            dm3 = new Deliveryman(20033, "Usha Lily", "890928146339", "0161235679", "01 Jalan Kemboja|Taman Hijau|81100|Johor Bahru", "Employed", "Available");
            dm4 = new Deliveryman(20034, "CK Wong", "941207016467", "0167642876", "45 Jalan Bakawali|Taman Biru|817500|Masai", "Employed", "Available");

            Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2017-12-28 07:30:00");
            Date date2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2017-12-28 08:30:30");
            Date date3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2017-12-28 08:15:15");
            Date date4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2017-12-28 07:40:40");

            Order ord = new Order(80001, date1, "Pending" , "00:20", 30001, 20011,40001);
            Order ord2 = new Order(80002, date3, "Pending" , "00:30", 30002, 20011,40002);
            Order ord3 = new Order(80003, date2, "Pending" , "00:20", 30003, 20011, 40003);
            dm1.addDelivery(ord);
            dm1.addDelivery(ord2);
            dm1.addDelivery(ord3);
            
            
            Order ord4 = new Order(80004, date1, "Pending" , "00:50", 30004, 20012,40001);
            Order ord5 = new Order(80005, date4, "Pending" , "00:30", 30005, 20013,40002);
            dm2.addDelivery(ord4);
            dm2.addDelivery(ord5);
            
            Order ord6 = new Order(80006, date2, "Pending" , "00:20", 30006, 20014,40001);
            Order ord7 = new Order(80007, date3, "Pending" , "00:30", 30007, 20014,40002);
            dm3.addDelivery(ord6);
            dm3.addDelivery(ord7);
            
            Order ord8 = new Order(80008, date4, "Pending" , "00:20", 30008, 20013,40003);
            dm4.addDelivery(ord8);
            
            
            Order ord9 = new Order(80001, date1, "Completed" , "00:20", 30001, 20011,40002);
            Order ord10 = new Order(80002, date3, "Completed" , "00:30", 30002, 20011,40002);
            Order ord11 = new Order(80003, date2, "Completed" , "00:20", 30003, 20011,40003);
            dm1.addDelivery(ord9);
            dm1.addDelivery(ord10);
            dm1.addDelivery(ord11);
            
            Order ord12 = new Order(80004, date1, "Completed" , "00:50", 30004, 20012,40001);
            Order ord13 = new Order(80005, date4, "Completed" , "00:30", 30005, 20013,40003);
            dm2.addDelivery(ord12);
            dm2.addDelivery(ord13);
            
            Order ord14 = new Order(80006, date2, "Completed" , "00:20", 30006, 20014,40002);
            Order ord15 = new Order(80007, date3, "Completed" , "00:30", 30007, 20014,40001);
            dm3.addDelivery(ord14);
            dm3.addDelivery(ord15);
            
            Order ord16 = new Order(80008, date4, "Completed" , "00:20", 30008, 20013,40003);
            dm4.addDelivery(ord16);   
            
        } catch (Exception ex) {
            
        }

    }
    
    public ListInterface getDMList(){
        
        setDMData();
        dmList.add(dm1);
        dmList.add(dm2);
        dmList.add(dm3);
        dmList.add(dm4);
        
        return dmList;
    
    }

}
