/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleE.entity;

import ModuleE.adt.ListImplementation;
import ModuleE.adt.myListInterface;
import java.util.Date;

public class ScheduledOrderClass implements Comparable<ScheduledOrderClass>{

    private int orderID;
    private Date receiveDate;
    private Date receiveTime;
    private String status;
    private int distance;
    private double totalAmount;
    private int custID;
    private String dmName;

    public ScheduledOrderClass(int orderID, Date receiveDate, Date receiveTime, String status, int distance, double totalAmount, int custID, String dmName) {
        this.orderID = orderID;
        this.receiveDate = receiveDate;
        this.receiveTime = receiveTime;
        this.status = status;
        this.distance = distance;
        this.totalAmount = totalAmount;
        this.custID = custID;
        this.dmName = dmName;
    }  
   

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getDmName() {
        return dmName;
    }

    public void setDmName(String dmName) {
        this.dmName = dmName;
    }

    @Override
    public int compareTo(ScheduledOrderClass o) {
        if(this.getReceiveDate().compareTo(o.receiveDate) == 0){
            return this.getReceiveTime().compareTo(o.receiveTime);
        }
        return this.getReceiveDate().compareTo(o.receiveDate);
    }

}