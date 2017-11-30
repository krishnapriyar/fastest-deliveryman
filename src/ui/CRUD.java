                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              package ui;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.spi.DirStateFactory.Result;
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
public class CRUD extends javax.swing.JFrame {

    
    private String host = "jdbc:derby://localhost:1527/Fast";
    private String user = "";
    private String password = "";
    private String tableName = "ITEM";
    private Connection conn;
    private PreparedStatement stmt;
    
    public CRUD() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbtView = new javax.swing.JButton();
        jbtAddItem = new javax.swing.JButton();
        jbtUpdateItem = new javax.swing.JButton();
        jbtDeleteItem = new javax.swing.JButton();
        jcbItem = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select Item :");

        jbtView.setText("View");
        jbtView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewActionPerformed(evt);
            }
        });

        jbtAddItem.setText("Add");
        jbtAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddItemActionPerformed(evt);
            }
        });

        jbtUpdateItem.setText("Update");
        jbtUpdateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateItemActionPerformed(evt);
            }
        });

        jbtDeleteItem.setText("Delete");
        jbtDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteItemActionPerformed(evt);
            }
        });

        jcbItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtView)
                        .addGap(27, 27, 27)
                        .addComponent(jbtAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtUpdateItem)
                        .addGap(30, 30, 30)
                        .addComponent(jbtDeleteItem))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtView)
                    .addComponent(jbtAddItem)
                    .addComponent(jbtUpdateItem)
                    .addComponent(jbtDeleteItem))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void jcbItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbItemActionPerformed

    private void jbtViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewActionPerformed
    new ItemDetail().setVisible(true);
    this.setVisible(false);

    }//GEN-LAST:event_jbtViewActionPerformed

    private void jbtAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddItemActionPerformed
     new ItemDetail().setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_jbtAddItemActionPerformed

    private void jbtUpdateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateItemActionPerformed
    new ItemDetail().setVisible(true);
    this.setVisible(false);
        
    }//GEN-LAST:event_jbtUpdateItemActionPerformed

    private void jbtDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteItemActionPerformed
    new ItemDetail().setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_jbtDeleteItemActionPerformed

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
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
    }
    public void createConnection()
    {
        try
        {
             Class.forName("java.sql.DriverManager");   
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***Vet : Connection established.");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtAddItem;
    private javax.swing.JButton jbtDeleteItem;
    private javax.swing.JButton jbtUpdateItem;
    private javax.swing.JButton jbtView;
    private javax.swing.JComboBox<String> jcbItem;
    // End of variables declaration//GEN-END:variables
}
