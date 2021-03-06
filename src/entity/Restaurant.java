/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.*;
/**
 *
 * @author Lysan Chen
 */
public class Restaurant {
    
    private int affID;
    private String bussName;
    private String bussRegNo;
    private int gstRegNo;
    private String personInCharged;
    private String address;
    private int telNo;
    private String GPS;
    private CircularLinkedList<RestaurantItem> menu;

    public Restaurant() {
    }

    public Restaurant(int affID, String bussName, String bussRegNo, int gstRegNo, String personInCharged, String address, int telNo, String GPS) {
        this.affID = affID;
        this.bussName = bussName;
        this.bussRegNo = bussRegNo;
        this.gstRegNo = gstRegNo;
        this.personInCharged = personInCharged;
        this.address = address;
        this.telNo = telNo;
        this.GPS = GPS;
        menu = new CircularLinkedList<RestaurantItem>();
    }

    public int getAffID() {
        return affID;
    }

    public void setAffID(int affID) {
        this.affID = affID;
    }

    public String getBussName() {
        return bussName;
    }

    public void setBussName(String bussName) {
        this.bussName = bussName;
    }

    public String getBussRegNo() {
        return bussRegNo;
    }

    public void setBussRegNo(String bussRegNo) {
        this.bussRegNo = bussRegNo;
    }

    public int getGstRegNo() {
        return gstRegNo;
    }

    public void setGstRegNo(int gstRegNo) {
        this.gstRegNo = gstRegNo;
    }

    public String getPersonInCharged() {
        return personInCharged;
    }

    public void setPersonInCharged(String personInCharged) {
        this.personInCharged = personInCharged;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelNo() {
        return telNo;
    }

    public void setTelNo(int telNo) {
        this.telNo = telNo;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "affID=" + affID + ", bussName=" + bussName + ", bussRegNo=" + bussRegNo + ", gstRegNo=" + gstRegNo + ", personInCharged=" + personInCharged + ", address=" + address + ", telNo=" + telNo + ", GPS=" + GPS + '}';
    }

    public CircularLinkedList<RestaurantItem> getMenu() {
        return menu;
    }

    public void setMenu(CircularLinkedList<RestaurantItem> menu) {
        this.menu = menu;
    }

 
    
    
}
