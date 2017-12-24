package ModuleE.ui;

import ModuleE.adt.ListImplementation;
import ModuleE.adt.myListInterface;
import ModuleE.entity.ListClass;
import ModuleE.entity.DeliveryManClass;
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
 * @author chong
 */
public class DMMainMenu extends JFrame {

    static ListClass arrClass = new ListClass();
    private Font font = new Font("Arial", Font.PLAIN, 20);

    public void setListClass(ListClass arrList) {
        arrClass = arrList;
    }

    public DMMainMenu(String username) {

        JPanel jpnCenter1 = new JPanel(new GridLayout(1, 2));
        JPanel jpnCenter2 = new JPanel();
        JPanel jpnSouth1 = new JPanel(new GridLayout(1, 2));

        JLabel jlblPageTitle = new JLabel("Delivery Man Menu");
        JButton jbtCheckTodayOrder = new JButton("Check Today's Order");
        JButton jbtBack = new JButton("Back");

        jlblPageTitle.setFont(font);
        jbtCheckTodayOrder.setFont(font);
        jbtBack.setFont(font);

        jbtCheckTodayOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                DMMainMenu.this.dispose();
            }
        });

        jbtBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        jpnSouth1.add(jbtCheckTodayOrder);
        jpnSouth1.add(jbtBack);

        jpnCenter2.add(jpnCenter1);

        add(jlblPageTitle, BorderLayout.NORTH);
        add(jpnCenter2, BorderLayout.CENTER);
        add(jpnSouth1, BorderLayout.SOUTH);

        setSize(600, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Delivery Man Main Menu");
    }

}
