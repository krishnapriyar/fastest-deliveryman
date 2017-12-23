/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Lysan Chen
 */
public class MenuItem {
    
  int itemID;
  String itemName, category, promoInfo;
  double price;

    public MenuItem(int itemID, String itemName, String category, String promoInfo, double price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.category = category;
        this.promoInfo = promoInfo;
        this.price = price;
    }

    public MenuItem() {
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

    public String getPromoInfo() {
        return promoInfo;
    }

    public double getPrice() {
        return price;
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

    public void setPromoInfo(String promoInfo) {
        this.promoInfo = promoInfo;
    }

    public void setPrice(double price) {
        this.price = price;
    }
  
  
}
