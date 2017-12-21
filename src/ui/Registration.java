/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import adt.*;
import entity.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Lysan Chen
 */
public class Registration extends java.awt.Frame {
    
       entity.Restaurant restaurant = new entity.Restaurant();
       LinkedList<entity.Restaurant> restaurantList = new LinkedList();
    
       String BussName, BussRegNo, address, password, userName, Person, GPSCo, email;
        int TelNo, affID, GSTRegNo;
    
       String dbURL = "jdbc:derby://localhost:1527/Fast"; 

        Connection dbCon = null; 
        PreparedStatement stmt = null; 
        ResultSet rs = null;
    
    public Registration() {
        initComponents();
        autogenID();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpPass = new javax.swing.JPasswordField();
        jtfID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jtfTel = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jtfAdd1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfBussRegNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfPerson = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfGPS = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfRegNum = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jlblAdd1 = new javax.swing.JLabel();
        jlblAdd2 = new javax.swing.JLabel();
        jlblPost = new javax.swing.JLabel();
        jtfAdd2 = new javax.swing.JTextField();
        jlblCity = new javax.swing.JLabel();
        jtfCity = new javax.swing.JTextField();
        jtfPost = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Affiliate ID : ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 79, 47));

        jLabel2.setText("Password :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 79, 41));

        jpPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpPassActionPerformed(evt);
            }
        });
        add(jpPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 220, -1));

        jtfID.setEnabled(false);
        jtfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIDActionPerformed(evt);
            }
        });
        add(jtfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 123, 216, -1));

        jLabel3.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel3.setText("Register as a Affiliate");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 23, 223, 50));

        jLabel4.setText("Business Name :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 119, 111, 32));

        jLabel5.setText("Contact Number :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jtfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNameActionPerformed(evt);
            }
        });
        add(jtfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 195, -1));
        add(jtfTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 200, -1));

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 100, 47));

        jLabel8.setText("Username :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, -1));
        add(jtfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 216, -1));
        add(jtfAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 200, 20));

        jLabel9.setText("Business Register Number :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 190, -1));
        add(jtfBussRegNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 195, -1));

        jLabel10.setText("Person In Charged :");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 153, 24));
        add(jtfPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 220, -1));

        jLabel11.setText("GPS Coordinates : ");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, -1, -1));
        add(jtfGPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 220, -1));

        jLabel12.setText("Recovery Email :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, -1));
        add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 220, -1));

        jLabel7.setText("GST Register Number :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jtfRegNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfRegNumActionPerformed(evt);
            }
        });
        add(jtfRegNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 200, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, 10, 20));

        jlblAdd1.setText("Address Line 1:");
        jlblAdd1.setName(""); // NOI18N
        add(jlblAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 95, -1));

        jlblAdd2.setText("Address Line 2:");
        jlblAdd2.setName(""); // NOI18N
        add(jlblAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 95, -1));

        jlblPost.setText("Postal Code :");
        jlblPost.setName(""); // NOI18N
        add(jlblPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 95, -1));
        add(jtfAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 200, -1));

        jlblCity.setText("City :");
        jlblCity.setName(""); // NOI18N
        add(jlblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 44, 20));
        add(jtfCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 200, -1));

        jtfPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPostActionPerformed(evt);
            }
        });
        add(jtfPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 200, -1));

        jButton2.setText("Back To Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, 130, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void jtfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIDActionPerformed

    private void jpPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpPassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
       BussName = jtfName.getText();
       BussRegNo = jtfBussRegNo.getText();
       address = jtfAdd1.getText() +"|"+ jtfAdd2.getText() +"|"+jtfPost.getText()+"|"+ jtfCity.getText();
       userName = jtfUsername.getText();
       password = jpPass.getText();
       Person = jtfPerson.getText();
       GPSCo = jtfGPS.getText();
       email = jtfEmail.getText();
       TelNo = Integer.parseInt(jtfTel.getText());
       affID = Integer.parseInt(jtfID.getText());
       GSTRegNo = Integer.parseInt(jtfBussRegNo.getText());;
       
       restaurant.setAffID(affID);
       restaurant.setBussName(BussName);
       restaurant.setAddress(address);
       restaurant.setBussRegNo(BussRegNo);
       restaurant.setGstRegNo(GSTRegNo);
       restaurant.setPersonInCharged(BussName);
       restaurant.setTelNo(TelNo);
       restaurant.setGPS(GPSCo);
       
       restaurantList.add(restaurant);
      
       
        try{
        
//        Class.forName("com.mysql.jdbc.Driver"); 
        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        Connection conn = DriverManager.getConnection(dbURL);
//        stmt = conn.createStatement();
//        String str = "INSERT INTO ITEM " + "VALUES (" + itemID +",'"+ itemName +"','"+category +"',"+ price +",'"+ promoInfo +"');";
//        stmt.executeUpdate(str) ;

        
            String insertStr = "INSERT INTO AFFILIATE VALUES(?,?,?,?,?,?,?,?)";

            stmt = conn.prepareStatement(insertStr);
            stmt.setInt(1, affID);
            stmt.setString(2, BussName);
            stmt.setString(3, BussRegNo);
            stmt.setInt(4,GSTRegNo);
            stmt.setString(5, Person);       
            stmt.setString(6, address);    
            stmt.setInt(7, TelNo);           
            stmt.setString(8, "123.45");
            stmt.executeUpdate();
            stmt.close();
            
            insertStr = "INSERT INTO LOGINACCOUNT VALUES(?,?,?)";
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, "a"+userName);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.executeUpdate();   
            JOptionPane.showMessageDialog(null,"Login Account added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            autogenID();
            
     
    }catch (Exception ex){
        JOptionPane.showMessageDialog(null,ex.getMessage(),"Failed", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNameActionPerformed

    private void jtfRegNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfRegNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfRegNumActionPerformed

    private void jtfPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPostActionPerformed
        // TODO add your handling code here:
        //Automatically fill city
        String postcode = jtfPost.getText();
        if(postcode.length()==5){

            try{
                DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
                Connection conn = DriverManager.getConnection(dbURL);

                String queryStr="SELECT CITY FROM  POSTALCODES WHERE POSTALCODE = ?";

                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1,postcode);
                ResultSet rs = stmt.executeQuery();

                if(rs.next())
                {
                    jtfCity.setText(rs.getString(1));

                }

            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }
    }//GEN-LAST:event_jtfPostActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for(int i = 0;i<restaurantList.getNumberOfEntries();i++)
        {
             try {

//        Class.forName("com.mysql.jdbc.Driver"); 
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection conn = DriverManager.getConnection(dbURL);
//        stmt = conn.createStatement();
//        String str = "INSERT INTO ITEM " + "VALUES (" + itemID +",'"+ itemName +"','"+category +"',"+ price +",'"+ promoInfo +"');";
//        stmt.executeUpdate(str) ;

            String insertStr = "INSERT INTO  ITEM   VALUES(?,?,?,?,?,?)";

            stmt = conn.prepareStatement(insertStr);

            stmt.setInt(1, restaurantList.getEntry(i).getAffID());
            stmt.setString(2, restaurantList.getEntry(i).getAddress());
            stmt.setString(3, restaurantList.getEntry(i).getBussName());
            stmt.setInt(4, restaurantList.getEntry(i).getAffID());
            stmt.setString(5, restaurantList.getEntry(i).getBussRegNo());
            stmt.setString(6, restaurantList.getEntry(i).getGPS());
            stmt.setString(7, restaurantList.getEntry(i).getPersonInCharged());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Affiliate Register successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            autogenID();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Failed", JOptionPane.ERROR_MESSAGE);
        }
            
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }
    
    private void autogenID(){
        
        int ID= 30001;
        
        try{
                DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
                Connection conn = DriverManager.getConnection(dbURL);
                
                String queryStr="SELECT MAX(AFFID) FROM  AFFILIATE";

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlblAdd1;
    private javax.swing.JLabel jlblAdd2;
    private javax.swing.JLabel jlblCity;
    private javax.swing.JLabel jlblPost;
    private javax.swing.JPasswordField jpPass;
    private javax.swing.JTextField jtfAdd1;
    private javax.swing.JTextField jtfAdd2;
    private javax.swing.JTextField jtfBussRegNo;
    private javax.swing.JTextField jtfCity;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfGPS;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPerson;
    private javax.swing.JTextField jtfPost;
    private javax.swing.JTextField jtfRegNum;
    private javax.swing.JTextField jtfTel;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
