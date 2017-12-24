package ModuleD.ui;

import ModuleD.entity.OrderClass;
import ModuleD.entity.DMClockInOut;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.sql.*;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.Timer;
import ModuleD.adt.DMListImplementation;
import ModuleD.adt.DMListInterface;
import ModuleD.entity.DeliveryManDet;
import ModuleD.entity.OrderClass;
import ui.AdminMenu;

public class DeliverymanWorkStatus extends javax.swing.JFrame {

    private Date date;
    private SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm aa");
    private String selectedItem = null;
    private DMListInterface<DMClockInOut> listDM = new DMListImplementation<>();
    private Queue<OrderClass> queueOrder = new ArrayBlockingQueue<OrderClass>(100);

    public DeliverymanWorkStatus() {
        initComponents();
        showDate();

        jcbDMname.addItem("-- Select --");
        jcbCurrentStat.setVisible(false);
        jcbCurrentStat.setEnabled(false);
        jlblCurrentStat.setFont(new Font("Tahoma", Font.BOLD, 11));
        orderNo.setEnabled(false);

        // NEWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW
        try {
            listDM.addNewEntry(new DMClockInOut("John", 10000, "Available", sdfDate.parse("12/12/2017"), sdfTime.parse("12:00 AM"), sdfTime.parse("06:00 AM")));
            listDM.addNewEntry(new DMClockInOut("Adam", 10001, "Break", sdfDate.parse("12/12/2017"), sdfTime.parse("11:11 AM"), sdfTime.parse("09:09 AM")));
            listDM.addNewEntry(new DMClockInOut("Smith", 10002, "On Leave", sdfDate.parse("12/12/2017"), sdfTime.parse("07:07 AM"), sdfTime.parse("08:08 AM")));
//            queueOrder.add(new OrderClass(20002, "Available", 99, 19.19, "91019191919", 10000));
//            queueOrder.add(new OrderClass(30003, "Unavailable", 88, 19.19, "12345678233", 10001));
//            queueOrder.add(new OrderClass(40004, "OTW", 77, 19.19, "68273673678", 10002));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < listDM.retrieveSize(); i++) {
            jcbDMname.addItem(listDM.retrieveAllEntry(i).getDmName());
        }

        jcbDMname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedItem = jcbDMname.getSelectedItem().toString();

                for (int i = 0; i < listDM.retrieveSize(); i++) {
                    if (listDM.retrieveAllEntry(i).getDmName().equals(selectedItem)) {
                        jlblDMID.setText(String.valueOf(listDM.retrieveAllEntry(i).getDmID()));
                        jlblCurrentStat.setText(listDM.retrieveAllEntry(i).getStatus());

                        Integer tempID = Integer.valueOf(listDM.retrieveAllEntry(i).getDmID());

                        while (!queueOrder.isEmpty()) {
                            for (int j = 0; j < queueOrder.size(); j++) {
                                if (queueOrder.element().getDmID() == tempID) {
                                    orderNo.setText(String.valueOf(queueOrder.element().getOrderID()));
                                    //custID.setText(String.valueOf(queueOrder.element().getCustIC()));
                                    
                                } else {
                                    JOptionPane.showMessageDialog(null, "No record");
                                }
                            }
                        }
                    }
                }
            }
        });
        // NEWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW

        if (jcbDMname.getSelectedItem().toString().equals("-- Select --")) {
            jlblCurrentStat.setText(null);
            orderNo.setText(null);
            custID.setText(null);
            jbtnUpdate.setEnabled(false);
        } else {
            jbtnUpdate.setEnabled(true);
        }

        jcbDMname.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String DMID = jcbDMname.getSelectedItem().toString();
                getDMID(DMID);
            }
        });
    }

    public void getDMID(String DMname) {
        orderNo.setText("");
        custID.setText("");
        if (DMname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selected deliveryman unavailable");
        }
    }

    void RetrieveIDs() {
        if (jlblCurrentStat.getText().equals("Delivery")) {
        } else {
            orderNo.setText(null);
            custID.setText(null);
        }
    }

    void showDate() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd-MMM-yyyy  HH:mm:ss aa");
                jlblDate.setText(sdf.format(date));
            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblTitleDWS = new javax.swing.JLabel();
        DMID = new javax.swing.JLabel();
        jlblName = new javax.swing.JLabel();
        jlblStat = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jlblDMID = new javax.swing.JLabel();
        jlblDate = new javax.swing.JLabel();
        jbtnUpdate = new javax.swing.JButton();
        jlblDynamic = new javax.swing.JLabel();
        orderNo = new javax.swing.JLabel();
        jcbDMname = new javax.swing.JComboBox();
        jlblCurrentStat = new javax.swing.JLabel();
        jcbCurrentStat = new javax.swing.JComboBox();
        jlblDynamic1 = new javax.swing.JLabel();
        custID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlblTitleDWS.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblTitleDWS.setText("Deliveryman Working Status");
        jlblTitleDWS.setMaximumSize(new java.awt.Dimension(178, 22));
        jlblTitleDWS.setMinimumSize(new java.awt.Dimension(178, 22));

        DMID.setText("Deliveryman Name:");

        jlblName.setText("ID:");

        jlblStat.setText("Current Status:");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jlblDate.setText(" ");

        jbtnUpdate.setText("Update Status");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        jlblDynamic.setText("Order ID:");

        orderNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jcbDMname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDMnameActionPerformed(evt);
            }
        });

        jcbCurrentStat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Select a status --", "Available", "Break hour", "Delivery", "On leave" }));

        jlblDynamic1.setText("Customer ID:");

        custID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblTitleDWS, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlblDate))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 16, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblDynamic)
                                    .addComponent(jlblDynamic1))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(orderNo, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(custID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(297, 297, 297)))
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblStat)
                        .addGap(18, 18, 18)
                        .addComponent(jlblCurrentStat, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbCurrentStat, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(DMID)
                .addGap(18, 18, 18)
                .addComponent(jcbDMname, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jlblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblDMID, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTitleDWS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblDate))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblDMID, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblName)
                        .addComponent(DMID)
                        .addComponent(jcbDMname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblStat)
                    .addComponent(jlblCurrentStat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCurrentStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlblDynamic))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblDynamic1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jButton1.getAccessibleContext().setAccessibleName("Update");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new AdminMenu().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed

        if (!jcbCurrentStat.getSelectedItem().toString().equals("-- Select a status --")) {
            int confirmation1 = JOptionPane.showConfirmDialog(null, "Do you want to update " + jcbDMname.getSelectedItem().toString() + "'s status?", "Update current work status", JOptionPane.YES_NO_OPTION);
            String currentStat = jcbCurrentStat.getSelectedItem().toString();

            if (confirmation1 == 0) {
                if (currentStat != "Delivery") {
                    if (!jcbCurrentStat.getSelectedItem().toString().equals(jlblCurrentStat.getText())) {
                        if (jlblCurrentStat.getText() != "Delivery") {
                            orderNo.setText(null);
                            custID.setText(null);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Status is already - " + jcbCurrentStat.getSelectedItem().toString() + "\n Please select other status ");
                    }
                } else {
                    //ASSIGN NEW ORDER NUMBER ---> TO NEW PAGE
                    JOptionPane.showMessageDialog(null, "Click OK to assign new Delivery Order to " + jcbDMname.getSelectedItem().toString());
                    this.setVisible(false);
                    //new TrackOrder().setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a status!");
        }
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jcbDMnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDMnameActionPerformed

    }//GEN-LAST:event_jcbDMnameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeliverymanWorkStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliverymanWorkStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliverymanWorkStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliverymanWorkStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeliverymanWorkStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DMID;
    private javax.swing.JLabel custID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jbtnUpdate;
    private javax.swing.JComboBox jcbCurrentStat;
    private javax.swing.JComboBox jcbDMname;
    private javax.swing.JLabel jlblCurrentStat;
    private javax.swing.JLabel jlblDMID;
    private javax.swing.JLabel jlblDate;
    private javax.swing.JLabel jlblDynamic;
    private javax.swing.JLabel jlblDynamic1;
    private javax.swing.JLabel jlblName;
    private javax.swing.JLabel jlblStat;
    private javax.swing.JLabel jlblTitleDWS;
    private javax.swing.JLabel orderNo;
    // End of variables declaration//GEN-END:variables
}
