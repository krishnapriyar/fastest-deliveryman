package ModuleE.ui;

import ModuleE.entity.ListGetterSetter;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author chong kun ming RSD 3
 */

public class ViewMyOrderUI extends JFrame {

    private JPanel jpnTop = new JPanel(new GridLayout(3, 2));
    private JLabel jlblCurrentDate = new JLabel();
    private JLabel jlblCurrentTime = new JLabel();
    private JLabel jlblCustName = new JLabel("Name");
    private JLabel jlblShowCustName = new JLabel();
    private JLabel jlblCustAddress = new JLabel("Address");
    private JLabel jlblShowCustAddress = new JLabel();

    private SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss aa");
    private SimpleDateFormat sdfDisplayTime = new SimpleDateFormat("hh:mm aa");

    private Font dateTimeFont = new Font("Arial", Font.PLAIN, 30);
    private Font font = new Font("Arial", Font.BOLD, 18);
    private Font itemFont = new Font("Arial", Font.PLAIN, 20);
    public ListGetterSetter arrClass = new ListGetterSetter();

    public ViewMyOrderUI() {

    }

    public void pageContent(ListGetterSetter arrList, int custID, String userName) {
        arrClass = arrList;
        displayCurrentDateTime();
        
        JPanel jpnWrap = new JPanel();
        JPanel[] itemOrderedListing = new JPanel[arrClass.getScOrderClass().size()];
        JPanel itemDetailListing = new JPanel(new GridLayout(arrClass.getScOrderClass().size(), 5));
        JScrollPane jsp = new JScrollPane(jpnWrap, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jlblCurrentDate.setFont(dateTimeFont);
        jlblCurrentTime.setFont(dateTimeFont);
        jlblCurrentDate.setHorizontalAlignment(SwingConstants.LEFT);
        jlblCurrentTime.setHorizontalAlignment(SwingConstants.RIGHT);

        jlblCustName.setHorizontalAlignment(SwingConstants.CENTER);
        jlblCustAddress.setHorizontalAlignment(SwingConstants.CENTER);

        jlblCustName.setFont(font);
        jlblShowCustName.setFont(font);
        jlblCustAddress.setFont(font);
        jlblShowCustAddress.setFont(font);
        
        for(int i = 0 ; i < arrList.getCustList().getSize(); i ++){
            if(custID == arrList.getCustList().getAllData(i).getCustID()){
                jlblShowCustName.setText(arrList.getCustList().getAllData(i).getCustName());
                jlblShowCustAddress.setText(arrList.getCustList().getAllData(i).getCustAddress());
            }
        }

        JLabel[] jlblOrderID = new JLabel[arrClass.getScOrderClass().size()];
        JLabel[] jlblScheduleDateTime = new JLabel[arrClass.getScOrderClass().size()];
        JLabel[] jlblTotalPrice = new JLabel[arrClass.getScOrderClass().size()];
        JLabel[] jlblStatus = new JLabel[arrClass.getScOrderClass().size()];
        JButton[] jbtViewOrderedItem = new JButton[arrClass.getScOrderClass().size()];
        JButton jbtOK = new JButton("Back to Menu");

        for (int i = 0; i < arrClass.getScOrderClass().size(); i++) {
            if (arrClass.getScOrderClass().getEntry(i).getCustID() == custID) {
                jlblOrderID[i] = new JLabel(String.valueOf(arrClass.getScOrderClass().getEntry(i).getOrderID()));
                jlblScheduleDateTime[i] = new JLabel(String.valueOf(sdfDate.format(arrClass.getScOrderClass().getEntry(i).getReceiveDate())) + "  " + sdfDisplayTime.format(arrClass.getScOrderClass().getEntry(i).getReceiveTime()));
                jlblTotalPrice[i] = new JLabel(String.valueOf("RM " + arrClass.getScOrderClass().getEntry(i).getTotalAmount()));
                jlblStatus[i] = new JLabel(arrClass.getScOrderClass().getEntry(i).getStatus());

                jbtViewOrderedItem[i] = new JButton("View Ordered Item(s)");

                jlblOrderID[i].setFont(font);
                jlblScheduleDateTime[i].setFont(font);
                jlblTotalPrice[i].setFont(font);
                jbtViewOrderedItem[i].setFont(font);
                jlblStatus[i].setFont(font);

                itemOrderedListing[i] = new JPanel(new GridLayout(1, arrClass.getScOrderClass().size()));
                itemOrderedListing[i].add(jlblOrderID[i]);
                itemOrderedListing[i].add(jlblScheduleDateTime[i]);
                itemOrderedListing[i].add(jlblTotalPrice[i]);
                itemOrderedListing[i].add(jlblStatus[i]);
                itemOrderedListing[i].add(jbtViewOrderedItem[i]);

                itemDetailListing.add(itemOrderedListing[i]);
                jpnWrap.add(itemDetailListing);
                final JLabel sc_orderID = jlblOrderID[i];
                jbtViewOrderedItem[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String schedule_orderID = sc_orderID.getText();
                        ViewOrderedItemUI view = new ViewOrderedItemUI();
                        view.pageContent(Integer.parseInt(schedule_orderID), arrClass.getScOrderItemList(), arrClass.getItemlist());
                    }
                });
            }

        }

        jbtOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CustomerMainMenuUI(arrClass, userName);
                ViewMyOrderUI.this.setVisible(false);
            }
        });

        jpnTop.add(jlblCurrentDate);
        jpnTop.add(jlblCurrentTime);
        jpnTop.add(jlblCustName);
        jpnTop.add(jlblShowCustName);
        jpnTop.add(jlblCustAddress);
        jpnTop.add(jlblShowCustAddress);

        add(jpnTop, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
        add(jbtOK, BorderLayout.SOUTH);

        setTitle("My Scheduled Order(s)");
        setSize(1200, 700);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
