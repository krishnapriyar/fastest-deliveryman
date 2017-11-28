package ui;

public class ScheduleOrderClass {
    
    private int orderID;
    private String customerName;
    private String customerAddress;
    private String telNumber;
    private Double totalPrice;
    private int distance;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int itemID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public String toString()
    {
        return String.format("%-8s  %-30s  %-100s  %-20s  %-6s  %-5s ", orderID, customerName, customerAddress, telNumber, totalPrice, distance);
    }
    
    public ScheduleOrderClass(int orderID, String customerName, String customerAddress, String telNumber, Double totalPrice, int distance)
    {
        this.orderID = orderID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.telNumber = telNumber;
        this.totalPrice = totalPrice;
        this.distance = distance;
    }
}
