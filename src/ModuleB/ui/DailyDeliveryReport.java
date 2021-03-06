/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.ui;

import ModuleB.adt.*;
import ModuleB.entity.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Priya
 */
public class DailyDeliveryReport extends javax.swing.JFrame {

    /**
     * Creates new form DailyDeliveryReport
     */
    String dbURL = "jdbc:derby://localhost:1527/Fast";

    Connection dbCon = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    static CircularDoublyLinkedList<Deliveryman> dmList = new CircularDoublyLinkedList<Deliveryman>();
    HRExecMenu caller;

    public HRExecMenu getCaller() {
        return caller;
    }

    public void setCaller(HRExecMenu caller) {
        this.caller = caller;
    }

    public DailyDeliveryReport() {
        initComponents();
        GregorianCalendar cal = new GregorianCalendar();
        jLabel2.setText("Daily Delivery Report (" +convertDate(cal.getTime().getTime())+ ")" );
    }

    public static CircularDoublyLinkedList<Deliveryman> getDmList() {
        return dmList;
    }
    
    public String convertDate(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }

    public static void setDmList(CircularDoublyLinkedList<Deliveryman> dmList) {
        DailyDeliveryReport.dmList = dmList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDisplay = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbtGen = new javax.swing.JButton();
        jbtBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Daily Delivery Report");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtaDisplay.setEditable(false);
        jtaDisplay.setBackground(new java.awt.Color(204, 204, 255));
        jtaDisplay.setColumns(20);
        jtaDisplay.setRows(5);
        jScrollPane1.setViewportView(jtaDisplay);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 840, 290));

        jLabel1.setText("  ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 40, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Daily Delivery Report");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jbtGen.setText("Generate Today's Report");
        jbtGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGenActionPerformed(evt);
            }
        });
        getContentPane().add(jbtGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 73, 180, 30));

        jbtBack.setText("Back To Menu");
        jbtBack.setActionCommand("back");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });
        getContentPane().add(jbtBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGenActionPerformed
        // TODO add your handling code here:
        genReport();
    }//GEN-LAST:event_jbtGenActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        // TODO add your handling code here:
       getCaller().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jbtBackActionPerformed

    /**
     * @param args the command line arguments
     */
    private void genReport() {

        try {
            String display = "No.\tDM ID \t Name \tTotal Deliveries \tDistance Travelled\n\n";
            int count = 1;
            LinkedStack<Integer> stack = new LinkedStack();

            LinkedStack<String> stack2 = new LinkedStack();
            
            for (int i = 0; i < dmList.getSize(); i++) {

                int noOfDelivery = 0;
                double distance = 0.00;

                Deliveryman dm = dmList.getEntry(i + 1);
                LinkedQueue q = (LinkedQueue) dm.getDeliveryQueue();
                int size = q.getSize();

                for (int j = 0; j < size; j++) {

                    Order ord = (Order) q.dequeue();
                    if (ord != null) {
                        if (ord.getDeliveryStatus().equals("Completed")) {
                            noOfDelivery++;
                            distance += genDistance();

                        }
                    }  
                }
                DecimalFormat df = new DecimalFormat(".##");
                String str = "\t"+ dm.getDmID() + " \t" + dm.getDmName()+ " \t" + ""+noOfDelivery + " \t\t" + df.format(distance) + "\n";
                
                sortedInsert(stack, noOfDelivery, stack2, str );
                
            }
            
            int size = stack.getSize();
            for (int i = 0; i < size; i++) {
                
                display+=count++ + stack2.pop();
            
            }
            
            jtaDisplay.setText(display);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            
        }
    }
    
    
     void sortedInsert(LinkedStack<Integer> stack1, int x, LinkedStack<String> stack2, String str)
    {
        // Base case: Either stack is empty or newly inserted
        if (stack1.isEmpty() || x > stack1.peek())
        {
            stack1.push(x);
            stack2.push(str);
            return;
        }

        int temp = stack1.pop();
        String tempStr = stack2.pop();
        sortedInsert(stack1, x, stack2, str);
        stack1.push(temp);
        stack2.push(tempStr);
    }
      
    // Method to sort stack
    void sortStack(LinkedStack<Integer> s, LinkedStack<String> s2)
    {
        if (!s.isEmpty())
        {
            int x = s.pop();
            String str = s2.pop();
            sortStack(s,s2);
            sortedInsert(s, x, s2, str);
        }
    }

    private double genDistance() {
        
        //Generate for around Selangor area
        double minLat = 3.0;
        double maxLat = 3.2;
        double minLon = 101.00;
        double maxLon = 101.50;

        double longitude1 = minLon + (double) (Math.random() * ((maxLon - minLon) + 1));
        double latitude1 = minLat + (double) (Math.random() * ((maxLat - minLat) + 1));

        double longitude2 = minLon + (double) (Math.random() * ((maxLon - minLon) + 1));
        double latitude2 = minLat + (double) (Math.random() * ((maxLat - minLat) + 1));

        return distance(latitude1, longitude1, latitude2, longitude2) / 1000;

    }

    public double distance(double lat1, double lng1, double lat2, double lng2) {
        double a = (lat1 - lat2) * DailyDeliveryReport.LatitudeDist(lat1);
        double b = (lng1 - lng2) * DailyDeliveryReport.LogitudeDist(lat1);
        return Math.sqrt(a * a + b * b);
    }

    private static double LogitudeDist(double lat) {
        return 0.0003121092 * Math.pow(lat, 4)
                + 0.0101182384 * Math.pow(lat, 3)
                - 17.2385140059 * lat * lat
                + 5.5485277537 * lat + 111301.967182595;
    }

    private static double LatitudeDist(double lat) {
        return -0.000000487305676 * Math.pow(lat, 4)
                - 0.0033668574 * Math.pow(lat, 3)
                + 0.4601181791 * lat * lat
                - 1.4558127346 * lat + 110579.25662316;
    }

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
            java.util.logging.Logger.getLogger(DailyDeliveryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DailyDeliveryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DailyDeliveryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DailyDeliveryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyDeliveryReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtGen;
    private javax.swing.JTextArea jtaDisplay;
    // End of variables declaration//GEN-END:variables
}
