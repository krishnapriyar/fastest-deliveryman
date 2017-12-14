package ui;

import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lysan Chen
 */
public class ItemDetail extends javax.swing.JFrame {

  int itemID;
  String itemName, category, promoInfo;
  double price;
    
    String dbURL = "jdbc:derby://localhost:1527/Fast"; 

        Connection dbCon = null; 
        PreparedStatement stmt = null; 
        ResultSet rs = null;
  
    public ItemDetail(char ch) {
        initComponents();
        autogenID();
        insertItem();
        customFrame(ch);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbtAdd = new javax.swing.JButton();
        jbtBack = new javax.swing.JButton();
        jbtUpdate = new javax.swing.JButton();
        jbtDelete = new javax.swing.JButton();
        jtfPrice = new javax.swing.JTextField();
        jtfName = new javax.swing.JTextField();
        jtfPromo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfCategory = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jcbItem = new javax.swing.JComboBox<>();
        jblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Item Details");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Item Name :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 164, 82, 33));

        jLabel2.setText("Category :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 285, 82, 30));

        jLabel3.setText("Price :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 225, 69, 36));

        jLabel4.setText("Promotional Info :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 340, -1, 28));

        jbtAdd.setText("Add Item");
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });
        getContentPane().add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 418, -1, -1));

        jbtBack.setText("Back");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });
        getContentPane().add(jbtBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 418, -1, -1));

        jbtUpdate.setText("Update Item");
        jbtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jbtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 418, -1, -1));

        jbtDelete.setText("Delete Item");
        jbtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jbtDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 418, -1, -1));

        jtfPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPriceActionPerformed(evt);
            }
        });
        getContentPane().add(jtfPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 231, 180, -1));

        jtfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNameActionPerformed(evt);
            }
        });
        getContentPane().add(jtfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 168, 180, -1));
        getContentPane().add(jtfPromo, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 342, 180, -1));

        jLabel5.setText("Item ID :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 117, 72, -1));

        jtfID.setEnabled(false);
        jtfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIDActionPerformed(evt);
            }
        });
        getContentPane().add(jtfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 117, 180, -1));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 40, 40));

        jtfCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beverage", "Desert", "Main Course", "Soup", "Steak\t", "Snacks", " " }));
        getContentPane().add(jtfCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 180, -1));

        jLabel8.setText("Select Item :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jcbItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unselected" }));
        jcbItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbItemActionPerformed(evt);
            }
        });
        getContentPane().add(jcbItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 170, -1));

        jblTitle.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        getContentPane().add(jblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 250, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed
        // TODO add your handling code here:
        itemID = Integer.parseInt(jtfID.getText());
        itemName = jtfName.getText();
        category = jtfCategory.getSelectedItem().toString();
        promoInfo = jtfPromo.getText();
        price = Double.parseDouble(jtfPrice.getText());
       
    try{
        
//        Class.forName("com.mysql.jdbc.Driver"); 
        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        Connection conn = DriverManager.getConnection(dbURL);
//        stmt = conn.createStatement();
//        String str = "INSERT INTO ITEM " + "VALUES (" + itemID +",'"+ itemName +"','"+category +"',"+ price +",'"+ promoInfo +"');";
//        stmt.executeUpdate(str) ;

        
                String insertStr = "INSERT INTO  ITEM   VALUES(?,?,?,?,?,?)";

            stmt = conn.prepareStatement(insertStr);

            stmt.setInt(1, itemID);
            stmt.setString(2, itemName);
            stmt.setString(3, category);
            stmt.setDouble(4,price);
            stmt.setString(5, promoInfo);
            //Temporary affiliate ID
            stmt.setInt(6, 3001);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Item added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            autogenID();
     
    }catch (Exception ex){
        JOptionPane.showMessageDialog(null,ex.getMessage(),"Failed", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jbtAddActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        // TODO add your handling code here:
            new CRUD().setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jbtBackActionPerformed

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateActionPerformed
          
       int ID = Integer.parseInt(jtfID.getText());
        String name = jtfName.getText();
        String price = jtfPrice.getText();
        String promo = jtfPromo.getText();
        String category = jtfCategory.getSelectedItem().toString();
        
        try{
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection conn = DriverManager.getConnection(dbURL);
            
            String updStr = "UPDATE ITEM SET ITEMNAME = ?,ITEMCATEGORY = ?,ITEMUNITPRICE = ?,PROMOTIONALINFO = ? WHERE ITEMID = ?";
            stmt = conn.prepareStatement(updStr);

            stmt.setInt(5, ID);
            stmt.setString(1, name);
            stmt.setString(2, category);
            stmt.setString(3, price);
            stmt.setString(4, promo);

            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Itwm updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Item could not be updated!", "Failed", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jbtUpdateActionPerformed

    private void jtfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNameActionPerformed

    private void jtfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIDActionPerformed

    private void jcbItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbItemActionPerformed
        
        String selectedItem = (String)jcbItem.getSelectedItem();
        
          String queryStr="SELECT * FROM ITEM WHERE ITEMNAME = ? ";
        try
        {
            Connection conn = DriverManager.getConnection(dbURL);
            stmt = conn.prepareStatement(queryStr);
           
            stmt.setString(1,selectedItem);
           
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {   
                jtfID.setText(rs.getString("ITEMID"));
                jtfName.setText(rs.getString("ITEMNAME"));     
                jtfPrice.setText(rs.getString("ITEMUNITPRICE"));
                jtfCategory.setSelectedItem(rs.getString("ITEMCATEGORY"));
                jtfPromo.setText(rs.getString("PROMOTIONALINFO"));
                
   
            }
            
           
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Empty", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
    }//GEN-LAST:event_jcbItemActionPerformed

    private void jtfPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPriceActionPerformed

    private void jbtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteActionPerformed

       
           try{
                if(!jcbItem.getSelectedItem().equals("Unselected")){
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection conn = DriverManager.getConnection(dbURL);
            
                         
                int ID = Integer.parseInt(jtfID.getText());
                System.out.print(ID);
                String name = jtfName.getText();
                String price = jtfPrice.getText();
                String promo = jtfPromo.getText();
                String category = jtfCategory.getSelectedItem().toString();
            
             String updStr = "DELETE FROM ITEM WHERE ITEMID = ? ";
             

             stmt = conn.prepareStatement(updStr);
             stmt.setInt(1, ID);
             stmt.executeUpdate();
         
            JOptionPane.showMessageDialog(null,"Itwm delete successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            jcbItem.removeAllItems();
            insertItem();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please select an item.!", "Failed", JOptionPane.ERROR_MESSAGE);
                }
        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Item could not be updated!", "Failed", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbtDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(ItemDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemDetail('a').setVisible(true);
                
            }
        });
    }

        private void autogenID(){
        
        int ID= 40001;
        
        try{
                DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
                Connection conn = DriverManager.getConnection(dbURL);
                
                String queryStr="SELECT MAX(ITEMID) FROM  ITEM";

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
        
    private void customFrame(char c){
    
             switch(c){
            case 'u':
                
                jblTitle.setText("Update Item");
               
                jcbItem.setEnabled(true);
                jtfID.setVisible(false);
                jLabel5.setVisible(false);
                jtfName.setEnabled(true);
                jtfPrice.setEnabled(true);
                jtfCategory.setEnabled(true);
                jtfPromo.setEnabled(true);
                
                jbtUpdate.setVisible(true);
                jbtBack.setVisible(true);
                jbtAdd.setVisible(false);
                jbtDelete.setVisible(false);
                break;
            case 'd':
                jblTitle.setText("Delete Item");
               
                jcbItem.setEnabled(true);
                jtfID.setEnabled(false);
                jtfName.setEnabled(false);
                jtfPrice.setEnabled(false);
                jtfCategory.setEnabled(false);
                jtfPromo.setEnabled(false);
                
                jbtUpdate.setVisible(false);
                jbtAdd.setVisible(false);
                jbtDelete.setVisible(true);
                 jbtBack.setVisible(true);
                break;
                
                case 'v':
                jblTitle.setText("View Item");
               
                jcbItem.setEnabled(true);
                jtfID.setEnabled(false);
                jtfName.setEnabled(false);
                jtfPrice.setEnabled(false);
                jtfCategory.setEnabled(false);
                jtfPromo.setEnabled(false);
                
                jbtUpdate.setVisible(false);
                jbtAdd.setVisible(false);
                jbtDelete.setVisible(false);
                 jbtBack.setVisible(true);
                break;
                
                case 'a':
                jblTitle.setText("Add Item");
               
                jcbItem.setVisible(false);
                jLabel8.setVisible(false);
                jtfID.setEnabled(false);
                jtfName.setEnabled(true);
                jtfPrice.setEnabled(true);
                jtfCategory.setEnabled(true);
                jtfPromo.setEnabled(true);
                
                jbtUpdate.setVisible(false);
                jbtAdd.setVisible(true);
                jbtDelete.setVisible(false);
                 jbtBack.setVisible(true);
                break;
       
        }
      
    
    }
           
       private void insertItem(){
       
           
            try{
                DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
                Connection conn = DriverManager.getConnection(dbURL);
                
                String queryStr="SELECT ITEMNAME FROM  ITEM";

                stmt = conn.prepareStatement(queryStr);
                ResultSet rs = stmt.executeQuery();
            
                while(rs.next())
                {   
                    jcbItem.addItem(rs.getString(1));
             
                }
                
            }catch (Exception ex){
               
            }
        
       }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jblTitle;
    private javax.swing.JButton jbtAdd;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtDelete;
    private javax.swing.JButton jbtUpdate;
    private javax.swing.JComboBox<String> jcbItem;
    private javax.swing.JComboBox<String> jtfCategory;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPrice;
    private javax.swing.JTextField jtfPromo;
    // End of variables declaration//GEN-END:variables
}
