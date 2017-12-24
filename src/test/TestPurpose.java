package test;

import ModuleB.entity.Deliveryman;
import ModuleE.adt.ListImplementation;
import ModuleE.adt.myListInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author chong
 */
public class TestPurpose {

    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static Connection conn = null;
    private static PreparedStatement prepare;
    private static ResultSet rs = null;
    static myListInterface<Deliveryman> list = new ListImplementation<Deliveryman>();

    public void setList(myListInterface<Deliveryman> arrlist) {
        list = arrlist;
    }

    public myListInterface<Deliveryman> getList() {
        return list;
    }

    public TestPurpose() {
        getDMInfo();
    }

    private void getDMInfo() {
        if (connection() == true) {
            try {

                prepare = conn.prepareStatement("SELECT * FROM DELIVERYMAN");
                rs = prepare.executeQuery();

                while (rs.next()) {
                    list.addNewItem(new Deliveryman(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    private boolean connection() {
        boolean isSuccess = false;

        try {
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                isSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return isSuccess;
    }
}
