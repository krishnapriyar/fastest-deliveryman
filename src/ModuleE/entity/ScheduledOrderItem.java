
package ModuleE.entity;

public class ScheduledOrderItem{
    private double itemUnitPrice;
    private String itemName;
    private int qty;
    private int scheduleOrderID;

    public ScheduledOrderItem(double itemUnitPrice, int qty, String itemName, int scheduleOrderID){
      
        this.itemUnitPrice = itemUnitPrice;
        this.qty = qty;
        this.itemName = itemName;
        this.scheduleOrderID = scheduleOrderID;
    }
    

    public double getUnitPrice() {
        return itemUnitPrice;
    }

    public void setUnitPrice(double itemUnitPrice) {
        this.itemUnitPrice = itemUnitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemID(String itemName) {
        this.itemName = itemName;
    }

    public int getScheduleOrderID() {
        return scheduleOrderID;
    }

    public void setScheduleOrderID(int scheduleOrderID) {
        this.scheduleOrderID = scheduleOrderID;
    }
    
    
}
