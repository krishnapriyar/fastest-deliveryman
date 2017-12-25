/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.ui;


import ModuleB.adt.*;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import ModuleB.entity.*;
import java.sql.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author Priya
 */
public class PendingDeliveryFrame extends javax.swing.JFrame {

    String dbURL = "jdbc:derby://localhost:1527/Fast";
    static CircularDoublyLinkedList<Deliveryman> dmList;
    Connection dbCon = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    HRExecMenu caller;
    String display = "";
    int count = 1;

    public HRExecMenu getCaller() {
        return caller;
    }

    public void setCaller(HRExecMenu caller) {
        this.caller = caller;
    }

    public PendingDeliveryFrame() {
        initComponents();

    }

    public static CircularDoublyLinkedList<Deliveryman> getDmList() {
        return dmList;
    }

    public static void setDmList(CircularDoublyLinkedList<Deliveryman> dmList) {
        PendingDeliveryFrame.dmList = dmList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblDM = new javax.swing.JLabel();
        jlblTilte = new javax.swing.JLabel();
        jcbDM = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDisplay = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jbtMenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Pending Deliveries");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblDM.setText("Choose Delivey Man: ");
        getContentPane().add(jlblDM, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jlblTilte.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblTilte.setText("View Pending Deliveries");
        getContentPane().add(jlblTilte, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jcbDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDMActionPerformed(evt);
            }
        });
        getContentPane().add(jcbDM, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 150, -1));

        jtaDisplay.setEditable(false);
        jtaDisplay.setBackground(new java.awt.Color(204, 204, 204));
        jtaDisplay.setColumns(20);
        jtaDisplay.setRows(5);
        jScrollPane1.setViewportView(jtaDisplay);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 640, 300));

        jLabel1.setText("   ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, 40, 40));

        jbtMenu.setText("Back To Menu");
        jbtMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jbtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDMActionPerformed
        // TODO add your handling code here:
        try {
            display = "No.\tOrder ID \tDate \tTime \tETA\n\n";
            String dm = jcbDM.getSelectedItem().toString().substring(0, 5);
            count = 1;
            for (int i = 0; i < dmList.getSize(); i++) {
                if (dm.equals(dmList.getEntry(i + 1).getDmID() + "")) {
                    LinkedQueue q = (LinkedQueue) dmList.getEntry(i + 1).getDeliveryQueue();
                    int size = q.getSize();

                    for (int j = 0; j < size; j++) {

                        Order ord = (Order) q.dequeue();
                        if (ord != null) {
                            if (ord.getDeliveryStatus().equals("Pending")) {

                                display += count++ + "\t"
                                        + ord.getOrderID() + " \t"
                                        + convertDate(ord.getDateTime().getTime())
                                        + " \t" + convertTime(ord.getDateTime().getTime())
                                        + " \t" + ord.getETA() + "\n";
                            }
                        }
                    }
                }
            }
//        genFromDB(dm);
            jtaDisplay.setText(display);
        } catch (Exception ex) {
        }

    }//GEN-LAST:event_jcbDMActionPerformed

    public String convertTime(long time) {
        java.util.Date date = new java.util.Date(time);
        Format format = new SimpleDateFormat("HH:mm:ss");
        return format.format(date);
    }

    public String convertDate(long time) {
        java.util.Date date = new java.util.Date(time);
        Format format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }

    private void jbtMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMenuActionPerformed
        // TODO add your handling code here:

        caller.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            fillBox();
        }catch(Exception ex){
            System.out.print(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private String genFromDB(String dmid) {
        try {

            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection conn = DriverManager.getConnection(dbURL);

            String queryStr = "SELECT * FROM  TRANS WHERE DELIVERYSTATUS ='PENDING' AND DMID = " + dmid;

            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                display += count++ + "\t" + rs.getInt(1) + " \t" + rs.getDate(2, new GregorianCalendar()).toLocalDate() + " \t" + rs.getTime(3) + " \t" + rs.getTime(5) + "\n";

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return display;
    }

    public void fillBox() {
        jcbDM.removeAllItems();
        for (int i = 0; i < dmList.getSize(); i++) {

            jcbDM.addItem(dmList.getEntry(i + 1).getDmID() + "  " + dmList.getEntry(i + 1).getDmName());

        }
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
            java.util.logging.Logger.getLogger(PendingDeliveryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PendingDeliveryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PendingDeliveryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PendingDeliveryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PendingDeliveryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtMenu;
    private javax.swing.JComboBox<String> jcbDM;
    private javax.swing.JLabel jlblDM;
    private javax.swing.JLabel jlblTilte;
    private javax.swing.JTextArea jtaDisplay;
    // End of variables declaration//GEN-END:variables
}
