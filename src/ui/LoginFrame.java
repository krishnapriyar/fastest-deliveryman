/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Priya
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    String dbURL = "jdbc:derby://localhost:1527/Fast";

    Connection dbCon = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    JFrame frame;

    public LoginFrame() {
        initComponents();
        setTitle("Login - FastestDeliveryman");
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
        jlblUser = new javax.swing.JLabel();
        jlblPassword = new javax.swing.JLabel();
        jtfUser = new javax.swing.JTextField();
        jlblUserType = new javax.swing.JLabel();
        jcbUserType = new javax.swing.JComboBox<>();
        jtfTitle = new javax.swing.JLabel();
        jbtLogin = new javax.swing.JButton();
        jbtRegister = new javax.swing.JButton();
        jpfPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - Fastest Deliveryman");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblUser.setText("Username :");
        jPanel1.add(jlblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        jlblPassword.setText("Password :");
        jPanel1.add(jlblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));
        jPanel1.add(jtfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 220, -1));

        jlblUserType.setText("User Type :");
        jPanel1.add(jlblUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jcbUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Affliate", "Deliveryman", "HR Executive" }));
        jPanel1.add(jcbUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 220, -1));

        jtfTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtfTitle.setText("Login");
        jPanel1.add(jtfTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        jbtLogin.setText("Login");
        jbtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jbtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        jbtRegister.setText("Register As Affliate");
        jbtRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(jbtRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        jpfPass.setText("jPasswordField1");
        jPanel1.add(jpfPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLoginActionPerformed
        // TODO add your handling code here:
        char prefix = 'Z';
        String userType = jcbUserType.getSelectedItem().toString();
        

        switch (userType) {
            case "Customer":
                prefix = 'c';
                break;
            case "Affliate":
                prefix = 'a';
                break;
            case "Deliveryman":
                prefix = 'd';
                break;
            case "HR Executive":
                prefix = 'h';
                break;
        }

        if (compareLogin(prefix)) {

            goToMenu();
        }
    }//GEN-LAST:event_jbtLoginActionPerformed

    private void jbtRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRegisterActionPerformed
        // TODO add your handling code here:
        
       frame =  new Registration();
       
       frame.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jbtRegisterActionPerformed
    
    private void goToMenu(){
        switch (jcbUserType.getSelectedItem().toString()) {
            case "Customer":
                
                break;
            case "Affliate":
                frame = new CRUD();
                break;
            case "Deliveryman":
                
                break;
            case "HR Executive":
                frame = new HRExecMenu();
                break;
        }
        
        frame.setVisible(true);
        this.setVisible(false);
    
            
    }
    
    private boolean compareLogin(char prefix) {

        boolean allow = false;
        String user = prefix + jtfUser.getText();

        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection conn = DriverManager.getConnection(dbURL);

            String queryStr = "SELECT * FROM  LOGINACCOUNT WHERE USERNAME = ?";

            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String password = rs.getString("PASSWORD");
                allow = jpfPass.getPassword().equals(password.toCharArray());

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Please check and reenter your login credentials.", "Login Error", JOptionPane.ERROR_MESSAGE);

        }

        return allow;

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtLogin;
    private javax.swing.JButton jbtRegister;
    private javax.swing.JComboBox<String> jcbUserType;
    private javax.swing.JLabel jlblPassword;
    private javax.swing.JLabel jlblUser;
    private javax.swing.JLabel jlblUserType;
    private javax.swing.JPasswordField jpfPass;
    private javax.swing.JLabel jtfTitle;
    private javax.swing.JTextField jtfUser;
    // End of variables declaration//GEN-END:variables
}
