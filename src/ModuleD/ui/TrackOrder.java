package ModuleD.ui;

import ModuleD.entity.OrderClass;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import ModuleD.adt.DMListImplementation;
import ModuleD.adt.DMListInterface;

public class TrackOrder extends javax.swing.JFrame {

    int x;
    private DMListInterface<OrderClass> listDM = new DMListImplementation<>();
    private Queue<OrderClass> queueOrder = new ArrayBlockingQueue<OrderClass>(100);

    public TrackOrder() {
        initComponents();
//        listDM.addNewEntry(new OrderClass(10001, "Preparing", 200, 10.10, "9090909090", 10001));
//        listDM.addNewEntry(new OrderClass(10002, "OTW", 300, 20.10, "8080808080", 10002));
//        listDM.addNewEntry(new OrderClass(10003, "Delivered", 400, 30.10, "8080808080", 10003));
//        queueOrder.add(new OrderClass(20002, "Available", 99, 19.19, "91019191919", 10000));
//        queueOrder.add(new OrderClass(30003, "Unavailable", 88, 19.19, "12345678233", 10001));
//        queueOrder.add(new OrderClass(40004, "OTW", 77, 19.19, "68273673678", 10002));
    }

    public void getOrder(String DMname) {
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        String hourFormat = "";
//        //Date dateTemp = sdf.parse(rSet.getString("TRANTIME"));
//        Calendar gc = new GregorianCalendar();
//
//        gc.add(Calendar.HOUR, 1);
//        Date d2 = gc.getTime();
//
//        String dateFormatted = sdf.format(d2);
//        eta.setText(dateFormatted + hourFormat);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jtfOrderID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        orderDate = new javax.swing.JTextField();
        orderTime = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        eta = new javax.swing.JTextField();
        deliveryStatus = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jbtnFindOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jlblTitleDWS.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblTitleDWS.setText("Track your orders here!");
        jlblTitleDWS.setMaximumSize(new java.awt.Dimension(178, 22));
        jlblTitleDWS.setMinimumSize(new java.awt.Dimension(178, 22));

        jLabel2.setText("Enter your Order ID:");

        jLabel4.setText("Order Date: ");

        jtfOrderID.setInheritsPopupMenu(true);
        jtfOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfOrderIDActionPerformed(evt);
            }
        });

        jLabel5.setText("Order Time: ");

        jLabel6.setText("Delivery Status: ");

        orderDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        orderDate.setEnabled(false);

        orderTime.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        orderTime.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Est. Time of arrival: ");

        eta.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        eta.setEnabled(false);

        deliveryStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deliveryStatus.setEnabled(false);
        deliveryStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryStatusActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbtnFindOrder.setText("Find Order");
        jbtnFindOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFindOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblTitleDWS, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jbtnFindOrder))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eta, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deliveryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(orderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderTime, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jlblTitleDWS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnFindOrder))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(orderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(deliveryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(eta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deliveryStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deliveryStatusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfOrderIDActionPerformed

    }//GEN-LAST:event_jtfOrderIDActionPerformed

    private void jbtnFindOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFindOrderActionPerformed
        int int1;
        try {
            int1 = Integer.parseInt(jtfOrderID.getText());
            jtfOrderID.requestFocusInWindow();
            for (int i = 0; i < listDM.retrieveSize(); i++) {
                if (int1 == listDM.retrieveAllEntry(i).getOrderID()) {
                    deliveryStatus.setText(listDM.retrieveAllEntry(i).getStatus());
                }

                Integer tempID = Integer.valueOf(queueOrder.element().getOrderID());

                for (int j = 0; j < queueOrder.size(); j++) {
                    if (queueOrder.element().getOrderID() == tempID) {
                        orderDate.setText(String.valueOf(queueOrder.element().getOrderDate()));
                        orderTime.setText(String.valueOf(queueOrder.element().getOrderTime()));
                    } else {
                        JOptionPane.showMessageDialog(null, "No record");
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Order ID is not valid");
            jtfOrderID.setText("");
            jtfOrderID.requestFocusInWindow();
            return;
        }
    }//GEN-LAST:event_jbtnFindOrderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrackOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField deliveryStatus;
    private javax.swing.JTextField eta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtnFindOrder;
    private javax.swing.JLabel jlblTitleDWS;
    private javax.swing.JTextField jtfOrderID;
    private javax.swing.JTextField orderDate;
    private javax.swing.JTextField orderTime;
    // End of variables declaration//GEN-END:variables
}