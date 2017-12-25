
package ModuleE.entity;

/**
 *
 * @author chong kun ming
 */
public class RestaurantClass {
    private int resID;
    private String resName;

    public RestaurantClass(int resID, String resName) {
        this.resID = resID;
        this.resName = resName;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }
    
    
}
