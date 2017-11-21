package ui;


public class Item {
    
    private String itemName;
    private Double itemPrice;
    private Double totalPrice;
    private int qty;
   
    public Item(String itemName, Double itemPrice)
    {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
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
