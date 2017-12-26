package ModuleD.entity;

import ModuleD.adt.DMListImplementation;
import ModuleD.adt.DMListInterface;
import ModuleD.ui.TrackOrder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CalculateDistance {

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rSet;
    private static PreparedStatement prepare;
    private static int custID = 1;
    private static String postCode,custAddress = "";
    private static DMListInterface<OrderClass> tempList = new DMListImplementation<>();
    private TrackOrder trackOrderObj = new TrackOrder();
    private int orderID = trackOrderObj.orderID1;
 
    private static double toLatitude, toLongitude = 0.0;
    private static double fromLatitude = 3.2791;
    private static double fromLongitude = 101.7410;
    private static CalculateDistance obj = new CalculateDistance();

    public static int resDistance(int orderID) {


        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Fast");
            prepare = con.prepareStatement("SELECT * FROM POSTALCODES");
            rSet = prepare.executeQuery();

            while (rSet.next()) {
                postCode = rSet.getString("POSTALCODE");
                toLatitude = rSet.getDouble("LATITUDE");
                toLongitude = rSet.getDouble("LONGITUDE");
                tempList.addNewEntry(new OrderClass(postCode, toLatitude, toLongitude));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        for (int i = 0; i < new TrackOrder().listDM.retrieveSize(); i++) {
            if (new TrackOrder().listDM.retrieveAllEntry(i).getOrderID() == orderID) {
                custID = new TrackOrder().listDM.retrieveAllEntry(i).getCustID();
            }
        }

        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Fast");
            prepare = con.prepareStatement("SELECT CUSTADDRESS FROM CUSTOMER WHERE CUSTID = " + custID);
            rSet = prepare.executeQuery();

            if (rSet.next()) {
                custAddress = rSet.getString("CUSTADDRESS");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < tempList.retrieveSize(); i++) {
            if (custAddress.replace(",", "").trim().contains(tempList.retrieveAllEntry(i).getPostCode())) {
                toLatitude = tempList.retrieveAllEntry(i).getLatitude();
                toLongitude = tempList.retrieveAllEntry(i).getLongitude();
            }
        }
        Double temp = obj.distance(fromLatitude, fromLongitude, toLatitude, toLongitude);
        int temp2 = temp.intValue();

        return temp2;
    }

    public double distance(double lat1, double lon1, double lat2, double lon2) {

        double theta = lon1 - lon2;
        double distanceVar = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        distanceVar = Math.acos(distanceVar);
        distanceVar = rad2deg(distanceVar);
        distanceVar = distanceVar * 60 * 1.1515;
        distanceVar = distanceVar * 1.609344;

        return (Math.round(distanceVar));
    }

    public double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    public double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
