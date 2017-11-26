
package ui;

public class DMWorkStat {
    private String dmName ;
    private int dmID;
    private String activeStat;

//    public String getActiveStat() {
//        return activeStat;
//    }
//
//    public void setActiveStat(String activeStat) {
//        this.activeStat = activeStat;
//    }
//    

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
    
    
    public DMWorkStat(String dmName , int dmID)
    {
        this.dmName = dmName;
        this.dmID = dmID;
        //this.activeStat = activeStat;
        
    }
}
