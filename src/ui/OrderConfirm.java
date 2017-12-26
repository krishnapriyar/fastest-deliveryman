
package ui;

import ModuleE.entity.ScheduleOrderClass;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OrderConfirm extends JFrame{
   
    public OrderConfirm()
    {
        
    }
    
    public void orderDetails(List<ScheduleOrderClass> list)
    {
        JPanel jpnMain = new JPanel(new GridLayout(3,1));
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel(new GridLayout(3,2));
        JPanel southPanel = new JPanel();
        Font font = new Font("Arial", Font.BOLD, 18);
        //JButton
        JButton jbtOK = new JButton("OK");
        
        
        //JLabel
        JLabel jlblTitle = new JLabel("Customer and order Details");
        JLabel jlblCustName = new JLabel("Customer Name");
        JLabel jlblCustPhone = new JLabel("Phone Number");
        JLabel jlblCustAddress = new JLabel("Delivery Address");
        JLabel jlblCustName1 = new JLabel("Touch n go");
        JLabel jlblCustPhone1 = new JLabel("018-7655899");
        JLabel jlblCustAddress1 = new JLabel("Jalan Genting Kelang, Prima Setapak Kuala Lumpur Malaysia");
        
        JTextArea jtextOrder = new JTextArea();
        
        jlblTitle.setFont(font);
        topPanel.add(jlblTitle);
        centerPanel.add(jlblCustName);
        centerPanel.add(jlblCustName1);
        centerPanel.add(jlblCustPhone);
        centerPanel.add(jlblCustPhone1);
        centerPanel.add(jlblCustAddress);
        centerPanel.add(jlblCustAddress1);
        southPanel.add(jtextOrder).setPreferredSize(new Dimension(750,200));
        
        String str = "";
        for(int i=0;i<list.size();i++)
        {
//            str += list.get(i).getItemName() +" * "+ list.get(i).getQty() +" = "+list.get(i).getTotalPrice()+"\n";
        }
        jtextOrder.setText(str);
        jtextOrder.setEditable(false);
        jtextOrder.setLineWrap(true);
        jtextOrder.setWrapStyleWord(true);
        jtextOrder.setFont(font);
        
        jpnMain.add(topPanel);
        jpnMain.add(centerPanel);
        jpnMain.add(southPanel);
        
        add(jpnMain);
        add(jbtOK, BorderLayout.SOUTH);
        
        setSize(800,650);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public static void main(String[] args)
    {
        OrderConfirm third = new OrderConfirm();
    }
}
