package ui;

import adt.*;
import entity.*;
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
    static LinkedList<entity.RestaurantItem> itemList = new LinkedList();

    public void setItemList(LinkedList<RestaurantItem> itemList) {
        this.itemList = itemList;
    }

    public CRUD() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtView = new javax.swing.JButton();
        jbtAddItem = new javax.swing.JButton();
        jbtUpdateItem = new javax.swing.JButton();
        jbtDeleteItem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel2.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel2.setText("Manage Item");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtView)
                        .addGap(27, 27, 27)
                        .addComponent(jbtAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtUpdateItem)
                        .addGap(30, 30, 30)
                        .addComponent(jbtDeleteItem)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel2)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtView)
                    .addComponent(jbtAddItem)
                    .addComponent(jbtUpdateItem)
                    .addComponent(jbtDeleteItem))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jbtViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewActionPerformed
       ItemDetail  itemd = new ItemDetail('v');
       itemd.setVisible(true);
        this.setVisible(false);
        itemd.setCaller(this);
        itemd.setItemList(itemList);
//        jtfID.setEditable(false);

    }//GEN-LAST:event_jbtViewActionPerformed

    private void jbtAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddItemActionPerformed
        ItemDetail id=new ItemDetail('a');
        id.setVisible(true);
        id.setItemList(itemList);
        id.setCaller(this);
        this.setVisible(false);
    }//GEN-LAST:event_jbtAddItemActionPerformed

    private void jbtUpdateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateItemActionPerformed
        ItemDetail  itemd = new ItemDetail('u');
        itemd.setVisible(true);
        this.setVisible(false);
        itemd.setCaller(this);
        itemd.setItemList(itemList);


    }//GEN-LAST:event_jbtUpdateItemActionPerformed

    private void jbtDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteItemActionPerformed
        ItemDetail  itemd = new ItemDetail('d');
        itemd.setVisible(true);
        this.setVisible(false);
        itemd.setCaller(this);
        itemd.setItemList(itemList);
    }//GEN-LAST:event_jbtDeleteItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD().setVisible(true);
                
            }
        });
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

    public void createConnection() {
        try {
            Class.forName("java.sql.DriverManager");
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***Vet : Connection established.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtAddItem;
    private javax.swing.JButton jbtDeleteItem;
    private javax.swing.JButton jbtUpdateItem;
    private javax.swing.JButton jbtView;
    // End of variables declaration//GEN-END:variables
}
