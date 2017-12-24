
package ModuleD.entity;

import java.util.Date;



public class OrderClass {

    private int orderID;
    private String status;
    private int distance;
    private double totalAmount;
    private int dmID;
    private Date orderDate;
    private Date orderTime;

    public OrderClass(int orderID, double totalAmount, String custName, String address, int phoneNO , String status, int dmID) {
        this.orderID = orderID;
        this.status = status;
        this.distance = distance;
        this.totalAmount = totalAmount;
        this.dmID = dmID;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }  

    public int getDmID() {
        return dmID;
    }

    public void setDmID(int dmID) {
        this.dmID = dmID;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public Date getOrderDate() {
        return orderDate;
    }

    public void SetOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    public Date getOrderTime() {
        return orderTime;
    }

    public void SetOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
