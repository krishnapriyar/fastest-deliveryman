package ModuleE.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author chong kun ming RSD 3
 *
 */
public class CustomerMainMenu extends JFrame {

    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static java.sql.Connection conn = null;
    private static java.sql.PreparedStatement prepare;
    private static java.sql.ResultSet rs = null;
    private JPanel jpnPanel1 = new JPanel(new GridLayout(1, 2));
    private JPanel jpnPanel2 = new JPanel(new GridLayout(3, 2));
    private int custID;
    public ModuleE.entity.ListClass arrList = new ModuleE.entity.ListClass();
    
    public CustomerMainMenu() {
        
    }
    
    public CustomerMainMenu(ModuleE.entity.ListClass arrClass, String username) {
        arrList = arrClass;
        getCustInfo(username);
        
        JButton jbtMakeOrder = new JButton("Make order");
        JButton jbtMakeScheduleOrder = new JButton("Make Schedule Order");
        JButton jbtViewScheduledOrder = new JButton("View My Order");
        JButton jbtTrackOrder = new JButton("Track my order");
        JButton jbtLogout = new JButton("Logout");
        JLabel jlblTitle = new JLabel("Customer Main Menu");
        
        java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.PLAIN, 20);
        jlblTitle.setFont(font);
        jbtMakeOrder.setFont(font);
        jbtMakeScheduleOrder.setFont(font);
        jbtViewScheduledOrder.setFont(font);
        jbtTrackOrder.setFont(font);
        jbtLogout.setFont(font);
        
        jbtMakeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            }
        });
        
        jbtViewScheduledOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                SOViewMyOrder view = new SOViewMyOrder();
                
                view.pageContent(arrClass, custID, username);
                CustomerMainMenu.this.setVisible(false);
            }
        });
        
        jbtMakeScheduleOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                SOSelectDateTime makeBooking = new SOSelectDateTime();
                makeBooking.makeScheduleOrder(arrClass, custID, username);
                CustomerMainMenu.this.setVisible(false);
            }
        });
        
        jbtLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ui.LoginFrame login = new ui.LoginFrame();
                login.setListClass(arrList);
                login.setVisible(true);
                CustomerMainMenu.this.setVisible(false);
            }
        });
        
        JPanel jpn3 = new JPanel();
        jpnPanel2.add(jbtMakeOrder);
        jpnPanel2.add(jbtMakeScheduleOrder);
        jpnPanel2.add(jbtTrackOrder);
        jpnPanel2.add(jbtViewScheduledOrder);
        jpnPanel2.add(jbtLogout);
        jpn3.add(jpnPanel2);
        
        add(jlblTitle, BorderLayout.NORTH);
        add(jpn3, BorderLayout.CENTER);
        
        setTitle("Customer Main Menu");
        setSize(600, 300);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    private void getCustInfo(String username) {
        if (connection() == true) {
            try {
                arrList.getCustList().clearList();
                prepare = conn.prepareStatement("SELECT * FROM CUSTOMER");
                rs = prepare.executeQuery();
                
                while (rs.next()) {
                    if (rs.getString(2).replace(" ", "").equalsIgnoreCase(username)) {
                        custID = rs.getInt(1);
                        arrList.getCustList().addNewItem(new ModuleE.entity.Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                    }                    
                }
                
            } catch (SQLException ex) {
            }
            
        }
    }
    
    private boolean connection() {
        boolean isSuccess = false;
        
        try {
            conn = java.sql.DriverManager.getConnection(dbURL);
            if (conn != null) {
                isSuccess = true;
            }
        } catch (SQLException ex) {
        }
        
        return isSuccess;
    }
}
