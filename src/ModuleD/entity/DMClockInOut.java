/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleD.entity;

import java.util.Date;

/**
 *
 * @author Kai Yan
 */
public class DMClockInOut {
    private String dmName ;
    private int dmID;
    private String status;
    private Date setClockInDate;
    private Date setClockInTime;
    private Date setClockOutTime;

    public DMClockInOut(String dmName, int dmID, String status) {
        this.dmName = dmName;
        this.dmID = dmID;
        this.status = status;
    }

    public DMClockInOut(String dmName, int dmID, String status, Date setClockInDate, Date setClockInTime, Date setClockOutTime) {
        this.dmName = dmName;
        this.dmID = dmID;
        this.status = status;
        this.setClockInDate = setClockInDate;
        this.setClockInTime = setClockInTime;
        this.setClockOutTime = setClockOutTime;
    }
    
    
    public String getDmName() {
        return dmName;
    }

    public void setDmName(String dmName) {
        this.dmName = dmName;
    }

    public int getDmID() {
        return dmID;
    }

    public void setDmID(int dmID) {
        this.dmID = dmID;
    }
    
    public DMClockInOut(String dmName, int dmID)
    {
        this.dmName = dmName;
        this.dmID =dmID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setClockInDate(Date setClockInDate){
        this.setClockInDate=setClockInDate;
    }
    
    public Date getClockInDate(){
        return setClockInDate;
    }
    
    public void setClockInTime(Date setClockInTime){
        this.setClockInTime = setClockInTime;
    }
    
    public Date getClockInTime(){
        return setClockInTime;
    }
    
    public void setClockOutTime(Date setClockOutTime){
        this.setClockOutTime = setClockOutTime;
    }
    
    public Date getClockOutTime(){
        return setClockOutTime;
    }
}
