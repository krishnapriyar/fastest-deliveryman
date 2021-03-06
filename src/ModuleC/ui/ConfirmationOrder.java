package ModuleC.ui;

import ModuleC.adt.LinkedQueue;
import ModuleC.adt.QueueInterface;
import ModuleE.entity.Customer;
import ModuleE.entity.PostalCodeClass;
import ModuleE.adt.ListImplementation;
import ModuleE.adt.myListInterface;
import ModuleC.entity.ADTList;
import ModuleC.entity.OrderClass;
import ModuleE.ui.CustomerMainMenuUI;
import java.awt.BorderLayout;
import java.awt.Color;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import org.jdesktop.swingx.JXDatePicker;

public class ConfirmationOrder extends JFrame {

    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static Connection conn = null;
    private static PreparedStatement prepare;
    private static ResultSet rs = null;
    private JLabel jlblTitle = new JLabel("Customer and order Details");
    private JLabel jlblCustName = new JLabel("Customer Name");
    private JLabel jlblCustPhone = new JLabel("Phone Number");
    private JLabel jlblCustAddress = new JLabel("Delivery Address");
    private JLabel jlblCustName1 = new JLabel();
    private JLabel jlblCustPhone1 = new JLabel();
    private JLabel jlblCustAddress1 = new JLabel();
    private JLabel jlblTotalAmount = new JLabel("Total Amount (RM)");
    private JLabel jlblShowTotalAmount = new JLabel();
    private JLabel jlblDeliveryDate = new JLabel("Delivery Date");
    private JLabel jlblDeliveryTime = new JLabel("Delivery Time");
    private JLabel jlblCurrentDate = new JLabel();
    private JLabel jlblCurrentTime = new JLabel();
    private JXDatePicker datePicker = new JXDatePicker();
    private JComboBox jcbDeliveryTime = new JComboBox();
    private Font font = new Font("Arial", Font.BOLD, 18);
    private Font itemListFont = new Font("Arial", Font.PLAIN, 20);
    private Font dateTimeFont = new Font("Arial", Font.PLAIN, 22);
    private SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss aa");
    private SimpleDateFormat sdfTime2 = new SimpleDateFormat("hh:mm aa");
    private myListInterface<String> cityList = new ListImplementation<>();
    public myListInterface<Customer> custList = new ListImplementation<Customer>();
    private DecimalFormat decimalFormat = new DecimalFormat("#00");
    private ADTList arrList = new ADTList();
    private int cusID = 0;
    private String address = "";
    private static QueueInterface<OrderClass> orderList = new LinkedQueue<>(); 
    private static CustomerMainMenuUI cust = new CustomerMainMenuUI();
    public ConfirmationOrder() {

    }
    
    public static void setQueue(){
        orderList = cust.getQueue();
    }
    
    public QueueInterface<OrderClass> getQueue(){
        return orderList;
    }

    public void orderDetails(ADTList arrClass, String username, int custID) {


        displayCurrentDateTime();
        arrList = arrClass;
        
        
        JPanel wrapItemList = new JPanel();
        JPanel wrapCenterPanel = new JPanel();
        JPanel centerPanel1 = new JPanel(new GridLayout(1, 1));
        JPanel centerPanel = new JPanel(new GridLayout(7, 2));
        JPanel southPanel = new JPanel();
        JPanel[] itemOrderedListing = new JPanel[arrList.getItemlist().getSize()];
        JPanel itemDetailListing = new JPanel(new GridLayout(arrList.getItemlist().getSize(), 4));
        JScrollPane jsp = new JScrollPane(wrapItemList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JButton jbtOK = new JButton("OK");
        JTextArea jtextOrder = new JTextArea();

        jlblTitle.setFont(font);
        centerPanel1.add(jcbDeliveryTime);
         jlblCustName1.setText(username);
        jlblCustName1.setFont(font);
        
      
        jlblTotalAmount.setFont(font);
        jlblShowTotalAmount.setFont(font);
        jlblDeliveryDate.setFont(font);
        jlblDeliveryTime.setFont(font);
        datePicker.setFont(font);
        jlblDeliveryTime.setFont(font);
        jcbDeliveryTime.setFont(font);
        
        for(int i=0 ; i< arrClass.getCustList().getSize(); i++){
            if(arrClass.getCustList().getAllData(i).getCusID() == cusID){
                jlblCustName1.setText(arrClass.getCustList().getAllData(i).getCusName());
                jlblCustPhone1.setText(arrClass.getCustList().getAllData(i).getCusTelNo());
                jlblCustAddress1.setText(arrClass.getCustList().getAllData(i).getCusAddress());
                address = arrClass.getCustList().getAllData(i).getCusAddress();
            }
        }

        jlblCurrentDate.setForeground(Color.BLUE);
        jlblCurrentTime.setForeground(Color.BLUE);

        jlblCurrentDate.setFont(dateTimeFont);
        jlblCurrentTime.setFont(dateTimeFont);

        centerPanel.add(jlblCurrentDate);
        centerPanel.add(jlblCurrentTime);
        centerPanel.add(jlblCustName);
        centerPanel.add(jlblCustName1);
        centerPanel.add(jlblTotalAmount);
        centerPanel.add(jlblShowTotalAmount);

        wrapCenterPanel.add(centerPanel);

        String str = "";
        double totalAmount = 0.0;
        for (int i = 0; i < arrList.getItemlist().getSize(); i++) {
            str += String.format("%-40s  %-3s  %-6s", arrList.getItemlist().getAllData(i).getItemName(), arrList.getItemlist().getAllData(i).getQty(), arrList.getItemlist().getAllData(i).getTotalPrice()) + "\n";
            totalAmount += arrList.getItemlist().getAllData(i).getTotalPrice();
        }

        JLabel[] jlblItemID = new JLabel[arrList.getItemlist().getSize()];
        JLabel[] jlblItemName = new JLabel[arrList.getItemlist().getSize()];
        JLabel[] jlblItemQty = new JLabel[arrList.getItemlist().getSize()];
        JLabel[] jlblItemTotalPrice = new JLabel[arrList.getItemlist().getSize()];

        for (int i = 0; i < arrList.getItemlist().getSize(); i++) {
            jlblItemID[i] = new JLabel(String.valueOf(arrList.getItemlist().getAllData(i).getId()));
            jlblItemName[i] = new JLabel(arrList.getItemlist().getAllData(i).getItemName());
            jlblItemQty[i] = new JLabel(String.valueOf(arrList.getItemlist().getAllData(i).getQty()));
            jlblItemTotalPrice[i] = new JLabel(String.valueOf(arrList.getItemlist().getAllData(i).getTotalPrice()));

            jlblItemID[i].setFont(itemListFont);
            jlblItemName[i].setFont(itemListFont);
            jlblItemQty[i].setFont(itemListFont);
            jlblItemTotalPrice[i].setFont(itemListFont);

            jlblItemQty[i].setHorizontalAlignment(SwingConstants.CENTER);
            jlblItemTotalPrice[i].setHorizontalAlignment(SwingConstants.CENTER);

            itemOrderedListing[i] = new JPanel(new GridLayout(1, arrList.getItemlist().getSize()));
            itemOrderedListing[i].add(jlblItemID[i]);
            itemOrderedListing[i].add(jlblItemName[i]);
            itemOrderedListing[i].add(jlblItemQty[i]);
            itemOrderedListing[i].add(jlblItemTotalPrice[i]);
            itemDetailListing.add(itemOrderedListing[i]);
            wrapItemList.add(itemDetailListing);
        }

        jlblShowTotalAmount.setText(String.valueOf(totalAmount));
        jtextOrder.setText(str);
        jtextOrder.setEditable(false);
        jtextOrder.setLineWrap(true);
        jtextOrder.setWrapStyleWord(true);
        jtextOrder.setFont(font);


        southPanel.add(jsp).setPreferredSize(new Dimension(950, 350));
        jbtOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Date d = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
                
                String currentDate = dateFormat.format(d);
                String currentTime = timeFormat.format(d);
               
                try{
                   orderList.enqueue(new OrderClass(orderList.getSize(), dateFormat.parse(currentDate), timeFormat.parse(currentTime), Double.parseDouble(jlblShowTotalAmount.getText()), custID));
                }catch(ParseException en){
                    en.printStackTrace();
                }
              
                
               cust.setQueue(orderList);
               new CustomerMainMenuUI(cust.arrList, username);
               System.out.print(orderList.getSize());
               ConfirmationOrder.this.setVisible(false);
            }
        });
        
        add(wrapCenterPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.CENTER);
        add(jbtOK, BorderLayout.SOUTH);

        setSize(1000, 650);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Order Confirmation");
    }

    
    private void displayCurrentDateTime() {
        new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                jlblCurrentDate.setText(sdfDate.format(d));
                jlblCurrentTime.setText(sdfTime.format(d));
            }
        }).start();
    }

    private int getDistance(String custAddress) {
        int totalDistance = 0;
        myListInterface<PostalCodeClass> postCodeList = new ListImplementation<PostalCodeClass>();
        double custLatitude = 0.0, custLongitude = 0.0, myLat = 3.1433, myLong = 101.6955;
        if (connection() == true) {
            try {

                prepare = conn.prepareStatement("SELECT * FROM POSTALCODES");
                rs = prepare.executeQuery();

                while (rs.next()) {
                    postCodeList.addNewItem(new PostalCodeClass(rs.getString("POSTALCODE"), rs.getString("CITY"), rs.getString("STATE"), rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE")));
                }

                for (int i = 0; i < postCodeList.getSize(); i++) {
                    if (custAddress.contains(postCodeList.getAllData(i).getPostalCode())) {
                        custLatitude = postCodeList.getAllData(i).getLatitude();
                        custLongitude = postCodeList.getAllData(i).getLongitude();
                    }
                }
                totalDistance = Integer.parseInt(decimalFormat.format(distance(myLat, myLong, custLatitude, custLongitude)));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return totalDistance;

    }

    private static double distance(double lat1, double long1, double lat2, double long2) {
        double theta = long1 - long2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;

        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
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
