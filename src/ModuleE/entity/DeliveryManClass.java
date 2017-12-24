
package ModuleE.entity;

/**
 *
 * @author chong
 */
public class DeliveryManClass {
    private int dmID;
    private String dmName;
    private String dmStatus;
    
    public DeliveryManClass(int dmID, String dmName, String dmStatus){
        this.dmID = dmID;
        this.dmName = dmName;
        this.dmStatus = dmStatus;
    }

    public int getDmID() {
        return dmID;
    }

    public void setDmID(int dmID) {
        this.dmID = dmID;
    }

    public String getDmName() {
        return dmName;
    }

    public void setDmName(String dmName) {
        this.dmName = dmName;
    }

    public String getDmStatus() {
        return dmStatus;
    }

    public void setDmStatus(String dmStatus) {
        this.dmStatus = dmStatus;
    }
    
    
}
