package ModuleE.ui;

import ModuleE.entity.Customer;
import ModuleE.entity.OrderedItemClass;
import ModuleE.entity.ScheduledOrderClass;
import ModuleE.entity.ScheduledOrderItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import org.jdesktop.swingx.JXDatePicker;
import ModuleE.adt.ListImplementation;
import ModuleE.adt.myListInterface;
import ModuleE.entity.ListClass;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.SwingUtilities;

/**
 *
 * @author chong
 */
public class SOViewOrderedItem extends JFrame {

    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static Connection conn = null;
    private static PreparedStatement prepare;
    private static ResultSet rs = null;
    private double totalAmount = 0.0;
    private Font font = new Font("Arial", Font.BOLD, 18);
    private JLabel jlblShowCustName = new JLabel();
    private DecimalFormat decimalFormat = new DecimalFormat("#00");

    public void displayOrderedItem(ListClass arrClass, int custID, String receiveDate, String receiveTime, String userName) {
          
        for(int i = 0 ; i < arrClass.getCustList().getSize(); i ++){
            if(arrClass.getCustList().getAllData(i).getCustID() == custID){
                jlblShowCustName.setText(arrClass.getCustList().getAllData(i).getCustName());
            } 
        }
        
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        JPanel[] itemOrderedListing = new JPanel[arrClass.getItemlist().getSize()];
        JPanel itemDetailListing = new JPanel(new GridLayout(arrClass.getItemlist().getSize(), 6));
        JPanel southPanel = new JPanel(new GridLayout(1, 2));
        JPanel itemPanel = new JPanel();
        JPanel topPanel = new JPanel(new GridLayout(3, 2));
        JPanel jpnSouth = new JPanel(new GridLayout(1, 2));

        JScrollPane jsp2 = new JScrollPane(itemPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JLabel jlblTitle = new JLabel("Order Details");
        JLabel jlblTotalPrice = new JLabel();
        JLabel jlblTotalItem = new JLabel();
        JLabel jlblReceiveDate = new JLabel("Receive Date");
        JLabel jlblReceiveTime = new JLabel("Receive Time");
        JLabel jlblShowReceiveDate = new JLabel();
        JLabel jlblShowReceiveTime = new JLabel();
        JLabel jlblCustomerName = new JLabel("Customer Name");

        jlblShowCustName.setFont(font);
        jlblCustomerName.setFont(font);
        jlblReceiveDate.setFont(font);
        jlblReceiveTime.setFont(font);
        jlblShowReceiveDate.setFont(font);
        jlblShowReceiveTime.setFont(font);

        jlblShowReceiveDate.setText(receiveDate);
        jlblShowReceiveTime.setText(receiveTime);

        jlblTitle.setFont(font);

        JButton jbtConfirm = new JButton("Confirm");
        JButton jbtBack = new JButton("Back");

        JLabel[] jlblItemID = new JLabel[arrClass.getItemlist().getSize()];
        JLabel[] jlblItemName = new JLabel[arrClass.getItemlist().getSize()];
        JLabel[] jlblItemPricePerItem = new JLabel[arrClass.getItemlist().getSize()];
        JLabel[] jlbltotalPrice = new JLabel[arrClass.getItemlist().getSize()];
        JButton[] jbtRemove = new JButton[arrClass.getItemlist().getSize()];
        JSpinner[] qty = new JSpinner[arrClass.getItemlist().getSize()];

        for (int i = 0; i < arrClass.getItemlist().getSize(); i++) {
            jlblItemID[i] = new JLabel(String.valueOf(arrClass.getItemlist().getAllData(i).getId()));
            jlblItemName[i] = new JLabel(arrClass.getItemlist().getAllData(i).getItemName());
            jlblItemPricePerItem[i] = new JLabel(String.valueOf(arrClass.getItemlist().getAllData(i).getItemPrice()));

            qty[i] = new JSpinner();
            jlbltotalPrice[i] = new JLabel("Total");
            jbtRemove[i] = new JButton("Remove Item");
            qty[i].setValue(1);
            qty[i].setEditor(new JSpinner.DefaultEditor(qty[i]));

            jlblItemName[i].setFont(font);
            jlblItemPricePerItem[i].setFont(font);
            jlbltotalPrice[i].setFont(font);

            jlblItemPricePerItem[i].setHorizontalAlignment(SwingConstants.CENTER);
            jlbltotalPrice[i].setHorizontalAlignment(SwingConstants.CENTER);

            itemOrderedListing[i] = new JPanel(new GridLayout(1, arrClass.getItemlist().getSize()));
            itemOrderedListing[i].add(jlblItemID[i]);
            itemOrderedListing[i].add(jlblItemName[i]);
            itemOrderedListing[i].add(jlblItemPricePerItem[i]);
            itemOrderedListing[i].add(qty[i]);
            itemOrderedListing[i].add(jlbltotalPrice[i]);
            itemOrderedListing[i].add(jbtRemove[i]);
            itemDetailListing.add(itemOrderedListing[i]);
            itemPanel.add(itemDetailListing);

            final JLabel itemPrice = jlblItemPricePerItem[i];
            final JSpinner itemQty = qty[i];
            final JLabel itemTotalPrice = jlbltotalPrice[i];
            itemTotalPrice.setText(String.valueOf(totalPrice(Integer.parseInt(itemQty.getValue().toString()), Double.parseDouble(itemPrice.getText()))));

            totalAmount += Double.parseDouble(itemTotalPrice.getText());
            jlblTotalItem.setText("Total item(s) ordered : " + String.valueOf(arrClass.getItemlist().getSize()));
            jlblTotalPrice.setText("Total Amount : RM " + String.valueOf(totalAmount));

            qty[i].addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (Integer.parseInt(itemQty.getValue().toString()) <= 0) {
                        JOptionPane.showMessageDialog(null, "Quantity must be greater than 0 !");
                        itemQty.setValue(1);
                    } else {
                        itemTotalPrice.setText(String.valueOf(totalPrice(Integer.parseInt(itemQty.getValue().toString()), Double.parseDouble(itemPrice.getText()))));
                        jlblTotalPrice.setText("Total Amount : RM " + String.valueOf(Math.round(getTotalAmount(Double.parseDouble(itemPrice.getText())) * 100) /100));
                    }
                }
            });

            String action = String.valueOf(i);
            jbtRemove[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    arrClass.getItemlist().removeItem(Integer.parseInt(action) + 1);
                    SOViewOrderedItem s = new SOViewOrderedItem();
                    s.displayOrderedItem(arrClass, custID, receiveDate, receiveTime, userName);
                    SOViewOrderedItem.this.setVisible(false);
                }
            });
        }
        jlblTotalItem.setFont(font);
        jlblTotalPrice.setFont(font);

        southPanel.add(jlblTotalItem);
        southPanel.add(jlblTotalPrice);

        jbtConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myListInterface<OrderedItemClass> oList = new ListImplementation<>();
                for (int i = 0; i < arrClass.getItemlist().getSize(); i++) {
                    int itemID = Integer.parseInt(jlblItemID[i].getText());
                    String itemName = jlblItemName[i].getText();
                    Double itemPrice = Double.parseDouble(jlblItemPricePerItem[i].getText());
                    Double totalAmount = Double.parseDouble(jlbltotalPrice[i].getText());
                    int quantity = Integer.parseInt(qty[i].getValue().toString());

                    oList.addNewItem(new OrderedItemClass(itemID, itemName, itemPrice, totalAmount, quantity));
                }
                arrClass.setItemlist(oList);
                SOOrderConfirmation sot = new SOOrderConfirmation();
                sot.orderDetails(arrClass, custID, receiveDate, receiveTime, userName);
                SOViewOrderedItem.this.setVisible(false);
            }
        });

        jbtBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SOMakeScheduledOrder().orderPage(arrClass, custID, receiveDate, receiveTime, userName);
                setVisible(true);
                SOViewOrderedItem.this.dispose();
            }
        });

        JPanel topPanel1 = new JPanel();
        topPanel.add(jlblCustomerName).setPreferredSize(new Dimension(200, 50));
        topPanel.add(jlblShowCustName).setPreferredSize(new Dimension(200, 50));
        topPanel.add(jlblReceiveDate).setPreferredSize(new Dimension(200, 50));
        topPanel.add(jlblShowReceiveDate).setPreferredSize(new Dimension(200, 50));
        topPanel.add(jlblReceiveTime).setPreferredSize(new Dimension(200, 50));
        topPanel.add(jlblShowReceiveTime).setPreferredSize(new Dimension(200, 50));
        topPanel1.add(topPanel);

        mainPanel.add(topPanel1, BorderLayout.NORTH);
        mainPanel.add(jsp2, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        jpnSouth.add(jbtBack);
        jpnSouth.add(jbtConfirm);
        add(jlblTitle, BorderLayout.NORTH);
        add(jpnSouth, BorderLayout.SOUTH);
        add(mainPanel);

        setTitle("View Ordered Item(s)");
        setSize(1200, 650);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private double getTotalAmount(double tPrice) {

        return totalAmount += tPrice;
    }

    private double totalPrice(int qty, double itemPrice) {
        return qty * itemPrice;
    }
}
