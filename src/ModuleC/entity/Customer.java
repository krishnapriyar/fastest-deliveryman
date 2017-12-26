
package ModuleC.entity;

public class Customer {

    private String cusName;
    private String cusTelNo;
    private String cusAddress;
    private int cusID;

    public Customer() {
    }

    
    
    public Customer(int cusID, String cusName, String cusTelNo, String cusAddress) {
        this.cusName = cusName;
        this.cusTelNo = cusTelNo;
        this.cusAddress = cusAddress;
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusTelNo() {
        return cusTelNo;
    }

    public void setCusTelNo(String cusTelNo) {
        this.cusTelNo = cusTelNo;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }
    
    
}
