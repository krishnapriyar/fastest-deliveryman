package ModuleE.entity;

public class OrderedItemClass {
    private int id;
    private String itemName;
    private Double itemPrice;
    private Double totalPrice;
    private int qty;
   
    public OrderedItemClass(int id,String itemName, Double itemPrice)
    {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    
    public OrderedItemClass(int id,String itemName, Double itemPrice, Double totalPrice, int qty)
    {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
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
