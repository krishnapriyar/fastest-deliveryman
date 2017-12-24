package ModuleE.ui;

import ModuleE.entity.ScheduledOrderClass;
import ModuleE.adt.ListImplementation;
import ModuleE.adt.myListInterface;
import ModuleE.entity.ListClass;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class SOCheckTodayOrder extends JFrame {

    private JLabel jlblCurrentDate = new JLabel();
    private JLabel jlblCurrentTime = new JLabel();
    private SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss aa");
    private SimpleDateFormat sdfDisplayTime = new SimpleDateFormat("hh:mm aa");
    private Font dateTimeFont = new Font("Arial", Font.BOLD, 25);
    private Font itemListingFont = new Font("Arial", Font.PLAIN, 20);
    private Font titleFont = new Font("Arial", Font.BOLD, 20);
    public ListClass arrList = new ListClass();
    
    public void setData(ListClass list) {
        arrList = list;
    }
    
    public SOCheckTodayOrder(ListClass arrClass, int dmID) {
        arrList = arrClass;
        displayCurrentDateTime();
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        JPanel[] itemOrderedListing = new JPanel[arrList.getScOrderClass().size()];
        JPanel itemDetailListing = new JPanel(new GridLayout(arrList.getScOrderClass().size(), 2));
        JPanel jpnWrapItemListing = new JPanel();
        JScrollPane jsp = new JScrollPane(jpnWrapItemListing, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        JLabel[] jlblOrderIDTitle = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblReceiveTimeTitle = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblTotalPriceTitle = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblDistanceTitle = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblCustAddressTitle = new JLabel[arrList.getScOrderClass().size()];
        
        JLabel[] jlblOrderID = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblOrderAmount = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblDeliveryTime = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblDistance = new JLabel[arrList.getScOrderClass().size()];
        //JLabel[] jlblCustAddress = new JLabel[arrClass.getScOrderList().getSize()];

        JButton[] jbtOrderedItems = new JButton[arrList.getScOrderClass().size()];
        JButton[] jbtDeliveryDetails = new JButton[arrList.getScOrderClass().size()];
        JButton jbtBack = new JButton("Back");
        
        for (int i = 0; i < arrList.getScOrderClass().size(); i++) {
            if (dmID == arrList.getScOrderClass().getEntry(i).getDmID()) {
                jlblDistanceTitle[i] = new JLabel("Estimated distance :");
                jlblCustAddressTitle[i] = new JLabel("Recipient Address :");
                jlblOrderIDTitle[i] = new JLabel("Order ID :");
                jlblReceiveTimeTitle[i] = new JLabel("Time to receive order :");
                jlblTotalPriceTitle[i] = new JLabel("Total Order AMT :");
                
                jlblOrderID[i] = new JLabel(String.valueOf(arrList.getScOrderClass().getEntry(i).getOrderID()));
                jlblDeliveryTime[i] = new JLabel(sdfDisplayTime.format(arrList.getScOrderClass().getEntry(i).getReceiveTime()));
                jlblOrderAmount[i] = new JLabel("RM " + String.valueOf(arrList.getScOrderClass().getEntry(i).getTotalAmount()));
                jlblDistance[i] = new JLabel(String.valueOf(arrList.getScOrderClass().getEntry(i).getDistance()) + " KM");
                //jlblCustAddress[i] = new JLabel(list.getAllData(i).getCustAddress());

                jbtDeliveryDetails[i] = new JButton("Delivery Details");
                jbtOrderedItems[i] = new JButton("View Ordered Item(s)");
                
                jlblOrderID[i].setFont(itemListingFont);
                jlblDeliveryTime[i].setFont(itemListingFont);
                jlblOrderAmount[i].setFont(itemListingFont);
                jlblDistance[i].setFont(itemListingFont);
                //jlblCustAddress[i].setFont(itemListingFont);

                jlblOrderIDTitle[i].setFont(titleFont);
                jlblReceiveTimeTitle[i].setFont(titleFont);
                jlblTotalPriceTitle[i].setFont(titleFont);
                jlblDistanceTitle[i].setFont(titleFont);
                jlblCustAddressTitle[i].setFont(titleFont);
                
                jbtDeliveryDetails[i].setFont(itemListingFont);
                jbtOrderedItems[i].setFont(itemListingFont);
                
                itemOrderedListing[i] = new JPanel(new GridLayout(5, 2));

                itemOrderedListing[i].add(jlblOrderIDTitle[i]);
                itemOrderedListing[i].add(jlblOrderID[i]);

                itemOrderedListing[i].add(jlblReceiveTimeTitle[i]);
                itemOrderedListing[i].add(jlblDeliveryTime[i]);

                itemOrderedListing[i].add(jlblTotalPriceTitle[i]);
                itemOrderedListing[i].add(jlblOrderAmount[i]);

                itemOrderedListing[i].add(jlblDistanceTitle[i]);
                itemOrderedListing[i].add(jlblDistance[i]);

                itemOrderedListing[i].add(jbtDeliveryDetails[i]);
                
                itemOrderedListing[i].add(jbtOrderedItems[i]);
                itemDetailListing.add(itemOrderedListing[i]);
                jpnWrapItemListing.add(itemDetailListing);
                
                JLabel id = jlblOrderID[i];
                jbtOrderedItems[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new ViewItemOrdered().pageContent(Integer.parseInt(id.getText()), arrList.getScOrderItemList(), arrList.getItemlist());
                    }
                });
                
                jbtDeliveryDetails[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new DeliveryDetails(Integer.parseInt(id.getText()), arrList).setVisible(true);
                    }
                });
            }
        }
        
        jbtBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
//                DMMainMenu main = new DMMainMenu();
//                main.setListClass(arrList);
                SOCheckTodayOrder.this.setVisible(false);
            }
        });
        
        jlblCurrentDate.setFont(dateTimeFont);
        jlblCurrentTime.setFont(dateTimeFont);
        jlblCurrentDate.setHorizontalAlignment(SwingConstants.LEFT);
        jlblCurrentTime.setHorizontalAlignment(SwingConstants.RIGHT);
        
        topPanel.add(jlblCurrentDate);
        topPanel.add(jlblCurrentTime);
        
        add(topPanel, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
        add(jbtBack, BorderLayout.SOUTH);
        
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Check today's ordered");
        
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
}
