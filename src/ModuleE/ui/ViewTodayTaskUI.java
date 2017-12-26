package ModuleE.ui;

import java.awt.*;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author chong kun ming RSD 3
 */

public class ViewTodayTaskUI extends JFrame {

    private JLabel jlblCurrentDate = new JLabel();
    private JLabel jlblCurrentTime = new JLabel();
    private java.text.SimpleDateFormat sdfDate = new java.text.SimpleDateFormat("dd/MM/yyyy");
    private java.text.SimpleDateFormat sdfTime = new java.text.SimpleDateFormat("hh:mm:ss aa");
    private java.text.SimpleDateFormat sdfDisplayTime = new java.text.SimpleDateFormat("hh:mm aa");
    private Font dateTimeFont = new Font("Arial", Font.BOLD, 25);
    private Font itemListingFont = new Font("Arial", Font.PLAIN, 20);
    private Font titleFont = new Font("Arial", Font.BOLD, 20);
    public ModuleE.entity.ListGetterSetter arrList = new ModuleE.entity.ListGetterSetter();
    private int custID = 0;
    private String dmName = "";
    
    public void setData(ModuleE.entity.ListGetterSetter list) {
        arrList = list;
    }
    
    public ViewTodayTaskUI(ModuleE.entity.ListGetterSetter arrClass, int dmID) {
        arrList = arrClass;
        
        for(int i = 0 ; i < arrList.getDmList().getSize(); i ++){
            if(dmID == arrList.getDmList().getAllData(i).getDmID()){
                dmName = arrList.getDmList().getAllData(i).getDmName();
            }
        }
        
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
                custID = arrList.getScOrderClass().getEntry(i).getCustID();
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
                jbtOrderedItems[i].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        new ViewOrderedItemUI().pageContent(Integer.parseInt(id.getText()), arrList.getScOrderItemList(), arrList.getItemlist());
                    }
                });
                
                jbtDeliveryDetails[i].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        new ViewDeliveryDetailsUI(Integer.parseInt(id.getText()), arrList, custID).setVisible(true);
                    }
                });
            }
        }
        
        jbtBack.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                DMMainMenuUI main = new DMMainMenuUI();
                main.setData(arrList, dmName);
                main.setVisible(true);
                ViewTodayTaskUI.this.setVisible(false);
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
        new Timer(0, new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Date d = new Date();
                jlblCurrentDate.setText(sdfDate.format(d));
                jlblCurrentTime.setText(sdfTime.format(d));
            }
        }).start();
    }
}
