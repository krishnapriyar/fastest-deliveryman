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

    private static String dbURL = "jdbc:derby://localhost:1527/FastestDelivery;create=true;user=chong;password=abc123.";
    private static Connection conn = null;
    public List<Item> list = new ArrayList<>();
    public List<Item> orderedList = new ArrayList<>();
    public JLabel totalItemOrder = new JLabel();
    
    public SOfirst() {

        list.add(new Item("Nasi Goreng", 10.0));
        list.add(new Item("Nasi Goreng Lakna", 9.0));
        list.add(new Item("Mee Goreng", 8.5));
        list.add(new Item("Maggi Goreng", 9.0));
        list.add(new Item("Roti Telur", 15.0));
        list.add(new Item("Koren Ramen", 2.0));
        list.add(new Item("Dry Meat", 6.0));
        list.add(new Item("Donut", 1.0));

        updateOrderedItem();
        //jpanel declaration
        JPanel pnlMain = new JPanel(new GridLayout(2, 1));
        JPanel pnlOrderDetails = new JPanel(new GridLayout(3, 2));
        JPanel menuListing = new JPanel(new GridLayout(list.size(), 3));
        JPanel southPanel = new JPanel(new GridLayout(1, 2));

        JPanel[] pnlItemListing = new JPanel[list.size()];
        JScrollPane jsp1 = new JScrollPane(menuListing, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        menuListing.setVisible(false);
        //jlabel declaration
        JLabel jlblTitle = new JLabel("Make Schedule Order");
        JLabel jlblLocation = new JLabel("Location");
        JLabel jlblRestaurant = new JLabel("Restaurant");
        JLabel[] itemName = new JLabel[list.size()];
        JLabel[] itemPrice = new JLabel[list.size()];

        //controls declaration
        JComboBox jcbLocation = new JComboBox();
        JComboBox jcbRestaurant = new JComboBox();

        jcbLocation.addItem("--Select--");
        jcbLocation.addItem("Kuala Lumpur");
        jcbLocation.addItem("Johor Bahru");
        jcbRestaurant.setVisible(false);

        jcbLocation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jcbRestaurant.setVisible(true);
            }
        });
        
        jcbRestaurant.addItem("--Select--");
        for (int i = 1; i < 3; i++) {
            jcbRestaurant.addItem("Restaurant " + i);
        }
       
        JButton[] jbtOrder = new JButton[list.size()];
        JButton jbtSearch = new JButton("Search");
        JButton jbtCheckout = new JButton("Checkout");
        JButton jbtClear = new JButton("Clear");
        jbtCheckout.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        jbtSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(jcbLocation.getSelectedIndex()!=0 && jcbRestaurant.getSelectedIndex() != 0)
                {
                    menuListing.setVisible(true);
                }
                else
                {
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

    public void updateOrderedItem() {
        totalItemOrder.setText("Total Item(s) Ordered: " + String.valueOf(orderedList.size()));
    }

    public static void main(String[] args) {
        SOfirst mp = new SOfirst();
    }
    
}
