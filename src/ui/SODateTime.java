
package ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

public class SODateTime extends JFrame {
    
    public SODateTime()
    {
        //panel declaration
        JPanel jpnMain = new JPanel(new GridLayout(3,1));
        JPanel centerPanel = new JPanel(new GridLayout(2,2));
        JPanel timePanel = new JPanel(new GridLayout(1,3));
        JPanel centerPanel1 = new JPanel();
        
        //jlabel declaration
        JLabel jlblDate = new JLabel("Delivery Date");
        JLabel jlblTime = new JLabel("Delivery Time");
        
        //others control declaration
        JXDatePicker datePicker = new JXDatePicker();
        JComboBox hour = new JComboBox();
        JComboBox minutes = new JComboBox();
        JComboBox ampm = new JComboBox();
        JButton jbtProceed = new JButton("Proceed");
        
        for(int i=1; i<59;i++)
        {
            minutes.addItem(i);
        }
        
        for(int i=1; i<24;i++)
        {
            hour.addItem(i);
        }
        
        ampm.addItem("AM");
        ampm.addItem("PM");
        
        timePanel.add(hour);
        timePanel.add(minutes);
        timePanel.add(ampm);
               
        centerPanel.add(jlblDate);
        centerPanel.add(datePicker);
        centerPanel.add(jlblTime).setPreferredSize(new Dimension(350,90));
        centerPanel.add(timePanel).setPreferredSize(new Dimension(350,90));
        centerPanel1.add(centerPanel).setPreferredSize(new Dimension(350,90));
        jpnMain.add(new JLabel("Select Date and Time to receive your order"));
        jpnMain.add(centerPanel1);
        jpnMain.add(jbtProceed);
        add(jpnMain);
        
        jbtProceed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                SOfirst so = new SOfirst();         
            }
        });
        
        setVisible(true);
        setSize(900,500);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args)
    {
        SODateTime s = new SODateTime();
    }
}
