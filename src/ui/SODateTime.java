package ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

public class SODateTime extends JFrame {

    private JXDatePicker datePicker = new JXDatePicker();
    private JComboBox hour = new JComboBox();
    private JComboBox minutes = new JComboBox();
    private JComboBox ampm = new JComboBox();
    private JButton jbtProceed = new JButton("Proceed");
    private JPanel jpnMain = new JPanel(new GridLayout(3, 1));
    private JPanel centerPanel = new JPanel(new GridLayout(2, 2));
    private JPanel timePanel = new JPanel(new GridLayout(1, 3));
    private JPanel centerPanel1 = new JPanel();
    private SimpleDateFormat sdf1, sdf2;

    //jlabel declaration
    private JLabel jlblDate = new JLabel("Delivery Date");
    private JLabel jlblTime = new JLabel("Delivery Time");

    public SODateTime() {
        initializeComponent();

        timePanel.add(hour);
        timePanel.add(minutes);
        timePanel.add(ampm);

        centerPanel.add(jlblDate);
        centerPanel.add(datePicker);
        centerPanel.add(jlblTime).setPreferredSize(new Dimension(550, 90));
        centerPanel.add(timePanel).setPreferredSize(new Dimension(550, 90));
        centerPanel1.add(centerPanel).setPreferredSize(new Dimension(550, 90));
        jpnMain.add(new JLabel("Select Date and Time to receive your order"));
        jpnMain.add(centerPanel1);
        jpnMain.add(jbtProceed);
        add(jpnMain);

        jbtProceed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validation() == true) {
                    try {
                        String timeStr = hour.getSelectedItem().toString() + ":" + minutes.getSelectedItem().toString() +" "+ampm.getSelectedItem().toString();
                        sdf1 = new SimpleDateFormat("hh:mm aa");
                        sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                        
                        Date d = sdf1.parse(timeStr);
                       
                        SOfirst so = new SOfirst();
                        so.placeOrder(sdf2.format(datePicker.getDate()), sdf1.format(d));
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
    }

    boolean validation() {
        boolean pass = false;
        if (!datePicker.getDate().toString().equals("")
                && !hour.getSelectedItem().toString().equalsIgnoreCase("-- Select --")
                && !minutes.getSelectedItem().toString().equals("-- Select --")
                && !ampm.getSelectedItem().toString().equals("-- Select --")) {
            pass = true;
        }

        return pass;
    }

    void initializeComponent() {
        minutes.addItem("-- Select --");
        hour.addItem("-- Select --");
        ampm.addItem("-- Select --");
        datePicker.setDate(new Date());
        datePicker.setFormats("dd/MM/yyyy");
        for (int i = 0; i < 59; i++) {
            if ((i % 30) == 0) {
                minutes.addItem(i);
            }
        }

        for (int i = 1; i < 10; i++) {
            hour.addItem(i);
        }

        ampm.addItem("PM");
    }

    public static void main(String[] args) {
        SODateTime s = new SODateTime();
    }
}
