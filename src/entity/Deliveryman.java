/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.*;

/**
 *
 * @author Priya
 */
public class Deliveryman implements DeliverymanInterface {

    private int dmID;
    private String dmName;
    private String dmIC;
    private String dmTelNo;
    private String dmAddress;
    private String activeStatus;
    private String availability;
    private LinkedList<Order> deliveryList;

    public Deliveryman() {
        deliveryList = new LinkedList<Order>();
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

    /**
     * @return the dmName
     */
    public String getDmName() {
        return dmName;
    }

    /**
     * @param dmName the dmName to set
     */
    public void setDmName(String dmName) {
        this.dmName = dmName;
    }

    /**
     * @return the dmIC
     */
    public String getDmIC() {
        return dmIC;
    }

    /**
     * @param dmIC the dmIC to set
     */
    public void setDmIC(String dmIC) {
        this.dmIC = dmIC;
    }

    /**
     * @return the dmTelNo
     */
    public String getDmTelNo() {
        return dmTelNo;
    }

    /**
     * @param dmTelNo the dmTelNo to set
     */
    public void setDmTelNo(String dmTelNo) {
        this.dmTelNo = dmTelNo;
    }

    /**
     * @return the dmAddress
     */
    public String getDmAddress() {
        return dmAddress;
    }

    /**
     * @param dmAddress the dmAddress to set
     */
    public void setDmAddress(String dmAddress) {
        this.dmAddress = dmAddress;
    }

    /**
     * @return the activeStatus
     */
    public String getActiveStatus() {
        return activeStatus;
    }

    /**
     * @param activeStatus the activeStatus to set
     */
    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    /**
     * @return the availability
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public boolean addDelivery(Object delivery) {

        deliveryList.add((Order) delivery);
        return true;
    }

    @Override
    public boolean removeDelivery(Object delivery) {

        for (int i = 0; i < deliveryList.getNumberOfEntries(); i++) {

            if (deliveryList.contains((Order) delivery)) {
                {
                    deliveryList.remove((Order) delivery);
                    return true;
                }

            }

        }
        return false;

    }

    @Override
    public ListInterface getDeliveryList() {
        return deliveryList;
    }

}
