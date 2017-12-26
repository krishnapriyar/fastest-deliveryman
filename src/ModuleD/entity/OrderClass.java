package ModuleD.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class OrderClass {

    private int orderID;
    private String statusDelivery;
    private int distance;
    private double totalAmount;
    private int dmID;
    private String address;
    private String custName;
    private Date orderDate;
    private Date orderTime;
    private String postCode;
    private double latitude, longitude;
    private int custTelNo;
    private int custID;

    public OrderClass(int orderID, double totalAmount, int custID, String address, int phoneNO, String statusDelivery, int dmID) {
        this.orderID = orderID;
        this.statusDelivery = statusDelivery;
        this.custID = custID;
        this.distance = distance;
        this.address = address;
        this.totalAmount = totalAmount;
        this.dmID = dmID;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public OrderClass(String postCode, double latitude, double longitude) {
        this.postCode = postCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getCustTelNo() {
        return custTelNo;
    }

    public void setCustTelNo(int custTelNo) {
        this.custTelNo = custTelNo;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
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

    public String getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(String statusDelivery) {
        this.statusDelivery = statusDelivery;
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
