package ModuleE.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author chong kun ming RSD 3
 */
public class ViewDeliveryDetailsUI extends JFrame {

    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static java.sql.Connection conn = null;
    private static java.sql.PreparedStatement prepare;
    private static java.sql.ResultSet rs = null;
    private ModuleE.entity.ListGetterSetter arrClass = new ModuleE.entity.ListGetterSetter();
    private java.awt.Font mainFont = new java.awt.Font("Arial", java.awt.Font.BOLD, 28);
    private java.awt.Font titleFont = new java.awt.Font("Arial", java.awt.Font.BOLD, 19);
    private java.awt.Font displayFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 19);
    private java.text.SimpleDateFormat sdfTime = new java.text.SimpleDateFormat("hh:mm aa");

    private JLabel jlblCustTel = new JLabel();
    private JLabel jlblCustName = new JLabel();
    private JLabel jlblCustAddress = new JLabel();
    private JLabel jlblTimeToDeliver = new JLabel();
    private JLabel jlblED = new JLabel();
    private JLabel jlblETA = new JLabel();
    private JLabel jlblDesc  = new JLabel();
    private java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.00");

    public ViewDeliveryDetailsUI() {

    }

    public ViewDeliveryDetailsUI(int orderID, ModuleE.entity.ListGetterSetter arrList, int custID) {
        getDMInfo(custID);
        arrClass = arrList;
        JPanel jpn = new JPanel(new GridLayout(7, 2));
        JLabel jlblTitle = new JLabel("Delivery Details");
        jlblTitle.setFont(mainFont);
        JButton jbtOK = new JButton("OK");

        JLabel jlblCustNumberTitle = new JLabel("Tel No.");
        JLabel jlblCustNameTitle = new JLabel("Customer Name : ");
        JLabel jlblCustAddressTitle = new JLabel("Customer Address : ");
        JLabel jlblTimeToDeliverTitle = new JLabel("Time to receive");
        JLabel jlblEDTitle = new JLabel("Estimated Distance : ");
        JLabel jlblETATitle = new JLabel("ETA : ");
        JLabel jlblDescTitle = new JLabel("Description");

        jlblCustNumberTitle.setFont(titleFont);
        jlblCustNameTitle.setFont(titleFont);
        jlblCustAddressTitle.setFont(titleFont);
        jlblTimeToDeliverTitle.setFont(titleFont);
        jlblEDTitle.setFont(titleFont);
        jlblETATitle.setFont(titleFont);
        jlblDescTitle.setFont(titleFont);

        jlblCustTel.setFont(displayFont);
        jlblCustName.setFont(displayFont);
        jlblCustAddress.setFont(displayFont);
        jlblTimeToDeliver.setFont(displayFont);
        jlblED.setFont(displayFont);
        jlblETA.setFont(displayFont);
        jlblDesc.setFont(displayFont);

        double distance = 0;
        java.util.Calendar cal = java.util.Calendar.getInstance();
        for (int i = 0; i < arrList.getScOrderClass().size(); i++) {
            if (orderID == arrList.getScOrderClass().getEntry(i).getOrderID()) {
                distance = Math.round(arrList.getScOrderClass().getEntry(i).getDistance());
                jlblED.setText(String.valueOf(arrList.getScOrderClass().getEntry(i).getDistance()) + " KM");
                jlblTimeToDeliver.setText(sdfTime.format(arrList.getScOrderClass().getEntry(i).getReceiveTime()));
                cal.setTime(arrList.getScOrderClass().getEntry(i).getReceiveTime());
            }
        }
        double timeToDeliver = (distance / 40);
        cal.add(java.util.Calendar.MINUTE, 0 - Integer.parseInt(String.valueOf(Math.round(timeToDeliver))));
        
        String eta, desc;
        if(Math.round(timeToDeliver) <= 0){
            eta = "-";
            desc = "-";
        }else{
            eta = Math.round(timeToDeliver) + " Minutes";
            desc = "Estimated time to deliver the order "+ new java.text.SimpleDateFormat("hh:mm aa").format(cal.getTime());
        }
        
        jlblETA.setText(eta);
        jlblDesc.setText(desc);

        for (int i = 0; i < arrList.getCustList().getSize(); i++) {
            if (custID == arrList.getCustList().getAllData(i).getCustID()) {
                jlblCustTel.setText(arrList.getCustList().getAllData(i).getCustTelNo());
                jlblCustName.setText(arrList.getCustList().getAllData(i).getCustName());
                jlblCustAddress.setText(arrList.getCustList().getAllData(i).getCustAddress());

            }
        }

        jbtOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ViewDeliveryDetailsUI.this.setVisible(false);
            }
        });

        jpn.add(jlblCustNumberTitle);
        jpn.add(jlblCustTel);

        jpn.add(jlblCustNameTitle);
        jpn.add(jlblCustName);

        jpn.add(jlblCustAddressTitle);
        jpn.add(jlblCustAddress);

        jpn.add(jlblTimeToDeliverTitle);
        jpn.add(jlblTimeToDeliver);

        jpn.add(jlblEDTitle);
        jpn.add(jlblED);

        jpn.add(jlblETATitle);
        jpn.add(jlblETA);

        jpn.add(jlblDescTitle);
        jpn.add(jlblDesc);

        JPanel jpnWrap = new JPanel();
        jpnWrap.add(jpn);

        add(jlblTitle, BorderLayout.NORTH);
        add(jpnWrap, BorderLayout.CENTER);
        add(jbtOK, BorderLayout.SOUTH);

        setSize(900, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Delivery Details");
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

    private void getDMInfo(int custID) {
        if (connection() == true) {
            try {
                arrClass.getCustList().clearList();
                prepare = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTID = " + custID);
                rs = prepare.executeQuery();

                if (rs.next()) {
                    jlblCustTel.setText(rs.getString("CUSTTELNO"));
                    jlblCustName.setText(rs.getString("CUSTNAME"));
                    jlblCustAddress.setText(rs.getString("CUSTADDRESS"));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

}
