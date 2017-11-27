package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class DeliverymanWorkStatus extends javax.swing.JFrame {

    private Connection con;
    private Statement stmt;
    private ResultSet rSet;
    private Date date;
    private PreparedStatement prepare;
    private List<DMWorkStat> list = new ArrayList<>();
    private String empStatus = "Active";

    public DeliverymanWorkStatus() {
        initComponents();
        showDate();
        jcbDMID.addItem("-- Select --");
        jcbCurrentStat.setVisible(false);
        jcbCurrentStat.setEnabled(false);
        jlblCurrentStat.setFont(new Font("Tahoma", Font.BOLD, 11));
        orderNo.setEnabled(false);

        if (jcbDMID.getSelectedItem().toString().equals("-- Select --")) {
            jbtnUpdate.setEnabled(false);
        } else {
            jbtnUpdate.setEnabled(true);
        }
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
            stmt = con.createStatement();
            rSet = stmt.executeQuery("SELECT * FROM QWE.DELIVERYMAN WHERE ACTIVESTATUS = 'Active'");

            while (rSet.next()) {
                list.add(new DMWorkStat(rSet.getString("DMNAME"), Integer.parseInt(rSet.getString("DMID"))));
            }
            for (int i = 0; i < list.size(); i++) {
                jcbDMID.addItem(list.get(i).getDmName());
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        jcbDMID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String DMID = jcbDMID.getSelectedItem().toString();
                getDMID(DMID);
            }
        });
    }

    public void getDMID(String DMname) {
        orderNo.setText("");
        custID.setText("");

        if (DMname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selected deliveryman unavailable");
        } else {
            try {
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                prepare = con.prepareStatement("SELECT * FROM QWE.DELIVERYMAN WHERE DMName = ?");
                prepare.setString(1, DMname);
                //prepare.setString(2, empStatus.toString());
                ResultSet rSet = prepare.executeQuery();

                if (rSet.next()) {
                    jlblDMID.setText(rSet.getString("DMID"));
                    try {
                        con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                        prepare = con.prepareStatement("SELECT WORKINGSTATUS FROM QWE.DELIVERYMAN WHERE DMID = ? ");
                        prepare.setString(1, jlblDMID.getText());
                        rSet = prepare.executeQuery();

                        if (rSet.next()) {
                            jlblCurrentStat.setText(rSet.getString("WORKINGSTATUS"));
                            jbtnUpdate.setEnabled(true);
                            jcbCurrentStat.setEnabled(true);
                            jcbCurrentStat.setVisible(true);

                            RetrieveIDs();
                        } else {
                            jlblCurrentStat.setText("No status yet");
                        }
                    } catch (SQLException e) {
                        System.err.println(e);
                    }
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    void RetrieveIDs() {
        if (jlblCurrentStat.getText().equals("Delivery")) {

            try {
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                prepare = con.prepareStatement("SELECT TRANID,CUSTID FROM QWE.TRANS WHERE DMID = ? ");
                prepare.setString(1, jlblDMID.getText());
                rSet = prepare.executeQuery();
                if (rSet.next()) {
                    orderNo.setText(rSet.getString("TRANID"));
                    custID.setText(rSet.getString("CUSTID"));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
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
        jcbDMID = new javax.swing.JComboBox();
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

        jlblDynamic.setText("Order No:");

        orderNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jcbDMID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDMIDActionPerformed(evt);
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
                .addComponent(jcbDMID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jlblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblDMID, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblName)
                    .addComponent(DMID)
                    .addComponent(jcbDMID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblDMID, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblStat)
                    .addComponent(jlblCurrentStat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCurrentStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblDynamic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        new DeliverymanClockInOut().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed

        if (!jcbCurrentStat.getSelectedItem().toString().equals("-- Select a status --")) {
            int confirmation1 = JOptionPane.showConfirmDialog(null, "Do you want to update " + jcbDMID.getSelectedItem().toString() + "'s status?", "Update current work status", JOptionPane.YES_NO_OPTION);
            String currentStat = jcbCurrentStat.getSelectedItem().toString();

            if (confirmation1 == 0) {
                if (currentStat != "Delivery") {
                    if (!jcbCurrentStat.getSelectedItem().toString().equals(jlblCurrentStat.getText())) {
                        if (jlblCurrentStat.getText() != "Delivery") {
                            orderNo.setText(null);
                            custID.setText(null);
                        }
                        try {
//                      UPDATE SECTION -----------------------------------------------------------------------------
                            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                            prepare = con.prepareStatement("UPDATE DELIVERYMAN SET WORKINGSTATUS=? WHERE DMID=?");
                            prepare.setString(1, currentStat);
                            prepare.setString(2, jlblDMID.getText());

                            int rowsUpdated = prepare.executeUpdate();
                            if (rowsUpdated > 0) {
//                          RETRIEVE SECTION -----------------------------------------------------------------------
                                try {
                                    con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                                    prepare = con.prepareStatement("SELECT WORKINGSTATUS FROM QWE.DELIVERYMAN WHERE DMID = ? ");
                                    prepare.setString(1, jlblDMID.getText());
                                    rSet = prepare.executeQuery();
                                    if (rSet.next()) {
                                        jlblCurrentStat.setText(rSet.getString("WORKINGSTATUS"));
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, ex.toString());
                                }
                                JOptionPane.showMessageDialog(null, "Status update successful");
                            }
//                          RETRIEVE SECTION -----------------------------------------------------------------------
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.toString());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Status is already - " + jcbCurrentStat.getSelectedItem().toString() + "\n Please select other status ");
                    }
                } else {
                    //ASSIGN NEW ORDER NUMBER ---> TO NEW PAGE
                    JOptionPane.showMessageDialog(null, "Click OK to assign new Delivery Order to " + jcbDMID.getSelectedItem().toString());
                    this.setVisible(false);
                    new TrackOrder().setVisible(true);
                    //ASSIGN NEW ORDER NUMBER ---> TO NEW PAGE             
                }
//                      UPDATE SECTION -----------------------------------------------------------------------------
            }

        } else {
            JOptionPane.showMessageDialog(null, "Select a status!");
        }


    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jcbDMIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDMIDActionPerformed

    }//GEN-LAST:event_jcbDMIDActionPerformed

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
    private javax.swing.JComboBox jcbDMID;
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
