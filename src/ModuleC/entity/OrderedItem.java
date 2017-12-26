package ModuleC.entity;

import ModuleE.entity.*;
import java.util.Date;


public class OrderedItem {
    private int id;
    private String itmName;
    private Double itmPrice;
    private Double totalPrice;
    private int qty;
   
    public OrderedItem(int id,String itmName, Double itmPrice)
    {
        this.id = id;
        this.itmName = itmName;
        this.itmPrice = itmPrice;
    }
    
    public OrderedItem(int id,String itmName, Double itmPrice, Double totalPrice, int qty)
    {
        this.id = id;
        this.itmName = itmName;
        this.itmPrice = itmPrice;
        this.totalPrice = totalPrice;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getItemName()
    {
        return itmName;
    }
    
    public Double getItemPrice()
    {
        return itmPrice;
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
