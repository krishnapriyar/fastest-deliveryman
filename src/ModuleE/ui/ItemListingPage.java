package ModuleE.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author chong kun ming
 */
public class ItemListingPage extends JFrame {

    private ModuleE.adt.myListInterface<ModuleE.entity.OrderedItemClass> list = new ModuleE.adt.ListImplementation<>();
    private ModuleE.adt.myListInterface<ModuleE.entity.OrderedItemClass> orderedlist = new ModuleE.adt.ListImplementation<>();
    private static String dbURL = "jdbc:derby://localhost:1527/Fast";
    private static java.sql.Connection conn = null;
    private java.sql.PreparedStatement prepare = null;
    private java.sql.ResultSet rs = null;
    private JPanel topPanel = new JPanel(new GridLayout(2, 2));
    private JLabel jlblResName = new JLabel("Restaurant");
    private JLabel jlblResAdd = new JLabel("Address");
    private JLabel jlblShowResName = new JLabel();
    private JLabel jlblShowResAdd = new JLabel();
    private JButton jbtOK = new JButton("Ok");
    static ModuleE.entity.ListClass arrClass = new ModuleE.entity.ListClass();

    public void setListClass(ModuleE.entity.ListClass listClass) {
        arrClass = listClass;
    }

    public void ItemListingPage(int restaurantID) {
        getRestaurantDetail(restaurantID);
        getItem(restaurantID);
        JPanel menuListing = new JPanel(new GridLayout(list.getSize(), 4));
        JPanel[] pnlItemListing = new JPanel[list.getSize()];
        javax.swing.JScrollPane jsp1 = new javax.swing.JScrollPane(menuListing, javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JLabel[] itemID = new JLabel[list.getSize()];
        JLabel[] itemName = new JLabel[list.getSize()];
        JLabel[] itemPrice = new JLabel[list.getSize()];
        JButton[] jbtOrder = new JButton[list.getSize()];
        //settings
        java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.BOLD, 20);
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
            pnlItemListing[i].setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED));
            pnlItemListing[i].add(itemID[i]);
            pnlItemListing[i].add(itemName[i]);
            pnlItemListing[i].add(itemPrice[i]);
            pnlItemListing[i].add(jbtOrder[i]);
            menuListing.add(pnlItemListing[i]).setPreferredSize(new java.awt.Dimension(600, 50));

            final JLabel id = itemID[i];
            final JLabel name = itemName[i];
            final JLabel price = itemPrice[i];
            final JButton jbtO = jbtOrder[i];
            jbtOrder[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    arrClass.getItemlist().addNewItem(new ModuleE.entity.OrderedItemClass(Integer.parseInt(id.getText()), name.getText(), Double.parseDouble(price.getText())));
                }
            });
        }

        jbtOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ItemListingPage.this.setVisible(false);
            }
        });

        topPanel.add(jlblResName);
        topPanel.add(jlblShowResName);
        topPanel.add(jlblResAdd);
        topPanel.add(jlblShowResAdd);

        jbtOK.setPreferredSize(new java.awt.Dimension(200, 50));
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
          
            } catch (java.sql.SQLException ex) {
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
                    list.addNewItem(new ModuleE.entity.OrderedItemClass(rs.getInt("ITEMID"), rs.getString("ITEMNAME"), rs.getDouble("ITEMUNITPRICE")));
                }
                
            }catch(java.sql.SQLException ex){
                System.out.println(ex.getCause().toString());
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
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
        }

        return isSuccess;
    }

}
