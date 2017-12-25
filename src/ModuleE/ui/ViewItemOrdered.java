
package ModuleE.ui;

import ModuleE.entity.*;
import ModuleE.adt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ViewItemOrdered extends JFrame{
    private myListInterface<ScheduledOrderItem> list = new ListImplementation<>();
    
    public ViewItemOrdered(){
    
    }
    
    public void pageContent(int scheduleOrderID, myListInterface<ScheduledOrderItem> orderItem, myListInterface<OrderedItemClass> itemlist){
        for(int i = 0 ; i < orderItem.getSize() ; i ++){
            if(scheduleOrderID == orderItem.getAllData(i).getScheduleOrderID()){
                list.addNewItem(new ScheduledOrderItem(orderItem.getAllData(i).getUnitPrice(), orderItem.getAllData(i).getQty(), orderItem.getAllData(i).getItemName(), orderItem.getAllData(i).getScheduleOrderID()));
            }
        }
        
        JPanel jpnWrap = new JPanel();
        JPanel[] itemOrderedListing = new JPanel[list.getSize()];
        JPanel itemDetailListing = new JPanel(new GridLayout(list.getSize(),4));
        JScrollPane jsp = new JScrollPane(jpnWrap, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JButton jbtOK = new JButton("OK");
        
        JLabel[] jlblItemName = new JLabel[list.getSize()];
        JLabel[] jlblItemQty = new JLabel[list.getSize()];
        JLabel[] jlblUnitPrice = new JLabel[list.getSize()];
        JLabel[] jlblItemNameTitle = new JLabel[list.getSize()];
        JLabel[] jlblItemQtyTitle = new JLabel[list.getSize()];
        JLabel[] jlblUnitPriceTitle = new JLabel[list.getSize()];
        
        JLabel jlblOrderID = new JLabel();
        Font titleFont = new Font("Arial", Font.BOLD, 20);
        Font displayFont = new Font("Arial", Font.PLAIN, 20);
        
        jlblOrderID.setText("View Item(s) Ordered");
        jlblOrderID.setFont(new Font("Arial", Font.BOLD, 28));
        
        for(int i=0; i < list.getSize(); i ++){
            jlblItemName[i] = new JLabel(list.getAllData(i).getItemName());
            jlblItemQty[i] = new JLabel(String.valueOf(list.getAllData(i).getQty()));
            jlblUnitPrice[i] = new JLabel(String.valueOf(list.getAllData(i).getUnitPrice()));
            
            jlblItemName[i].setFont(displayFont);
            jlblItemQty[i].setFont(displayFont);
            jlblUnitPrice[i].setFont(displayFont);
            
            jlblItemNameTitle[i] = new JLabel("Item Name");
            jlblItemQtyTitle[i] = new JLabel("Quantity");
            jlblUnitPriceTitle[i] = new JLabel("Unit Price");
            
            jlblItemNameTitle[i].setFont(titleFont);
            jlblItemQtyTitle[i].setFont(titleFont);
            jlblUnitPriceTitle[i].setFont(titleFont);
            
            itemOrderedListing[i] = new JPanel(new GridLayout(4, 2));
            
            itemOrderedListing[i].add(jlblItemNameTitle[i]);
            itemOrderedListing[i].add(jlblItemName[i]);
            
            itemOrderedListing[i].add(jlblUnitPriceTitle[i]);
            itemOrderedListing[i].add(jlblUnitPrice[i]);
            
            itemOrderedListing[i].add(jlblItemQtyTitle[i]);
            itemOrderedListing[i].add(jlblItemQty[i]);
            
            itemDetailListing.add(itemOrderedListing[i]);
            jpnWrap.add(itemDetailListing);
           
        }
        
        jbtOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ViewItemOrdered.this.setVisible(false);
            }
        });
        
        add(jlblOrderID, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
        add(jbtOK, BorderLayout.SOUTH);
        
        setSize(550,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("My Ordered Item(s)");
    }
    
}
