/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

public class ConfirmOrder {
    
    private String itemName;
    private Double itemPrice;
    private Double totalPrice;
    private int qty;
   
    public ConfirmOrder(){
    
    
    }
    
    public ConfirmOrder(String itemName, Double itemPrice, Double totalPrice, int qty)
    {
        this.itemName = itemName;
        this.itemPrice = itemPrice;    
        this.totalPrice = totalPrice;
        this.qty = qty;
    }
    
    public String getItemName()
    {
        return itemName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public Double getItemPrice()
    {
        return itemPrice;
    }
    
}
