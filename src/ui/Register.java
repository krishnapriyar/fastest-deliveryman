
package ui;

/**
 *
 * @author Lysan Chen
 */
public class Register {
    
    String BussName, BussRegNo, address, password, userName, Person, GPSCo, email;
    int TelNo, affID, GSTRegNo;

    public Register() {
    }

    public Register(String BussName, String BussRegNo, String address, String password, String userName, String Person, String GPSCo, String email, int TelNo, int affID, int GSTRegNo) {
        this.BussName = BussName;
        this.BussRegNo = BussRegNo;
        this.address = address;
        this.password = password;
        this.userName = userName;
        this.Person = Person;
        this.GPSCo = GPSCo;
        this.email = email;
        this.TelNo = TelNo;
        this.affID = affID;
        this.GSTRegNo = GSTRegNo;
    }



    public String getBussName() {
        return BussName;
    }

    public String getBussRegNo() {
        return BussRegNo;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

 
    public String getPerson() {
        return Person;
    }

    public String getGPSCo() {
        return GPSCo;
    }

    public int getTelNo() {
        return TelNo;
    }

    public int getAffID() {
        return affID;
    }

    public int getGSTRegNo() {
        return GSTRegNo;
    }

    public String getEmail() {
        return email;
    }

    public void setBussName(String BussName) {
        this.BussName = BussName;
    }

    public void setBussRegNo(String BussRegNo) {
        this.BussRegNo = BussRegNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setPerson(String Person) {
        this.Person = Person;
    }

    public void setGPSCo(String GPSCo) {
        this.GPSCo = GPSCo;
    }

    public void setTelNo(int TelNo) {
        this.TelNo = TelNo;
    }

    public void setAffID(int affID) {
        this.affID = affID;
    }

    public void setGSTRegNo(int GSTRegNo) {
        this.GSTRegNo = GSTRegNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    
}
