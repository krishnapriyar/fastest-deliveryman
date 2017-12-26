package ModuleE.ui;

import ModuleB.entity.Deliveryman;
import ModuleD.ui.DeliverymanClockInOut;
import ModuleE.entity.ListGetterSetter;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author chong kun ming RSD 3
 */
public class DMMainMenuUI extends JFrame {

    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static java.sql.Connection conn = null;
    private static  java.sql.PreparedStatement prepare;
    private static java.sql.ResultSet rs = null;
    static ListGetterSetter arrClass = new ListGetterSetter();
    private java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.PLAIN, 20);
    private int dmID = 0;
    private JLabel jlblDMName = new JLabel();
    private String username;
    
    public void setData(ListGetterSetter arrList, String name) {
        arrClass = arrList;
        username = name;

        getDMInfo(username);
        JPanel jpnSouth1 = new JPanel(new java.awt.GridLayout(2, 2));
        
        JLabel jlblPageTitle = new JLabel("Delivery Man Menu");
        JButton jbtCheckTodayOrder = new JButton("Check Today's Order");
        JButton jbtClockInOut = new JButton("Clock In and Out");   
        JButton jbtLogout = new JButton("Logout");
        
        jlblDMName.setFont(font);
        jlblPageTitle.setFont(font);
        jbtCheckTodayOrder.setFont(font);
        jbtLogout.setFont(font);
        jbtClockInOut.setFont(font);

        jbtCheckTodayOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ViewTodayTaskUI so = new ViewTodayTaskUI(arrClass, dmID);
                DMMainMenuUI.this.setVisible(false);
            }
        });

        jbtLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ui.LoginFrame login = new ui.LoginFrame();
                login.setListClass(arrClass);
                login.setVisible(true);
                DMMainMenuUI.this.setVisible(false);
            }
        });
        
        jbtClockInOut.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
            
               new DeliverymanClockInOut().setVisible(true);
                DMMainMenuUI.this.setVisible(false);
            }
        });

        jpnSouth1.add(jbtCheckTodayOrder);
        jpnSouth1.add(jbtLogout);
        jpnSouth1.add(jbtClockInOut);

        add(jlblPageTitle, BorderLayout.NORTH);
        add(jlblDMName, BorderLayout.CENTER);
        add(jpnSouth1, BorderLayout.SOUTH);

        setSize(600, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Delivery Man Main Menu");
    }

    private void getDMInfo(String username) {
        if (connection() == true) {
            try {
                arrClass.getCustList().clearList();
                prepare = conn.prepareStatement("SELECT * FROM DELIVERYMAN");
                rs = prepare.executeQuery();

                while (rs.next()) {
                    if (rs.getString(2).replace(" ", "").equalsIgnoreCase(username)) {
                        dmID = rs.getInt(1);
                        jlblDMName.setText("Welcome "+rs.getString(2));
                        arrClass.getDmList().addNewItem(new Deliveryman(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return isSuccess;
    }

}
