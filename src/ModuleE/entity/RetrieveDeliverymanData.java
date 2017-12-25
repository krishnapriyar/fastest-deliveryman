package ModuleE.entity;

/**
 *
 * @author chong kun ming RSD 3
 */
public class RetrieveDeliverymanData {

    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static java.sql.Connection conn = null;
    private static java.sql.PreparedStatement prepare;
    private static java.sql.ResultSet rs = null;
    static ModuleE.adt.myListInterface<ModuleB.entity.Deliveryman> list = new ModuleE.adt.ListImplementation<ModuleB.entity.Deliveryman>();

    public void setList(ModuleE.adt.myListInterface<ModuleB.entity.Deliveryman> arrlist) {
        list = arrlist;
    }

    public ModuleE.adt.myListInterface<ModuleB.entity.Deliveryman> getList() {
        return list;
    }

    public RetrieveDeliverymanData() {
        getDMInfo();
    }

    private void getDMInfo() {
        if (connection() == true) {
            try {
                prepare = conn.prepareStatement("SELECT * FROM DELIVERYMAN");
                rs = prepare.executeQuery();
                while (rs.next()) {
                    list.addNewItem(new ModuleB.entity.Deliveryman(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private boolean connection() {
        boolean isSuccess = false;
        try {
            conn = java.sql.DriverManager.getConnection(dbURL);
            if (conn != null) {
                isSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
}
