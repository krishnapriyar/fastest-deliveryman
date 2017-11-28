
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.*;


public class SOCheckTodayOrder extends JFrame{
    private Queue<ScheduleOrderClass> queueItem = new ArrayBlockingQueue<ScheduleOrderClass>(1000);
    private static Connection conn = null;
    private static String dbURL = "jdbc:derby://localhost:1527/FastestDelivery";
    private static ResultSet rs;
    private static Statement stat;
    private static PreparedStatement prepare;
    
    public SOCheckTodayOrder()
    {
        getData();
        
        Date d = new Date();
        String DATE_FORMAT = "yyyy - MM - dd";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        
        //panel declaration
        JPanel jpnMain = new JPanel(new GridLayout(1,1));
        JPanel jpnTop = new JPanel(new GridLayout(1,2));
        JPanel jpnMiddle = new JPanel(new GridLayout(1,1));
        JPanel jpnScroll = new JPanel(new GridLayout(queueItem.size(),6));
        JPanel[] itemListing = new JPanel[queueItem.size()];
        JPanel jpna = new JPanel();
        JScrollPane scroll = new JScrollPane(jpna, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        //JLabel declaration
        JLabel jlblTitle = new JLabel("Today's Ordered Schedule");
        JLabel jlblTodayDate = new JLabel();
        JLabel[] jlblItemID = new JLabel[queueItem.size()];
        JLabel[] jlblCustomerName = new JLabel[queueItem.size()];
        JLabel[] jlblCustomerAddress = new JLabel[queueItem.size()];
        JLabel[] jlblCustomerTelephone = new JLabel[queueItem.size()];
        JLabel[] jlblTotalPrice = new JLabel[queueItem.size()];
        JLabel[] jlblDistance = new JLabel[queueItem.size()];
        JButton[] jbtOrderDetails = new JButton[queueItem.size()];
        
        Font font = new Font("Arial", Font.BOLD, 18);
        jlblTitle.setFont(font);
        jlblTodayDate.setFont(font);
        
        jlblTodayDate.setText(sdf.format(d));
        jpnMiddle.add(scroll).setPreferredSize(new Dimension(500,300));
       
        for(int i=0; i<= queueItem.size();i++)
        {
            ScheduleOrderClass sc = queueItem.poll();
            itemListing[i] = new JPanel(new GridLayout(queueItem.size(),7));
            jlblItemID[i] = new JLabel(String.valueOf(sc.getOrderID()));
            jlblCustomerName[i] = new JLabel(sc.getCustomerName());
            jlblCustomerAddress[i] = new JLabel(sc.getCustomerAddress());
            jlblCustomerTelephone[i] = new JLabel(sc.getTelNumber());
            jlblTotalPrice[i] = new JLabel(String.valueOf("RM "+ sc.getTotalPrice()));
            jbtOrderDetails[i] = new JButton("Check Items Ordered");
            jlblDistance[i] = new JLabel(String.valueOf(sc.getDistance()) + "KM");
            
            itemListing[i].add(jlblItemID[i]);
            itemListing[i].add(jlblCustomerName[i]);
            itemListing[i].add(jlblCustomerAddress[i]);
            itemListing[i].add(jlblCustomerTelephone[i]);
            itemListing[i].add(jlblTotalPrice[i]);
            itemListing[i].add(jlblDistance[i]).setPreferredSize(new Dimension(100,50));
            itemListing[i].add(jbtOrderDetails[i]);
            jpnScroll.add(itemListing[i]);
            jpna.add(jpnScroll);
            final JLabel jlblOrderID = jlblItemID[i];
         
            jbtOrderDetails[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                       JOptionPane.showMessageDialog(null, getOrderedItem(Integer.parseInt(jlblOrderID.getText())));
                }
            });
        }
        jpnTop.add(jlblTitle);
        jpnTop.add(jlblTodayDate);
        jpnMain.add(jpnMiddle);
        add(jpnTop, BorderLayout.NORTH);
        add(jpnMain, BorderLayout.CENTER);
        
        setSize(1400,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Check today's ordered");
    }
    
    public boolean connection()
    {
        boolean isSuccess = false;
        
        try
        {
            conn = DriverManager.getConnection(dbURL, "chong", "abc123.");
            if(conn != null)
            {
                isSuccess = true;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return isSuccess;
    }
    
    public String getOrderedItem(int orderID)
    {
        String str = "";
        
        if(connection() == true)
        {
            try
            {
                prepare = conn.prepareStatement("SELECT SCHEDULEORDERITEM.SCHEDULE_QUANTITY, ITEM.ITEMNAME FROM SCHEDULEORDERITEM LEFT JOIN ITEM ON SCHEDULEORDERITEM.ITEMID = ITEM.ITEMID WHERE SCHEDULEORDERITEM.SCHEDULE_ORDERID = ?");
                prepare.setInt(1, orderID);
                rs = prepare.executeQuery();
                
                while(rs.next())
                {
                    str += rs.getString(2)+" x "+rs.getInt(1) +"\n";                   
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return str;
    }
    
    public void getData()
    {
        if(connection() == true)
        {
            try
            {
                String sql = "SELECT SUM(SCHEDULEORDERITEM.SCHEDULE_QUANTITY * ITEM.ITEMUNITPRICE) AS TotalPrice, SCHEDULEORDER.SCHEDULE_ORDERID, CUSTOMER.CUSTNAME, CUSTOMER.CUSTADDRESS, CUSTOMER.CUSTTELNO, SCHEDULEORDER.DISTANCE FROM SCHEDULEORDER LEFT JOIN SCHEDULEORDERITEM ON SCHEDULEORDER.SCHEDULE_ORDERID = SCHEDULEORDERITEM.SCHEDULE_ORDERID LEFT JOIN ITEM ON SCHEDULEORDERITEM.ITEMID = ITEM.ITEMID LEFT JOIN CUSTOMER ON SCHEDULEORDER.CUSTOMERID = CUSTOMER.CUSTID GROUP BY SCHEDULEORDER.SCHEDULE_ORDERID, CUSTOMER.CUSTNAME,CUSTOMER.CUSTADDRESS, CUSTOMER.CUSTTELNO, SCHEDULEORDER.DISTANCE";
                stat = conn.createStatement();
                rs = stat.executeQuery(sql);
                
                while(rs.next())
                {
                    queueItem.add(new ScheduleOrderClass(rs.getInt(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getDouble(1), rs.getInt(6)));                                  
                }               
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
        SOCheckTodayOrder check = new SOCheckTodayOrder();
    }
}
