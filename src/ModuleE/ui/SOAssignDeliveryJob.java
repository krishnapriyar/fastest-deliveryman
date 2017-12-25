package ModuleE.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SOAssignDeliveryJob extends JFrame {

    private JLabel jlblTitle = new JLabel("Assign Job to delivery man");
    private java.awt.Font fontTitle = new java.awt.Font("Arial", java.awt.Font.PLAIN, 28);
    private java.awt.Font fontDisplay = new java.awt.Font("Arial", java.awt.Font.PLAIN, 23);
    private java.text.SimpleDateFormat sdfDate = new java.text.SimpleDateFormat("dd/MM/yyyy");
    private java.text.SimpleDateFormat sdfTime = new java.text.SimpleDateFormat("hh:mm aa");
    private ModuleE.entity.ListClass arrList = new ModuleE.entity.ListClass();
    private String username, dmName;
    private ModuleE.entity.RetrieveDeliverymanData t = new ModuleE.entity.RetrieveDeliverymanData();
    private int dmID = 0;

    public void setData(ModuleE.entity.ListClass arrClass, String name) {
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
        javax.swing.JComboBox[] jcbDM = new javax.swing.JComboBox[arrList.getScOrderClass().size()];
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
                jcbDM[i] = new javax.swing.JComboBox();
                jbtAssign[i] = new JButton("Accept");
                jbtDecline[i] = new JButton("Decline");

                jcbDM[i].addItem("-- Select --");
                for (int j = 0; j < t.getList().getSize(); j++) {
                    jcbDM[i].addItem(t.getList().getAllData(j).getDmName());
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

                javax.swing.JComboBox jcb = jcbDM[i];
                jcbDM[i].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        for (int i = 0; i < t.getList().getSize(); i++) {
                            if (jcb.getSelectedItem().toString().equals(t.getList().getAllData(i).getDmName())) {
                                dmID = t.getList().getAllData(i).getDmID();
                                dmName = t.getList().getAllData(i).getDmName();
                            }
                        }
                    }
                });

                int orderID = Integer.parseInt(jlblOrderID[i].getText().toString());
                jbtDecline[i].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
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

                jbtAssign[i].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        for (int j = 0; j < arrList.getScOrderClass().size(); j++) {
                            if (orderID == arrList.getScOrderClass().getEntry(j).getOrderID()) {
                                if (jcb.getSelectedItem().toString().equals("-- Select --")) {
                                    JOptionPane.showMessageDialog(null, "Please select a delivery man !");
                                } else {
                                    arrList.getScOrderClass().getEntry(j).setDmID(dmID);
                                    arrList.getScOrderClass().getEntry(j).setStatus("Accepted");
                                    JOptionPane.showMessageDialog(null, "Job Assign Successfully to " + dmName);

                                    SOAssignDeliveryJob assignJob = new SOAssignDeliveryJob();
                                    assignJob.setData(arrList, username);
                                    SOAssignDeliveryJob.this.setVisible(false);
                                }
                            }
                        }
                    }
                });
            }
        }

        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ui.AdminMenu admin = new ui.AdminMenu();
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
