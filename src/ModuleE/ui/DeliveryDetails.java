package ModuleE.ui;

import ModuleB.entity.Deliveryman;
import ModuleE.entity.ListClass;
import static ModuleE.ui.DMMainMenu.arrClass;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author chong kun ming
 */
public class DeliveryDetails extends JFrame {

    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static Connection conn = null;
    private static PreparedStatement prepare;
    private static ResultSet rs = null;
    private ListClass arrClass = new ListClass();
    private Font mainFont = new Font("Arial", Font.BOLD, 28);
    private Font titleFont = new Font("Arial", Font.BOLD, 19);
    private Font displayFont = new Font("Arial", Font.PLAIN, 19);
    private SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm aa");

    private JLabel jlblCustTel = new JLabel();
    private JLabel jlblCustName = new JLabel();
    private JLabel jlblCustAddress = new JLabel();
    private JLabel jlblTimeToDeliver = new JLabel();
    private JLabel jlblED = new JLabel();
    private JLabel jlblETA = new JLabel();
    private JLabel jlblDesc  = new JLabel();
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public DeliveryDetails() {

    }

    public DeliveryDetails(int orderID, ListClass arrList, int custID) {
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
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < arrList.getScOrderClass().size(); i++) {
            if (orderID == arrList.getScOrderClass().getEntry(i).getOrderID()) {
                distance = Math.round(arrList.getScOrderClass().getEntry(i).getDistance());
                jlblED.setText(String.valueOf(arrList.getScOrderClass().getEntry(i).getDistance()) + " KM");
                jlblTimeToDeliver.setText(sdfTime.format(arrList.getScOrderClass().getEntry(i).getReceiveTime()));
                cal.setTime(arrList.getScOrderClass().getEntry(i).getReceiveTime());
            }
        }
        double timeToDeliver = (distance / 40);
        cal.add(Calendar.MINUTE, 0 - Integer.parseInt(String.valueOf(Math.round(timeToDeliver))));
        
        String eta, desc;
        if(Math.round(timeToDeliver) <= 0){
            eta = "-";
            desc = "-";
        }else{
            eta = Math.round(timeToDeliver) + " Minutes";
            desc = "Estimated time to deliver the order "+ new SimpleDateFormat("hh:mm aa").format(cal.getTime());
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

        jbtOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeliveryDetails.this.setVisible(false);
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
            conn = DriverManager.getConnection(dbURL);
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
