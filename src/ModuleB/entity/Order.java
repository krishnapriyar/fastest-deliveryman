/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.entity;

import entity.*;
import java.util.Date;

/**
 *
 * @author Priya
 */
public class Order {
    
    private int orderID;
    private Date dateTime;
    private String deliveryStatus;
    private String ETA;
    private int custID;
    private int dmID;
    private int restaurantID;

    public Order(int orderID, Date dateTime, String deliveryStatus, String ETA, int custID, int dmID, int restaurantID) {
        this.orderID = orderID;
        this.dateTime = dateTime;
        this.deliveryStatus = deliveryStatus;
        this.ETA = ETA;
        this.custID = custID;
        this.dmID = dmID;
        this.restaurantID = restaurantID;
        
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the dateTime
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the deliveryStatus
     */
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     * @param deliveryStatus the deliveryStatus to set
     */
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    /**
     * @return the ETA
     */
    public String getETA() {
        return ETA;
    }

    /**
     * @param ETA the ETA to set
     */
    public void setETA(String ETA) {
        this.ETA = ETA;
    }

    /**
     * @return the custID
     */
    public int getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(int custID) {
        this.custID = custID;
    }

    /**
     * @return the dmID
     */
    public int getDmID() {
        return dmID;
    }

    /**
     * @param dmID the dmID to set
     */
    public void setDmID(int dmID) {
        this.dmID = dmID;
    }
    
}
