package ModuleE.ui;

import ModuleE.entity.ListGetterSetter;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;

import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author chong kun ming RSD 3
 */

public class SelectDateTimeUI extends JFrame {
    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static Connection conn = null;
    private static PreparedStatement prepare;
    private static ResultSet rs = null;
    private JXDatePicker datePicker = new JXDatePicker();
    private JComboBox jcbHour = new JComboBox();
    private JButton jbtProceed = new JButton("Proceed");
    private JPanel pnlMain = new JPanel(new GridLayout(3, 1));
    private JPanel pnlCenter = new JPanel(new GridLayout(2, 2));
    private JPanel pnlTime = new JPanel(new GridLayout(1, 1));
    private JPanel pnlCenter1 = new JPanel();
    private JPanel pnlCustName = new JPanel();
    private JPanel pnlTop1 = new JPanel(new GridLayout(2, 1));
    private SimpleDateFormat sdf1, sdf2;
    private Font font = new Font("Arial", Font.BOLD, 25);
    private Font font1 = new Font("Arial", Font.BOLD, 28);
    private Font fontDisplay = new Font("Arial", Font.PLAIN, 26);
    private DecimalFormat decimalFormat = new DecimalFormat("#00");
    //jlabel declaration
    private JLabel jlblDate = new JLabel("Delivery Date");
    private JLabel jlblTime = new JLabel("Delivery Time");
    private JLabel jlblTitle = new JLabel("Select date and time to receive your order(s)");
    private JLabel jlblCurrentDate = new JLabel();
    private JLabel jlblCurrentTime = new JLabel();
    private JLabel jlblCustomerName = new JLabel();
    public SelectDateTimeUI() {

    }

    public void makeScheduleOrder(ListGetterSetter arrClass, int custID, String userName) {
        displayCurrentDateTime();
        initializeComponent();
        jlblCurrentDate.setFont(font1);
        jlblCurrentTime.setFont(font1);
        jlblCustomerName.setFont(font1);
        jlblCustomerName.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        for(int i = 0; i < arrClass.getCustList().getSize(); i++){
            if(arrClass.getCustList().getAllData(i).getCustID() == custID){
                jlblCustomerName.setText(arrClass.getCustList().getAllData(i).getCustName());
            }           
        }
         
        pnlTime.add(jcbHour);
        
        jlblTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
        jlblTitle.setFont(font);
        pnlTop1.setLayout(new FlowLayout(FlowLayout.CENTER));

        jlblDate.setFont(fontDisplay);
        jlblTime.setFont(fontDisplay);
        datePicker.setFont(fontDisplay);
        jlblTime.setFont(fontDisplay);
        pnlCenter.setFont(fontDisplay);
        jcbHour.setFont(fontDisplay);
        jbtProceed.setFont(fontDisplay);
        
        pnlTop1.add(jlblCurrentDate);
        pnlTop1.add(jlblCurrentTime);
        pnlCenter.add(jlblDate);
        pnlCenter.add(datePicker);
        pnlCenter.add(jlblTime).setPreferredSize(new Dimension(550, 90));
        pnlCenter.add(pnlTime).setPreferredSize(new Dimension(550, 90));
        pnlCenter1.add(pnlCenter).setPreferredSize(new Dimension(550, 90));

        pnlCustName.add(jlblCustomerName);
        pnlMain.add(pnlCustName);
        pnlMain.add(pnlTop1);
        pnlMain.add(pnlCenter1);
        add(pnlMain, BorderLayout.CENTER);
        add(jlblTitle, BorderLayout.NORTH);
        add(jbtProceed, BorderLayout.SOUTH);

        jbtProceed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validation() == true) {
                    try {
                        String timeStr = jcbHour.getSelectedItem().toString();
                        sdf1 = new SimpleDateFormat("hh:mm aa");
                        sdf2 = new SimpleDateFormat("dd/MM/yyyy");

                        Date receiveTime = sdf1.parse(timeStr);
                        Date currentTime = sdf1.parse(jlblCurrentTime.getText().toString());
                        Date receiveDate = datePicker.getDate();
                        Date currentDate = sdf2.parse(jlblCurrentDate.getText());

                        if (receiveTime.before(currentTime) && receiveDate.equals(currentDate)) {
                            JOptionPane.showMessageDialog(null, "Check your receive time before proceed !");
                        } else if (!receiveDate.before(currentDate)) {
                            String deliverDate = sdf2.format(receiveDate);
                            String deliverTime = sdf1.format(receiveTime);
                            
                            MakeNewOrderUI so = new MakeNewOrderUI();
                            so.orderPage(arrClass, custID, deliverDate, deliverTime, userName);
                            SelectDateTimeUI.this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Receive date cannot before today's date");
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter your all necessary details before proceed !");
                }
            }
        });

        setVisible(true);
        setSize(900, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void displayCurrentDateTime() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    for (;;) {
                        Calendar calendar = new GregorianCalendar();
                        int day = calendar.get(Calendar.DAY_OF_MONTH);
                        int month = calendar.get(Calendar.MONTH) + 1;
                        int year = calendar.get(Calendar.YEAR);
                        int ampm = calendar.get(Calendar.AM_PM);

                        String day_night = "";
                        if (ampm == 0) {
                            day_night = "AM";
                        } else {
                            day_night = "PM";
                        }

                        int second = calendar.get(Calendar.SECOND);
                        int minutes = calendar.get(Calendar.MINUTE);
                        int hour = calendar.get(Calendar.HOUR);
                        
                        jlblCurrentDate.setText(day + "/" + month + "/" + year);
                        jlblCurrentTime.setText(hour + ":" + decimalFormat.format(minutes) + " " + day_night);

                        sleep(1000);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        clock.start();
    }
   
    private boolean validation() {
        boolean pass = false;
        if (!datePicker.getDate().toString().equals("")
                && !jcbHour.getSelectedItem().toString().equalsIgnoreCase("-- Select --")) {
            pass = true;
        }
        return pass;
    }

    private void initializeComponent() {
        jcbHour.addItem("-- Select --");
        datePicker.setDate(new Date());
        datePicker.getEditor().setEditable(false);

        datePicker.setFormats("dd/MM/yyyy");

        for (int hour = 1; hour < 10; hour++) {
            for (int minutes = 0; minutes < 31; minutes++) {
                if (minutes % 30 == 0) {
                    jcbHour.addItem(decimalFormat.format(hour) + ":" + decimalFormat.format(minutes) + " PM");
                    //jcbHour.addItem(hour + ":" + minutes + " " + "PM");
                }
            }
        }

    }
}
