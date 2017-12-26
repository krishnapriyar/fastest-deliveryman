
package ModuleE.entity;

import java.util.Date;

public class ScheduleOrderClass implements Comparable<ScheduleOrderClass>{

    private int orderID;
    private Date receiveDate;
    private Date receiveTime;
    private String status;
    private int distance;
    private double totalAmount;
    private int custID;
    private int dmID;
    private String dmName;

    public ScheduleOrderClass(int orderID, Date receiveDate, Date receiveTime, String status, int distance, double totalAmount, int custID, int dmID) {
        this.orderID = orderID;
        this.receiveDate = receiveDate;
        this.receiveTime = receiveTime;
        this.status = status;
        this.distance = distance;
        this.totalAmount = totalAmount;
        this.custID = custID;
        this.dmID = dmID;
    }  

    public String getDmName() {
        return dmName;
    }

    public void setDmName(String dmName) {
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

    public int getDmID() {
        return dmID;
    }

    public void setDmID(int dmID) {
        this.dmID = dmID;
    }

    @Override
    public int compareTo(ScheduleOrderClass o) {
        if(this.getReceiveDate().compareTo(o.receiveDate) == 0)
            return this.getReceiveTime().compareTo(o.receiveTime);
        
        return this.getReceiveDate().compareTo(o.receiveDate);
    }

}
