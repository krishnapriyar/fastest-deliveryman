
package ModuleD.entity;


public class DeliveryManDet {
    
    private String DMName;
    private int DMID;
    private String DMStatus;

    public DeliveryManDet(String DMName, int DMID, String DMStatus) {
        this.DMName = DMName;
        this.DMID = DMID;
        this.DMStatus = DMStatus;
    }
    
    public String getDMName() {
        return DMName;
    }

    public void setDMName(String DMName) {
        this.DMName = DMName;
    }

    public int getDMID() {
        return DMID;
    }

    public void setDMID(int DMID) {
        this.DMID = DMID;
    }

    public String getDMStatus() {
        return DMStatus;
    }

    public void setDMStatus(String DMStatus) {
        this.DMStatus = DMStatus;
    }
    
}
