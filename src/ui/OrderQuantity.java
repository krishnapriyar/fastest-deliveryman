
package ui;

import ModuleE.entity.ScheduleOrderClass;
import ModuleE.entity.OrderedItemClass;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;


/**
 *
 * @author chong
 */
public class OrderQuantity extends JFrame{
    
    public double totalAmount = 0.0;
    public void displayOrderedItem(List<OrderedItemClass> orderedList)
    {
        //orderedList = new ArrayList<>();
        //JPanel declaration
        JPanel mainPanel = new JPanel(new GridLayout(2,1));
        JPanel[] itemOrderedListing = new JPanel[orderedList.size()];
        JPanel itemDetailListing = new JPanel(new GridLayout(orderedList.size(),5));
        JPanel southPanel = new JPanel(new GridLayout(1,2));
        
        JScrollPane jsp2 = new JScrollPane(itemDetailListing, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //JLabel declaration
        JLabel jlblTitle = new JLabel("Order Details");
        JLabel jlblTotalPrice = new JLabel();
        JLabel jlblTotalItem = new JLabel();
        
        Font font = new Font("Serif", Font.BOLD, 25);
        jlblTitle.setFont(font);
        
        //Controls declaration
        JButton jbtConfirm = new JButton("Confirm");
        JLabel[] jlblItemName = new JLabel[orderedList.size()];
        JLabel[] jlblItemPricePerItem = new JLabel[orderedList.size()];
        JSpinner[] qty = new JSpinner[orderedList.size()];
        JLabel[] totalPrice = new JLabel[orderedList.size()];
        JButton[] jbtRemove = new JButton[orderedList.size()];
        
        
        for(int i=0;i<orderedList.size();i++)
        {         
            jlblItemName[i] = new JLabel(orderedList.get(i).getItemName());
            jlblItemPricePerItem[i] = new JLabel(String.valueOf(orderedList.get(i).getItemPrice()));
            qty[i] = new JSpinner();
            totalPrice[i] = new JLabel("Total");
            jbtRemove[i] = new JButton("Remove Item");
            
            qty[i].setValue(1);
            
            itemOrderedListing[i] = new JPanel(new GridLayout(1, orderedList.size()));
            itemOrderedListing[i].setBorder(BorderFactory.createLineBorder(Color.RED));
            itemOrderedListing[i].add(jlblItemName[i]);
            itemOrderedListing[i].add(jlblItemPricePerItem[i]);
            itemOrderedListing[i].add(qty[i]);
            itemOrderedListing[i].add(totalPrice[i]);
            //itemOrderedListing[i].add(jbtRemove[i]);
            itemDetailListing.add(itemOrderedListing[i]);
            
            final JLabel itemPrice = jlblItemPricePerItem[i];
            final JSpinner itemQty = qty[i];
            final JLabel itemTotalPrice = totalPrice[i];
            itemTotalPrice.setText(String.valueOf(totalPrice(Integer.parseInt(itemQty.getValue().toString()),Double.parseDouble(itemPrice.getText()) )));
                       
            totalAmount+= Double.parseDouble(itemTotalPrice.getText());
            jlblTotalItem.setText("Total item(s) ordered : "+String.valueOf(orderedList.size()));
            jlblTotalPrice.setText("Total Amount : RM "+String.valueOf(totalAmount));

            qty[i].addChangeListener(new ChangeListener(){
                @Override
                public void stateChanged(ChangeEvent e) {
                    if(Integer.parseInt(itemQty.getValue().toString()) <= 0)
                    {
                        JOptionPane.showMessageDialog(null, "Quantity must be greater than 0 !");
                        itemQty.setValue(1);
                    }
                    else
                    {
                        itemTotalPrice.setText(String.valueOf(totalPrice(Integer.parseInt(itemQty.getValue().toString()),Double.parseDouble(itemPrice.getText())))); 
                        jlblTotalPrice.setText("Total Amount : RM "+String.valueOf(getTotalAmount(Double.parseDouble(itemPrice.getText()))));
                    }
                }
            });
        }
        jlblTotalItem.setFont(font);
        jlblTotalPrice.setFont(font);
        //add control to panel
        southPanel.add(jlblTotalItem);
        southPanel.add(jlblTotalPrice);
       
        jbtConfirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                List<ScheduleOrderClass> confirm = new ArrayList<>();
                for(int i=0 ; i <orderedList.size();i++)
                {
                    String itemName = jlblItemName[i].getText();
                    Double itemPrice = Double.parseDouble(jlblItemPricePerItem[i].getText());
                    Double totalAmount = Double.parseDouble(totalPrice[i].getText());
                    int quantity = Integer.parseInt(qty[i].getValue().toString());
                    
//                    confirm.add(new ViewMyOrderClass(itemName, itemPrice, totalAmount, quantity));
                }
                
                OrderConfirm sot = new OrderConfirm();
                sot.orderDetails(confirm);
            }
        });
        
        mainPanel.add(jsp2,BorderLayout.CENTER);
        mainPanel.add(southPanel);
        
        add(jlblTitle, BorderLayout.NORTH);
        add(jbtConfirm, BorderLayout.SOUTH);
        add(mainPanel);
        setSize(1100,650);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    public double getTotalAmount(double tPrice)
    {
        
        return totalAmount += tPrice;
    }
    
    public double totalPrice(int qty, double itemPrice)
    {
        return qty * itemPrice;
    }
    
    public static void main(String[] args)
    {
        OrderQuantity sp = new OrderQuantity();
    }
}
