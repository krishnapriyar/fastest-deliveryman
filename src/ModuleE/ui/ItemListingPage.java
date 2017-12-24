/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleE.ui;

import ModuleE.entity.OrderedItemClass;
import ModuleE.adt.ListImplementation;
import ModuleE.adt.myListInterface;
import ModuleE.entity.ListClass;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
 *
 * @author chong
 */
public class ItemListingPage extends JFrame {

    private myListInterface<OrderedItemClass> list = new ListImplementation<>();
    private myListInterface<OrderedItemClass> orderedlist = new ListImplementation<>();
    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static Connection conn = null;
    private PreparedStatement prepare = null;
    private PreparedStatement prepare2 = null;
    private ResultSet rs = null;
    private ResultSet rs2 = null;
    private JPanel topPanel = new JPanel(new GridLayout(2, 2));
    private JLabel jlblResName = new JLabel("Restaurant");
    private JLabel jlblResAdd = new JLabel("Address");
    private JLabel jlblShowResName = new JLabel();
    private JLabel jlblShowResAdd = new JLabel();
    private JButton jbtOK = new JButton("Ok");
    static ListClass arrClass = new ListClass();

    public void setListClass(ListClass listClass) {
        arrClass = listClass;
    }

    public void ItemListingPage(int restaurantID) {
        getRestaurantDetail(restaurantID);
        getItem(restaurantID);
        JPanel menuListing = new JPanel(new GridLayout(list.getSize(), 4));
        JPanel[] pnlItemListing = new JPanel[list.getSize()];
        JScrollPane jsp1 = new JScrollPane(menuListing, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JLabel[] itemID = new JLabel[list.getSize()];
        JLabel[] itemName = new JLabel[list.getSize()];
        JLabel[] itemPrice = new JLabel[list.getSize()];
        JButton[] jbtOrder = new JButton[list.getSize()];
        //settings
        Font font = new Font("Arial", Font.BOLD, 20);
        jlblResName.setFont(font);
        jlblResAdd.setFont(font);
        jlblShowResName.setFont(font);
        jlblShowResAdd.setFont(font);

        for (int i = 0; i < list.getSize(); i++) {
            itemName[i] = new JLabel(list.getAllData(i).getItemName());
            itemPrice[i] = new JLabel(list.getAllData(i).getItemPrice().toString());
            itemID[i] = new JLabel(String.valueOf(list.getAllData(i).getId()));
            jbtOrder[i] = new JButton("Place order");

            pnlItemListing[i] = new JPanel(new GridLayout(1, list.getSize()));
            pnlItemListing[i].setBorder(BorderFactory.createLineBorder(Color.RED));
            pnlItemListing[i].add(itemID[i]);
            pnlItemListing[i].add(itemName[i]);
            pnlItemListing[i].add(itemPrice[i]);
            pnlItemListing[i].add(jbtOrder[i]);
            menuListing.add(pnlItemListing[i]).setPreferredSize(new Dimension(600, 50));

            final JLabel id = itemID[i];
            final JLabel name = itemName[i];
            final JLabel price = itemPrice[i];
            final JButton jbtO = jbtOrder[i];
            jbtOrder[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    arrClass.getItemlist().addNewItem(new OrderedItemClass(Integer.parseInt(id.getText()), name.getText(), Double.parseDouble(price.getText())));
                }
            });
        }

        jbtOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ItemListingPage.this.setVisible(false);
            }
        });

        topPanel.add(jlblResName);
        topPanel.add(jlblShowResName);
        topPanel.add(jlblResAdd);
        topPanel.add(jlblShowResAdd);

        jbtOK.setPreferredSize(new Dimension(200, 50));
        add(topPanel, BorderLayout.NORTH);
        add(jsp1, BorderLayout.CENTER);
        add(jbtOK, BorderLayout.SOUTH);

        setVisible(true);
        setSize(1100, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    private void getRestaurantDetail(int restaurantID) {

        if (connection() == true) {
            try {
                prepare = conn.prepareStatement("SELECT * FROM AFFILIATE WHERE AFFID = " + restaurantID);
                rs = prepare.executeQuery();
                if (rs.next()) {
                    jlblShowResName.setText(rs.getString("BUSINESSNAME"));
                    jlblShowResAdd.setText(rs.getString("ADDRESS"));
                }
          
            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
        }

    }
    
    private void getItem(int resID){
        if(connection() == true){
            try{
                prepare = conn.prepareStatement("SELECT * FROM ITEM WHERE AFFID = " + resID);
                rs = prepare.executeQuery();
                while (rs.next()) {
                    list.addNewItem(new OrderedItemClass(rs.getInt("ITEMID"), rs.getString("ITEMNAME"), rs.getDouble("ITEMUNITPRICE")));
                }
                
            }catch(Exception ex){
                System.out.println(ex.getCause().toString());
            }
        }
    }

    private boolean connection() {
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

}
