/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.*;
import javax.swing.*;
import adt.*;
import entity.*;

/**
 *
 * @author Priya
 */
public class DeliverymanDetailsFrame extends javax.swing.JFrame {

    /**
     * Creates new form DeliverymanDetailsFrame
     */
           
        String dbURL = "jdbc:derby://localhost:1527/Fast"; 

        Connection dbCon = null; 
        PreparedStatement stmt = null; 
        ResultSet rs = null;
        JFrame caller;
        
        CircularDoublyLinkedList<Deliveryman> dmList = new CircularDoublyLinkedList<Deliveryman>();
      
        
    public DeliverymanDetailsFrame(char ch) {
        initComponents();
        jdbStatus.setEnabled(false);
        jcbEdit.setSelected(false);
        prepFrame(ch);
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlblID = new javax.swing.JLabel();
        jlblName = new javax.swing.JLabel();
        jlblIC = new javax.swing.JLabel();
        jlblTel = new javax.swing.JLabel();
        jlblAdd1 = new javax.swing.JLabel();
        jlblAdd2 = new javax.swing.JLabel();
        jlblPost = new javax.swing.JLabel();
        jlblCity = new javax.swing.JLabel();
        jlblStatus = new javax.swing.JLabel();
        jdbStatus = new javax.swing.JComboBox<>();
        jtfID = new javax.swing.JTextField();
        jtfName = new javax.swing.JTextField();
        jtfID2 = new javax.swing.JTextField();
        jtfTel = new javax.swing.JTextField();
        jtfAdd1 = new javax.swing.JTextField();
        jtfAdd2 = new javax.swing.JTextField();
        jtfCity = new javax.swing.JTextField();
        jtfPost = new javax.swing.JTextField();
        jlblTitle = new javax.swing.JLabel();
        jbtAction = new javax.swing.JButton();
        jbtClear = new javax.swing.JButton();
        jbtBack = new javax.swing.JButton();
        jcbEdit = new javax.swing.JCheckBox();
        jlblPlaceHolder = new javax.swing.JLabel();
        jbtSearch = new javax.swing.JButton();
        jbtUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblID.setText("Deliveryman ID :");
        jlblID.setName(""); // NOI18N
        jPanel1.add(jlblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 77, 95, -1));

        jlblName.setText("Name:");
        jlblName.setName(""); // NOI18N
        jPanel1.add(jlblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 111, 95, -1));

        jlblIC.setText("IC No:");
        jlblIC.setName(""); // NOI18N
        jPanel1.add(jlblIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 111, 47, -1));

        jlblTel.setText("Telephone No:");
        jlblTel.setName(""); // NOI18N
        jPanel1.add(jlblTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 149, 95, -1));

        jlblAdd1.setText("Address Line 1:");
        jlblAdd1.setName(""); // NOI18N
        jPanel1.add(jlblAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 187, 95, -1));

        jlblAdd2.setText("Address Line 2:");
        jlblAdd2.setName(""); // NOI18N
        jPanel1.add(jlblAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 225, 95, -1));

        jlblPost.setText("Postal Code :");
        jlblPost.setName(""); // NOI18N
        jPanel1.add(jlblPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 264, 95, -1));

        jlblCity.setText("City :");
        jlblCity.setName(""); // NOI18N
        jPanel1.add(jlblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 44, 20));

        jlblStatus.setText("Status :");
        jPanel1.add(jlblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 303, -1, -1));

        jdbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employed", "Retired", "Resigned", "Terminated" }));
        jdbStatus.setEnabled(false);
        jPanel1.add(jdbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 300, 122, -1));

        jtfID.setEnabled(false);
        jPanel1.add(jtfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 74, 98, -1));
        jPanel1.add(jtfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 108, 221, -1));
        jPanel1.add(jtfID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 108, 260, -1));
        jPanel1.add(jtfTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 146, 221, -1));
        jPanel1.add(jtfAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 184, 573, -1));
        jPanel1.add(jtfAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 570, -1));
        jPanel1.add(jtfCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 261, 250, -1));

        jtfPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPostActionPerformed(evt);
            }
        });
        jPanel1.add(jtfPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 261, 122, -1));

        jlblTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblTitle.setText("Add New Delivery Man");
        jPanel1.add(jlblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 27, 661, -1));

        jbtAction.setText("Add Staff");
        jbtAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtActionActionPerformed(evt);
            }
        });
        jPanel1.add(jbtAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jbtClear.setText("Reset Fields");
        jbtClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClearActionPerformed(evt);
            }
        });
        jPanel1.add(jbtClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, -1, -1));

        jbtBack.setText("Back To Menu");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });
        jPanel1.add(jbtBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, -1, -1));

        jcbEdit.setText("Edit?");
        jcbEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEditActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 299, -1, -1));
        jPanel1.add(jlblPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 79, 19));

        jbtSearch.setText("Search Staff");
        jbtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jbtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jbtUpdate.setText("Update Staff");
        jbtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(jbtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClearActionPerformed
        // TODO add your handling code here:
        clearText();
        
    }//GEN-LAST:event_jbtClearActionPerformed

    private void jtfPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPostActionPerformed
        // TODO add your handling code here:
//        //Automatically fill city
//        String postcode = jtfPost.getText();
//        if(postcode.length()==5){
//            
//            try{
//                DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
//                Connection conn = DriverManager.getConnection(dbURL);
//                
//                String queryStr="SELECT CITY FROM  POSTALCODES WHERE POSTALCODE = ?";
//
//                stmt = conn.prepareStatement(queryStr);
//                stmt.setString(1,postcode);
//                ResultSet rs = stmt.executeQuery();
//            
//                if(rs.next())
//                {
//                    jtfCity.setText(rs.getString(1));  
//                    
//                }
//                
//            }catch (Exception ex){
//                System.out.println(ex.getMessage());
//            }            
//        
//        }
    }//GEN-LAST:event_jtfPostActionPerformed

    private void jcbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEditActionPerformed
        // TODO add your handling code here:
       jdbStatus.setEnabled(jcbEdit.isSelected());
    }//GEN-LAST:event_jcbEditActionPerformed

    private void jbtActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtActionActionPerformed
        // TODO add your handling code here:
        
        int ID = Integer.parseInt(jtfID.getText());
        String name = jtfName.getText();
        String IC = jtfID2.getText();
        String tel = jtfTel.getText();
        String address = jtfAdd1.getText() +"|"+ jtfAdd2.getText() +"|"+jtfPost.getText()+"|"+ jtfCity.getText();
        String status = jdbStatus.getSelectedItem().toString();
        
        try{
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection conn = DriverManager.getConnection(dbURL);
            
            String insertStr = "INSERT INTO  DELIVERYMAN VALUES(?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(insertStr);

            stmt.setInt(1, ID);
            stmt.setString(2, name);
            stmt.setString(3, IC);
            stmt.setString(4, tel);
            stmt.setString(5, address);
            stmt.setString(6, status);
            stmt.setString(7, "No");
            stmt.setString(8, status);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Delivery man added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearText();
            autogenID();
        }catch (Exception ex){
            
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Delivery man could not be added!", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtActionActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        // TODO add your handling code here:
        getCaller().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtBackActionPerformed

    private void jbtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSearchActionPerformed
        // TODO add your handling code here:   
        
        String queryStr="SELECT * FROM DELIVERYMAN WHERE DMID = ? OR DMNAME = ? OR DMIC = ?";
        try
        {
            Connection conn = DriverManager.getConnection(dbURL);
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,jtfID.getText());
            stmt.setString(2,jtfName.getText());
            stmt.setString(3,jtfID2.getText());
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {   
                jtfName.setText(rs.getString("DMNAME"));
                jtfID2.setText(rs.getString("DMIC"));
                jtfTel.setText(rs.getString("DMTELNO"));
                formatAddress(rs.getString("DMADDRESS"));
                jdbStatus.setSelectedItem(rs.getString("ACTIVESTATUS"));
                
                if(jbtUpdate.isVisible()){
                    jtfTel.setEnabled(true);
                    jtfAdd1.setEnabled(true);
                    jtfAdd2.setEnabled(true);
                    jtfCity.setEnabled(true);
                    jtfPost.setEnabled(true);
        }
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"No record found!!", "Empty", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_jbtSearchActionPerformed

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateActionPerformed
        // TODO add your handling code here:
   
        int ID = Integer.parseInt(jtfID.getText());
        String name = jtfName.getText();
        String IC = jtfID2.getText();
        String tel = jtfTel.getText();
        String address = jtfAdd1.getText() +"|"+ jtfAdd2.getText() +"|"+jtfPost.getText()+"|"+ jtfCity.getText();
        String status = jdbStatus.getSelectedItem().toString();
        
        try{
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection conn = DriverManager.getConnection(dbURL);
            
            String updStr = "UPDATE DELIVERYMAN SET DMNAME = ?, DMIC = ?,DMTELNO = ?,DMADDRESS = ?,ACTIVESTATUS = ?, AVAILABILITY = ?, WORKINGSTATUS = ? WHERE DMID = ?";
            stmt = conn.prepareStatement(updStr);

            stmt.setInt(8, ID);
            stmt.setString(1, name);
            stmt.setString(2, IC);
            stmt.setString(3, tel);
            stmt.setString(4, address);
            stmt.setString(5, status);
            stmt.setString(6, "No");
            stmt.setString(7, status);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Delivery man updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearText();
        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Delivery man could not be updated!", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtUpdateActionPerformed

    private void autogenID(){
        
        int ID= 20001;
        
        try{
                DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
                Connection conn = DriverManager.getConnection(dbURL);
                
                String queryStr="SELECT MAX(DMID) FROM  DELIVERYMAN";

                stmt = conn.prepareStatement(queryStr);
                ResultSet rs = stmt.executeQuery();
            
                if(rs.next())
                {   
                    ID=rs.getInt(1)!=0?rs.getInt(1)+1:ID;
             
                }
                
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        
        jtfID.setText(ID+"");  
     
    }
    
    private void clearText(){
        jtfID.setText("");
        jtfName.setText("");
        jtfID2.setText("");
        jtfTel.setText("");
        jtfAdd1.setText("");
        jtfAdd2.setText("");
        jtfCity.setText("");
        jtfPost.setText("");
    }
    
    public void setCaller(JFrame caller){
    
        this.caller = caller;
    }
    
    public JFrame getCaller(){
         return caller;
     }
    
    private void prepFrame(char c){
        
        switch(c){
            case 'u':
                clearText();
                jlblTitle.setText("Update Deliveryman");
                jtfID.setEnabled(true);
                
                jtfTel.setEnabled(false);
                jtfAdd1.setEnabled(false);
                jtfAdd2.setEnabled(false);
                jtfCity.setEnabled(false);
                jtfPost.setEnabled(false);
                
                jbtAction.setVisible(false);
                break;
            case 's':
                clearText();
                jlblTitle.setText("Search Deliveryman");
                jtfID.setEnabled(true);
                jtfTel.setEnabled(false);
                jtfAdd1.setEnabled(false);
                jtfAdd2.setEnabled(false);
                jtfCity.setEnabled(false);
                jtfPost.setEnabled(false);
                jbtAction.setVisible(false);
                jbtUpdate.setVisible(false);
                break;
                
            case 'a':
                autogenID();
                jbtSearch.setVisible(false);
                jbtUpdate.setVisible(false);
                break;
                
            
            
        }
    }
    
    
    private void formatAddress(String fulladdress){
    
        try{
        String[] parts = fulladdress.split("\\|");
        jtfAdd1.setText(parts[0]);
        jtfAdd2.setText(parts[1]);
        jtfPost.setText(parts[2]);
        jtfCity.setText(parts[3]);
        }
        catch(Exception ex ){
        
        }

    }

    public CircularDoublyLinkedList<Deliveryman> getDmList() {
        return dmList;
    }

    public void setDmList(CircularDoublyLinkedList<Deliveryman> dmList) {
        this.dmList = dmList;
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
            java.util.logging.Logger.getLogger(DeliverymanDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliverymanDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliverymanDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliverymanDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeliverymanDetailsFrame('u').setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtAction;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtClear;
    private javax.swing.JButton jbtSearch;
    private javax.swing.JButton jbtUpdate;
    private javax.swing.JCheckBox jcbEdit;
    private javax.swing.JComboBox<String> jdbStatus;
    private javax.swing.JLabel jlblAdd1;
    private javax.swing.JLabel jlblAdd2;
    private javax.swing.JLabel jlblCity;
    private javax.swing.JLabel jlblIC;
    private javax.swing.JLabel jlblID;
    private javax.swing.JLabel jlblName;
    private javax.swing.JLabel jlblPlaceHolder;
    private javax.swing.JLabel jlblPost;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JLabel jlblTel;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JTextField jtfAdd1;
    private javax.swing.JTextField jtfAdd2;
    private javax.swing.JTextField jtfCity;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfID2;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPost;
    private javax.swing.JTextField jtfTel;
    // End of variables declaration//GEN-END:variables
}
