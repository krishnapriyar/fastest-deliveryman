/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author Bryan Chew
 */
public class DeliverymanClockInOut extends javax.swing.JFrame {

    /**
     * Creates new form DeliverymanClockInOut
     */
    private Connection con;
    private Statement stmt;
    private ResultSet rSet;
    private PreparedStatement prepare;
    private Date date;
    private List<DMClockInOut> list = new ArrayList<>();
    private String workStat1 = "Available";
    private String workStat2 = "Break Hour";

    public DeliverymanClockInOut() {
        initComponents();
        showDate();
        showTime();
        jcbDMan.addItem("-- Select --");

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
            stmt = con.createStatement();
            rSet = stmt.executeQuery("SELECT * FROM QWE.DELIVERYMAN");

            while (rSet.next()) {
                list.add(new DMClockInOut(rSet.getString("DMNAME"), Integer.parseInt(rSet.getString("DMID"))));
            }

            for (int i = 0; i < list.size(); i++) {
                jcbDMan.addItem(list.get(i).getDmName());
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        jcbDMan.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String DMname = jcbDMan.getSelectedItem().toString();
                getDMID(DMname);
            }
        });

    }

    public void getDMID(String DMname) {

        if (DMname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selected deliveryman unavailable");
        } else {
            try {
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                prepare = con.prepareStatement("SELECT * FROM QWE.DELIVERYMAN WHERE DMNAME = ?");
                prepare.setString(1, DMname);
                ResultSet rSet = prepare.executeQuery();

                if (rSet.next()) {
                    jlblDManID.setText(rSet.getString("DMID"));
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    void showDate() {
        date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        jlblDate.setText(sdf.format(date));
    }

    void showTime() {
        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
                jlblTime.setText(sdf.format(date));
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

        jlblDate = new javax.swing.JLabel();
        jlblTime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbDMan = new javax.swing.JComboBox();
        jlblDManID = new javax.swing.JLabel();
        jbtnClockOut = new javax.swing.JButton();
        jbtnLeaveBreak = new javax.swing.JButton();
        jbtnClockIn = new javax.swing.JButton();
        jbtnReturnBreak = new javax.swing.JButton();
        jbtnViewDMStat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlblDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblDate.setText("11/10/2017");
        jlblDate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlblTime.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jlblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTime.setText("06:42 PM");

        jLabel3.setText("Select Deliveryman:");

        jLabel4.setText("Deliveryman ID:");

        jcbDMan.setToolTipText("Select Deliveryman");
        jcbDMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDManActionPerformed(evt);
            }
        });

        jlblDManID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbtnClockOut.setText("CLOCK OUT");
        jbtnClockOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClockOutActionPerformed(evt);
            }
        });

        jbtnLeaveBreak.setText("LEAVE ON BREAK");
        jbtnLeaveBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLeaveBreakActionPerformed(evt);
            }
        });

        jbtnClockIn.setText("CLOCK IN");
        jbtnClockIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClockInActionPerformed(evt);
            }
        });

        jbtnReturnBreak.setText("RETURN FROM BREAK");
        jbtnReturnBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnReturnBreakActionPerformed(evt);
            }
        });

        jbtnViewDMStat.setText("VIEW DELIVERYMAN WORKING STATUS");
        jbtnViewDMStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnViewDMStatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jlblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jlblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(180, 180, 180))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jlblDManID, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jcbDMan, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbtnClockIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnLeaveBreak, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbtnClockOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnReturnBreak, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jbtnViewDMStat, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbDMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlblDManID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnClockOut, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnClockIn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLeaveBreak, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnReturnBreak, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnViewDMStat, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLeaveBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLeaveBreakActionPerformed
        // TODO add your handling code here:
        if (jlblDManID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select a deliveryman!");
        } else {
            try {
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                prepare = con.prepareStatement("UPDATE DELIVERYMAN SET WORKINGSTATUS = ? WHERE DMID = ?");

                prepare.setString(1, workStat2);
                prepare.setString(2, jlblDManID.getText());

                int rowsUpdated = prepare.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Deliveryman ID " + jlblDManID.getText() + " leaved succesful!");
                    //jbtnClockIn.setEnabled(false);
                    jlblDManID.setText("");
                    jcbDMan.setSelectedIndex(0);
                }
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_jbtnLeaveBreakActionPerformed

    private void jbtnClockInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClockInActionPerformed
        // TODO add your handling code here:

        if (jlblDManID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select a deliveryman!");
        } else {
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateOutput = dateFormat.format(date);

                con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                prepare = con.prepareStatement("SELECT * FROM QWE.TIMECARD WHERE DMID = ? AND DATE= ?");
                prepare.setString(1, jlblDManID.getText());
                prepare.setDate(2, java.sql.Date.valueOf(dateOutput));
                rSet = prepare.executeQuery();

                if (!rSet.next()) {
                    //INSERT SECTION-----------------------------------------------------------------
                    con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                    prepare = con.prepareStatement("INSERT INTO TIMECARD (DATE,CLOCKINTIME,CLOCKOUTTIME,DMID) VALUES (?,?,?,?)");

                    prepare.setDate(1, java.sql.Date.valueOf(dateOutput));
                    prepare.setString(2, jlblTime.getText());
                    prepare.setString(3, "00:00:00");
                    prepare.setInt(4, Integer.parseInt(jlblDManID.getText()));

                    int rowsInserted = prepare.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Clock in successful");
                    }
                    //INSERT SECTION-----------------------------------------------------------------
                } else {
                    JOptionPane.showMessageDialog(null, "Operation not allowed");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }//GEN-LAST:event_jbtnClockInActionPerformed

    private void jbtnReturnBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnReturnBreakActionPerformed
        // TODO add your handling code here:
        if (jlblDManID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select a deliveryman!");
        } else {
            try {
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                prepare = con.prepareStatement("UPDATE DELIVERYMAN SET WORKINGSTATUS = ? WHERE DMID = ?");

                prepare.setString(1, workStat1);
                prepare.setString(2, jlblDManID.getText());

                int rowsUpdated = prepare.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Deliveryman ID " + jlblDManID.getText() + " returned succesful!");
                    //jbtnClockIn.setEnabled(false);
                    jlblDManID.setText("");
                    jcbDMan.setSelectedIndex(0);
                }
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_jbtnReturnBreakActionPerformed

    private void jbtnViewDMStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnViewDMStatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DeliverymanWorkStatus().setVisible(true);

    }//GEN-LAST:event_jbtnViewDMStatActionPerformed

    private void jbtnClockOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClockOutActionPerformed
        // TODO add your handling code here:

        if (jlblDManID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select a deliveryman!");
        } else {
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateOutput = dateFormat.format(date);

                con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                prepare = con.prepareStatement("SELECT * FROM QWE.TIMECARD WHERE DMID= ? AND DATE= ?");
                prepare.setString(1, jlblDManID.getText());
                prepare.setDate(2, java.sql.Date.valueOf(dateOutput));
                rSet = prepare.executeQuery();

                if (rSet.next()) {
                    String clockOutTime = rSet.getTime(4).toString();
                    if (clockOutTime.equals("00:00:00")) {
                        //UPDATE SECTION-----------------------------------------------------------------
                        try {
                            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FastestDM", "qwe", "qwe");
                            prepare = con.prepareStatement("UPDATE TIMECARD SET CLOCKOUTTIME=? WHERE DMID=?");

                            //prepare.setDate(1, java.sql.Date.valueOf(dateOutput));
                            prepare.setString(1, jlblTime.getText());
                            prepare.setString(2, jlblDManID.getText());

                            int rowsUpdated = prepare.executeUpdate();
                            if (rowsUpdated > 0) {
                                JOptionPane.showMessageDialog(null, "Clock out successful");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                        //UPDATE SECTION-----------------------------------------------------------------
                    } else {
                        JOptionPane.showMessageDialog(null, "Operation not allowed");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Not clock in yet");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jbtnClockOutActionPerformed

    private void jcbDManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDManActionPerformed
        // TODO adyour handling code here
    }//GEN-LAST:event_jcbDManActionPerformed

    public void reset() {

    }

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
            java.util.logging.Logger.getLogger(DeliverymanClockInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliverymanClockInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliverymanClockInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliverymanClockInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeliverymanClockInOut().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbtnClockIn;
    private javax.swing.JButton jbtnClockOut;
    private javax.swing.JButton jbtnLeaveBreak;
    private javax.swing.JButton jbtnReturnBreak;
    private javax.swing.JButton jbtnViewDMStat;
    private javax.swing.JComboBox jcbDMan;
    private javax.swing.JLabel jlblDManID;
    private javax.swing.JLabel jlblDate;
    private javax.swing.JLabel jlblTime;
    // End of variables declaration//GEN-END:variables
}
