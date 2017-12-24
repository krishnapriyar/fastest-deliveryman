package ModuleD.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Chew Chien Seng
 */
public class DMMainMenu extends JFrame{
    private Font font = new Font("Arial", Font.PLAIN, 20);
     
    public DMMainMenu(){
        
        JPanel jpnCenter1 = new JPanel(new GridLayout(1,2));
        JPanel jpnCenter2 = new JPanel();
        JPanel jpnSouth1 = new JPanel(new GridLayout(1,2));
        
        JComboBox jcbDMList = new JComboBox();
        
        JLabel jlblPageTitle = new JLabel("Delivery Man Menu");
        JLabel jlblDmTitle = new JLabel("Select a delivery man");
        JButton jbtCheckTodayOrder = new JButton("Check Today's Order");
        JButton jbtBack = new JButton("Back");
        
        jlblPageTitle.setFont(font);
        jcbDMList.setFont(font);
        jlblDmTitle.setFont(font);
        jbtCheckTodayOrder.setFont(font);
        jbtBack.setFont(font);
        
      

        jbtCheckTodayOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        
        jbtBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        
        jpnSouth1.add(jbtCheckTodayOrder);
        jpnSouth1.add(jbtBack);
        jpnCenter2.add(jpnCenter1);
        
        add(jlblPageTitle, BorderLayout.NORTH);
        add(jpnCenter2, BorderLayout.CENTER);
        add(jpnSouth1, BorderLayout.SOUTH);
        
        setSize(600,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Delivery Man Main Menu");
    }
    
    public static void main(String[] args){
        new DMMainMenu();
    }
    
}
