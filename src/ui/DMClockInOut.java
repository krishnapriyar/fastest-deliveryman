/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Kai Yan
 */
public class DMClockInOut {
    private String dmName ;
    private int dmID;

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
    
}
