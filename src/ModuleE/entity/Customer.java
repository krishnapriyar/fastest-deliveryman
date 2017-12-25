
package ModuleE.entity;

public class Customer {

    private String custName;
    private String custTelNo;
    private String custAddress;
    private int custID;

    public Customer() {
    }

    
    
    public Customer(int custID, String custName, String custTelNo, String custAddress) {
        this.custName = custName;
        this.custTelNo = custTelNo;
        this.custAddress = custAddress;
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustTelNo() {
        return custTelNo;
    }

    public void setCustTelNo(String custTelNo) {
        this.custTelNo = custTelNo;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }
    
    
}
