/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.entity;


import ModuleB.adt.*;

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
    private LinkedQueue<Order> deliveryQ;

    public Deliveryman() {
        deliveryQ = new LinkedQueue<Order>();
    }

    public Deliveryman(int dmID, String dmName, String dmIC, String dmTelNo, String dmAddress, String activeStatus, String availability, LinkedQueue<Order> deliveryQ) {
        this.dmID = dmID;
        this.dmName = dmName;
        this.dmIC = dmIC;
        this.dmTelNo = dmTelNo;
        this.dmAddress = dmAddress;
        this.activeStatus = activeStatus;
        this.availability = availability;
        this.deliveryQ = deliveryQ;
    }

    public Deliveryman(int dmID, String dmName, String dmIC, String dmTelNo, String dmAddress, String activeStatus, String availability) {
        this.dmID = dmID;
        this.dmName = dmName;
        this.dmIC = dmIC;
        this.dmTelNo = dmTelNo;
        this.dmAddress = dmAddress;
        this.activeStatus = activeStatus;
        this.availability = availability;
        deliveryQ = new LinkedQueue<Order>();
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

    private LinkedQueue<Order> getDeliveryQ() {
        return deliveryQ;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public boolean addDelivery(Object delivery) {
        //add a new delivery
        deliveryQ.enqueue((Order) delivery);
        return true;
    }

    @Override
    public boolean removeDelivery(Object delivery) {
        //This method is intended for removing specific delivery if it has been reassigned
        
        LinkedQueue<Order> tempQ = new LinkedQueue<Order>();
        Order order;
        int initialSize = deliveryQ.getSize();
        
        for (int i = 0; i < initialSize; i++) {           
            order = deliveryQ.dequeue();
            if(!order.equals(delivery)){
                tempQ.enqueue(order);
            }
        }
        deliveryQ = tempQ;
        return false;

    }


    @Override
    public Object getDelivery() {
        //get the delivery on top of queue to complete
        return deliveryQ.dequeue();
    }

    @Override
    public QueueInterface getDeliveryQueue() {
        //get copy of queue
        
        LinkedQueue<Order> tempQ1 = new LinkedQueue<Order>();
        LinkedQueue<Order> tempQ2 = new LinkedQueue<Order>();
        Order order;
        int initialSize = deliveryQ.getSize();
        
        for (int i = 0; i < initialSize; i++) {           
            order = deliveryQ.dequeue();
            tempQ1.enqueue(order);
            tempQ2.enqueue(order);
        }
        deliveryQ = tempQ1;
        
        
        
        
        return tempQ2;
    }

}
