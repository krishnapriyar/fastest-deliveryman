package ui;

import java.util.Date;


public class Item {
    
    private String itemName;
    private Double itemPrice;
    private Double totalPrice;
    private int qty;
    private Date orderedDate;
    private Date orderedTime;
    private int distance;
   
    public Item(String itemName, Double itemPrice)
    {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    
    public Item(String itemName, Double itemPrice, Double totalPrice, int qty, Date orderedDate, Date orderedTime, int distance)
    {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.totalPrice = totalPrice;
        this.qty = qty;
        this.orderedDate = orderedDate;
        this.orderedTime = orderedTime;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Date getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Date orderedTime) {
        this.orderedTime = orderedTime;
    }
    
    
    public String getItemName()
    {
        return itemName;
    }
    
    public Double getItemPrice()
    {
        return itemPrice;
    }
    
    public Double getTotalPrice(){
        return totalPrice;
    }
    
    public int getQty()
    {
        return qty;
    }
    
    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    public void setQty(int qty)
    {
        this.qty = qty;
    }
}
