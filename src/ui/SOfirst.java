package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import org.jdesktop.swingx.JXDatePicker;

public class SOfirst extends JFrame {

    private static String dbURL = "jdbc:derby://localhost:1527/FastestDelivery";
    private static Connection conn = null;
    private static PreparedStatement prepare;
    private static ResultSet rs = null;
    private List<Item> list = new ArrayList<>();
    private List<Item> orderedList = new ArrayList<>();
    private JLabel totalItemOrder = new JLabel();
    private JPanel pnlMain = new JPanel(new GridLayout(2, 1));
    private JPanel pnlOrderDetails = new JPanel(new GridLayout(5, 2));
    private JPanel menuListing = new JPanel(new GridLayout(list.size(), 3));
    private JPanel southPanel = new JPanel(new GridLayout(1, 2));
    private JPanel[] pnlItemListing = new JPanel[list.size()];
    private JScrollPane jsp1 = new JScrollPane(menuListing, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JLabel jlblTitle = new JLabel("Make Schedule Order");
    private JLabel jlblLocation = new JLabel("Location");
    private JLabel jlblRestaurant = new JLabel("Restaurant");
    private JLabel[] itemName = new JLabel[list.size()];
    private JLabel[] itemPrice = new JLabel[list.size()];
    private JLabel jlblDeliveryDate = new JLabel("Date");
    private JLabel jlblDeliveryTime = new JLabel("Time");
    private JLabel jlblDisplayDate = new JLabel();
    private JLabel jlblDisplayTime = new JLabel();
    private JComboBox jcbLocation = new JComboBox();
    private JComboBox jcbRestaurant = new JComboBox();

    public void placeOrder(String deliveryDate, String deliveryTime) {
        initializeComponent();
        updateOrderedItem();
        jlblDisplayDate.setText(deliveryDate);
        jlblDisplayTime.setText(deliveryTime);
        menuListing.setVisible(false);
        //jlabel declaration

        jcbRestaurant.setVisible(false);

        jcbLocation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jcbRestaurant.setVisible(true);
            }
        });

        JButton[] jbtOrder = new JButton[list.size()];
        JButton jbtSearch = new JButton("Search");
        JButton jbtCheckout = new JButton("Checkout");
        JButton jbtClear = new JButton("Clear");
        jbtCheckout.setLayout(new FlowLayout(FlowLayout.RIGHT));

        jbtSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jcbLocation.getSelectedIndex() != 0 && jcbRestaurant.getSelectedIndex() != 0) {
                    menuListing.setVisible(true);
                } else {
                    menuListing.setVisible(false);
                }
            }
        });

        //settings
        Font font = new Font("Serif", Font.BOLD, 25);
        jlblTitle.setFont(font);
        for (int i = 0; i < list.size(); i++) {
            itemName[i] = new JLabel(list.get(i).getItemName());
            itemPrice[i] = new JLabel(list.get(i).getItemPrice().toString());
            jbtOrder[i] = new JButton("Place order");

            pnlItemListing[i] = new JPanel(new GridLayout(1, list.size()));
            pnlItemListing[i].setBorder(BorderFactory.createLineBorder(Color.RED));
            pnlItemListing[i].add(itemName[i]);
            pnlItemListing[i].add(itemPrice[i]);
            pnlItemListing[i].add(jbtOrder[i]);
            menuListing.add(pnlItemListing[i]).setPreferredSize(new Dimension(600, 50));

            final JLabel name = itemName[i];
            final JLabel price = itemPrice[i];
            final JButton jbtO = jbtOrder[i];
            jbtOrder[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtO.setEnabled(false);
                    orderedList.add(new Item(name.getText(), Double.parseDouble(price.getText())));
                    updateOrderedItem();
                }
            });
        }
        JPanel nPanel = new JPanel();
        pnlOrderDetails.add(jlblDeliveryDate);
        pnlOrderDetails.add(jlblDisplayDate);
        pnlOrderDetails.add(jlblDeliveryTime);
        pnlOrderDetails.add(jlblDisplayTime);
        pnlOrderDetails.add(jlblLocation);
        pnlOrderDetails.add(jcbLocation).setPreferredSize(new Dimension(350, 40));
        pnlOrderDetails.add(jlblRestaurant);
        pnlOrderDetails.add(jcbRestaurant).setPreferredSize(new Dimension(350, 40));
        pnlOrderDetails.add(jbtClear);
        pnlOrderDetails.add(jbtSearch);
        nPanel.add(pnlOrderDetails);

        JPanel centerPanel = new JPanel();
        centerPanel.add(jsp1).setPreferredSize(new Dimension(1000, 290));

        JPanel sPanel = new JPanel();
        southPanel.add(totalItemOrder);
        southPanel.add(jbtCheckout).setPreferredSize(new Dimension(200, 30));
        sPanel.add(southPanel);

        pnlMain.add(nPanel);
        pnlMain.add(centerPanel);
        add(pnlMain, BorderLayout.CENTER);
        add(jlblTitle, BorderLayout.NORTH);
        add(sPanel, BorderLayout.SOUTH);

        jbtCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SOsecond sp = new SOsecond();
                sp.displayOrderedItem(orderedList);
            }
        });

        setSize(1100, 700);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void initializeComponent() {
        jcbLocation.addItem("-- Select --");
        jcbRestaurant.addItem("-- Select --");
        if (connection() == true) {
            try {
                prepare = conn.prepareStatement("SELECT DISTINCT CITY FROM POSTALCODES ORDER BY CITY");
                rs = prepare.executeQuery();

                while (rs.next()) {
                    jcbLocation.addItem(rs.getString(1));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean connection() {
        boolean isSuccess = false;

        try {
            conn = DriverManager.getConnection(dbURL, "chong", "abc123.");
            if (conn != null) {
                isSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return isSuccess;
    }

    public void updateOrderedItem() {
        totalItemOrder.setText("Total Item(s) Ordered: " + String.valueOf(orderedList.size()));
    }

    public static void main(String[] args) {
        SOfirst mp = new SOfirst();
    }

}
