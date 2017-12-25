package ModuleE.ui;

import ModuleE.entity.*;
import ModuleE.adt.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import javax.swing.DefaultListModel;
import javax.swing.*;

/**
 *
 * @author chong kun ming RSD 3
 */

public class MakeNewOrderUI extends JFrame {

    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static java.sql.Connection conn = null;
    private static java.sql.PreparedStatement prepare;
    private static java.sql.ResultSet rs = null;

    private myListInterface<RestaurantClass> resList = new ListImplementation<>();
    private myListInterface<OrderedItemClass> orderedList = new ListImplementation<>();
    private JPanel pnlMain = new JPanel(new GridLayout(1, 1));
    private JPanel pnlOrderDetails = new JPanel(new GridLayout(6, 2));
    private DefaultListModel model = new DefaultListModel();
    private JPanel southPanel = new JPanel(new GridLayout(1, 1));
    private JLabel jlblTitle = new JLabel("Make Schedule Order");
    private JLabel jlblState = new JLabel("State");
    private JLabel jlblCity = new JLabel("City");
    private JLabel jlblRestaurant = new JLabel("Restaurant");
    private JLabel jlblDeliveryDate = new JLabel("Date to Receive");
    private JLabel jlblDeliveryTime = new JLabel("Time to Receive");
    private JLabel jlblDisplayDate = new JLabel();
    private JLabel jlblDisplayTime = new JLabel();
    private JComboBox jcbState = new JComboBox();
    private JComboBox jcbCity = new JComboBox();
    private JComboBox jcbRestaurant = new JComboBox();
    private Font displayFont = new Font("Arial", Font.PLAIN, 20);

    public void placeOrder() {
    }

    public void orderPage(ListGetterSetter arrClass, int custID, String deliveryDate, String deliveryTime, String userName) {

        initializeComponent();
        jlblDisplayDate.setText(deliveryDate);
        jlblDisplayTime.setText(deliveryTime);

        JButton jbtSearch = new JButton("Get Menu");
        JButton jbtCheckout = new JButton("View Ordered Item(s)");
        JButton jbtClear = new JButton("Clear Menu List");
        jbtCheckout.setLayout(new FlowLayout(FlowLayout.RIGHT));

        jcbState.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jcbState.getSelectedItem().toString().equals("-- Select --")) {
                    jcbCity.enable(false);
                } else {
                    getCity(jcbState.getSelectedItem().toString());
                    jcbCity.enable(true);
                }
            }
        });

        jcbCity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jcbCity.getSelectedItem().toString().equals("-- Select --")) {
                    jcbRestaurant.removeAllItems();
                    jcbRestaurant.enable(false);
                } else {
                    jcbRestaurant.removeAllItems();
                    getRestaurant(jcbCity.getSelectedItem().toString());
                    jcbRestaurant.enable(true);
                }
            }
        });

        //search button action listener
        jbtSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jcbState.getSelectedIndex() != 0 && jcbCity.getSelectedIndex() != 0 && jcbRestaurant.getSelectedIndex() != -1) {
                    for (int i = 0; i < resList.getSize(); i++) {
                        if (jcbRestaurant.getSelectedItem().toString().equals(resList.getAllData(i).getResName())) {  
                           
                            MenuListingUI listingPage = new MenuListingUI();
                            listingPage.setListClass(arrClass);
                            listingPage.ItemListingPage(resList.getAllData(i).getResID());
                            arrClass.setItemlist(orderedList);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Choose your preference state, city and restaurant to get Menu !");
                }
            }
        });

        jbtClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                orderedList.clearList();
            }
        });

        jbtCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (orderedList.getSize() < 1) {
                    JOptionPane.showMessageDialog(null, "You do not have order any item !");
                } else {
                    new SelectedItemListingUI().displayOrderedItem(arrClass, custID, deliveryDate, deliveryTime, userName);
                    MakeNewOrderUI.this.setVisible(false);
                }
            }
        });

        Font font = new Font("Arial", Font.BOLD, 25);
        jlblTitle.setFont(font);

        jlblDeliveryDate.setFont(displayFont);
        jlblDisplayDate.setFont(displayFont);
        jlblDeliveryTime.setFont(displayFont);
        jlblDisplayTime.setFont(displayFont);
        jlblState.setFont(displayFont);
        jcbState.setFont(displayFont);
        jlblCity.setFont(displayFont);
        jcbCity.setFont(displayFont);
        jlblRestaurant.setFont(displayFont);
        jcbRestaurant.setFont(displayFont);
        jbtClear.setFont(displayFont);
        jbtSearch.setFont(displayFont);

        JPanel nPanel = new JPanel();
        pnlOrderDetails.add(jlblDeliveryDate);
        pnlOrderDetails.add(jlblDisplayDate);
        pnlOrderDetails.add(jlblDeliveryTime);
        pnlOrderDetails.add(jlblDisplayTime);
        pnlOrderDetails.add(jlblState);
        pnlOrderDetails.add(jcbState).setPreferredSize(new Dimension(350, 40));
        pnlOrderDetails.add(jlblCity);
        pnlOrderDetails.add(jcbCity).setPreferredSize(new Dimension(350, 40));
        pnlOrderDetails.add(jlblRestaurant);
        pnlOrderDetails.add(jcbRestaurant).setPreferredSize(new Dimension(350, 40));
        pnlOrderDetails.add(jbtClear);
        pnlOrderDetails.add(jbtSearch);
        nPanel.add(pnlOrderDetails);

        JPanel sPanel = new JPanel();
        southPanel.add(jbtCheckout).setPreferredSize(new Dimension(200, 30));
        sPanel.add(southPanel);

        pnlMain.add(nPanel);

        add(pnlMain, BorderLayout.NORTH);
        add(sPanel, BorderLayout.SOUTH);

        setTitle("Make Scheduled Order");
        setSize(1100, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void initializeComponent() {
        jcbState.addItem("-- Select --");
        jcbCity.enable(false);
        jcbRestaurant.enable(false);
        if (connection() == true) {
            try {
                prepare = conn.prepareStatement("SELECT DISTINCT STATE FROM POSTALCODES ORDER BY STATE");
                rs = prepare.executeQuery();

                while (rs.next()) {
                    jcbState.addItem(rs.getString(1));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void reset() {
        jcbRestaurant.removeAllItems();
        jcbRestaurant.enable(false);
        jcbRestaurant.addItem("-- Select --");
    }

    public boolean connection() {
        boolean isSuccess = false;

        try {
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                isSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return isSuccess;
    }

    public void getCity(String state) {
        jcbCity.addItem("-- Select --");
        if (connection() == true) {
            try {
                prepare = conn.prepareStatement("SELECT DISTINCT CITY FROM POSTALCODES WHERE STATE = '" + state + "' ORDER BY CITY");
                rs = prepare.executeQuery();
                while (rs.next()) {
                    jcbCity.addItem(rs.getString("CITY"));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fail to connect with database");
        }

    }

    public void getRestaurant(String cityName) {
        //jcbRestaurant.addItem("-- Select --");
        resList.clearList();
        if (connection() == true) {
            try {
                prepare = conn.prepareStatement("SELECT AFFID, BUSINESSNAME, ADDRESS FROM AFFILIATE WHERE AFFILIATE.ADDRESS LIKE '%" + cityName + "%'");
                rs = prepare.executeQuery();
                while (rs.next()) {
                    resList.addNewItem(new RestaurantClass(rs.getInt("AFFID"), rs.getString("BUSINESSNAME")));
                }

                if (resList.getSize() > 0) {
                    for (int i = 0; i < resList.getSize(); i++) {
                        jcbRestaurant.addItem(resList.getAllData(i).getResName());
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fail to connect with database");
        }
    }

}
