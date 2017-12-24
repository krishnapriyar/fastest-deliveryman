/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.entity;



/**
 *
 * @author Lysan Chen
 */

public class RestaurantItem {
    private int itemID;
    private String itemName;
    private String category;
    private double unitPrice;
    private String promoInfo;

    public RestaurantItem() {
    }

    public RestaurantItem(int itemID, String itemName, String category, double unitPrice, String promoInfo) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.category = category;
        this.unitPrice = unitPrice;
        this.promoInfo = promoInfo;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getPromoInfo() {
        return promoInfo;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setPromoInfo(String promoInfo) {
        this.promoInfo = promoInfo;
    }

    @Override
    public String toString() {
        return "Item{" + "itemID=" + itemID + ", itemName=" + itemName + ", category=" + category + ", unitPrice=" + unitPrice + ", promoInfo=" + promoInfo + '}';
    }
    
    
}
