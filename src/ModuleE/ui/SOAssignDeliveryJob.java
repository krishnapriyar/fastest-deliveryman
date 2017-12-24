package ModuleE.ui;

import ModuleE.entity.ListClass;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import ui.AdminMenu;

public class SOAssignDeliveryJob extends JFrame {

    private JLabel jlblTitle = new JLabel("Assign Job to delivery man");
    private Font fontTitle = new Font("Arial", Font.PLAIN, 28);
    private Font fontDisplay = new Font("Arial", Font.PLAIN, 23);
    private SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm aa");
    private ListClass arrList = new ListClass();
    private String username;
    
    public void setData(ListClass arrClass, String name){
        arrList = arrClass;
        jlblTitle.setFont(fontTitle);
        
        // jpanel declaration
        JPanel jpnWrap = new JPanel();
        JPanel[] itemOrderedListing = new JPanel[arrList.getScOrderClass().size()];
        JPanel itemDetailListing = new JPanel(new GridLayout(arrList.getScOrderClass().size(), 2));
        JScrollPane jsp = new JScrollPane(jpnWrap, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //jlabel declaration
        JLabel[] jlblOrderIDTitle = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblDeliveryTimeTitle = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblDistanceTitle = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblCustAddressTitle = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblTotalAMTTitle = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblAssignDM = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblDeliveryDateTitle = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblStatusTitle = new JLabel[arrList.getScOrderClass().size()];

        JLabel[] jlblOrderID = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblDeliveryTime = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblDistance = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblDeliveryDate = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblTotalAMT = new JLabel[arrList.getScOrderClass().size()];
        JLabel[] jlblStatus = new JLabel[arrList.getScOrderClass().size()];
        //controls declaration
        JButton[] jbtAssign = new JButton[arrList.getScOrderClass().size()];
        JButton[] jbtDecline = new JButton[arrList.getScOrderClass().size()];
        JComboBox[] jcbDM = new JComboBox[arrList.getScOrderClass().size()];
        JButton jbtBack = new JButton("Back");

        for (int i = 0; i < arrList.getScOrderClass().size(); i++) {
            if (arrList.getScOrderClass().getEntry(i).getStatus().equals("Pending...")) {
                itemOrderedListing[i] = new JPanel(new GridLayout(8, 2));
                jlblOrderIDTitle[i] = new JLabel("Order ID : ");
                jlblDeliveryTimeTitle[i] = new JLabel("Time to receive : ");
                jlblDistanceTitle[i] = new JLabel("Estimated Distance : ");
                jlblCustAddressTitle[i] = new JLabel("Recipient Address : ");
                jlblTotalAMTTitle[i] = new JLabel("Total order AMT : ");
                jlblAssignDM[i] = new JLabel("Select Delivery Man : ");
                jlblDeliveryDateTitle[i] = new JLabel("Date to Deliver : ");
                jlblStatusTitle[i] = new JLabel("Status : ");

                jlblOrderID[i] = new JLabel(String.valueOf(arrList.getScOrderClass().getEntry(i).getOrderID()));
                jlblDeliveryTime[i] = new JLabel(sdfTime.format(arrList.getScOrderClass().getEntry(i).getReceiveTime()));
                jlblDistance[i] = new JLabel(String.valueOf(arrList.getScOrderClass().getEntry(i).getDistance()) + " KM");
                jlblTotalAMT[i] = new JLabel(String.valueOf(arrList.getScOrderClass().getEntry(i).getTotalAmount()));
                jlblDeliveryDate[i] = new JLabel(sdfDate.format(arrList.getScOrderClass().getEntry(i).getReceiveDate()));
                jlblStatus[i] = new JLabel(arrList.getScOrderClass().getEntry(i).getStatus());
                jcbDM[i] = new JComboBox();
                jbtAssign[i] = new JButton("Accept");
                jbtDecline[i] = new JButton("Decline");

                for (int j = 0; j < arrList.getDmList().getSize(); j++) {
                    jcbDM[i].addItem(arrList.getDmList().getAllData(j).getDmName());
                }

                jlblOrderIDTitle[i].setFont(fontDisplay);
                jlblDeliveryDateTitle[i].setFont(fontDisplay);
                jlblDeliveryTimeTitle[i].setFont(fontDisplay);
                jlblDistanceTitle[i].setFont(fontDisplay);
                jlblCustAddressTitle[i].setFont(fontDisplay);
                jlblTotalAMTTitle[i].setFont(fontDisplay);
                jlblAssignDM[i].setFont(fontDisplay);
                jlblStatusTitle[i].setFont(fontDisplay);

                jlblOrderID[i].setFont(fontDisplay);
                jlblDeliveryDate[i].setFont(fontDisplay);
                jlblDeliveryTime[i].setFont(fontDisplay);
                jlblDistance[i].setFont(fontDisplay);
                jlblTotalAMT[i].setFont(fontDisplay);
                jcbDM[i].setFont(fontDisplay);
                jlblStatus[i].setFont(fontDisplay);

                jbtAssign[i].setFont(fontTitle);
                jbtDecline[i].setFont(fontTitle);

                itemOrderedListing[i].add(jlblOrderIDTitle[i]);
                itemOrderedListing[i].add(jlblOrderID[i]);

                itemOrderedListing[i].add(jlblDeliveryDateTitle[i]);
                itemOrderedListing[i].add(jlblDeliveryDate[i]);

                itemOrderedListing[i].add(jlblDeliveryTimeTitle[i]);
                itemOrderedListing[i].add(jlblDeliveryTime[i]);

                itemOrderedListing[i].add(jlblDistanceTitle[i]);
                itemOrderedListing[i].add(jlblDistance[i]);

                itemOrderedListing[i].add(jlblTotalAMTTitle[i]);
                itemOrderedListing[i].add(jlblTotalAMT[i]);

                itemOrderedListing[i].add(jlblStatusTitle[i]);
                itemOrderedListing[i].add(jlblStatus[i]);

                itemOrderedListing[i].add(jlblAssignDM[i]);
                itemOrderedListing[i].add(jcbDM[i]);

                itemOrderedListing[i].add(jbtAssign[i]);
                itemOrderedListing[i].add(jbtDecline[i]);

                itemDetailListing.add(itemOrderedListing[i]);
                jpnWrap.add(itemDetailListing);

                int orderID = Integer.parseInt(jlblOrderID[i].getText().toString());
                jbtDecline[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < arrList.getScOrderClass().size(); i++) {
                            if (orderID == arrList.getScOrderClass().getEntry(i).getOrderID()) {
                                arrList.getScOrderClass().getEntry(i).setStatus("Declined");
                                SOAssignDeliveryJob assignJob = new SOAssignDeliveryJob();
                                assignJob.setData(arrList, username);
                                SOAssignDeliveryJob.this.setVisible(false);
                            }
                        }
                    }
                });

                final JComboBox dmName = jcbDM[i];
                jbtAssign[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        for (int j = 0; j < arrList.getScOrderClass().size(); j++) {
                            if (orderID == arrList.getScOrderClass().getEntry(j).getOrderID()) {
                                //arrList.getScOrderClass().getEntry(j).setDmName(dmName.getSelectedItem().toString());
                                arrList.getScOrderClass().getEntry(j).setStatus("Accepted");
                                JOptionPane.showMessageDialog(null, "Job Assign Successfully to " + dmName.getSelectedItem().toString());
                               
                                SOAssignDeliveryJob assignJob = new SOAssignDeliveryJob();
                                assignJob.setData(arrList, username);
                                SOAssignDeliveryJob.this.setVisible(false);
                            }
                        }
                    }
                });
            }
        }

        jbtBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminMenu admin = new AdminMenu();
                admin.setData(arrList, username);
                admin.setVisible(true);
                SOAssignDeliveryJob.this.setVisible(false);
            }
        });

        add(jlblTitle, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
        add(jbtBack, BorderLayout.SOUTH);

        setTitle("Job Assignment");
        setSize(900, 600);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
