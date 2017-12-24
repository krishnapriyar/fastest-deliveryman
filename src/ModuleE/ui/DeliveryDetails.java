
package ModuleE.ui;

import ModuleE.entity.ListClass;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author chong
 */
public class DeliveryDetails extends JFrame{
    private ListClass arrClass = new ListClass();
    private Font mainFont = new Font("Arial", Font.BOLD, 28);
    private Font titleFont = new Font("Arial", Font.BOLD, 19);
    private Font displayFont = new Font("Arial", Font.PLAIN, 19);
    private SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm aa");
    
    public DeliveryDetails(){
    
    }
    
    public DeliveryDetails(int orderID, ListClass arrList){
        arrClass = arrList;
        JPanel jpn = new JPanel(new GridLayout(7,2));
        JLabel jlblTitle = new JLabel("Delivery Details");
        jlblTitle.setFont(mainFont);
        JButton jbtOK = new JButton("OK");
        
        JLabel jlblCustNumberTitle = new JLabel("Tel No.");
        JLabel jlblCustNameTitle = new JLabel("Customer Name : ");
        JLabel jlblCustAddressTitle = new JLabel("Customer Address : ");
        JLabel jlblTimeToDeliverTitle = new JLabel("Time to receive");
        JLabel jlblEDTitle = new JLabel("Estimated Distance : ");
        JLabel jlblETATitle = new JLabel("ETA : ");
        JLabel jlblDescTitle = new JLabel("Description");
        
        JLabel jlblCustTel = new JLabel();
        JLabel jlblCustName = new JLabel();
        JLabel jlblCustAddress = new JLabel();
        JLabel jlblTimeToDeliver = new JLabel();
        JLabel jlblED = new JLabel();
        JLabel jlblETA = new JLabel();
        JLabel jlblDesc = new JLabel();
        
        jlblCustNumberTitle.setFont(titleFont);
        jlblCustNameTitle.setFont(titleFont);
        jlblCustAddressTitle.setFont(titleFont);
        jlblTimeToDeliverTitle.setFont(titleFont);
        jlblEDTitle.setFont(titleFont);
        jlblETATitle.setFont(titleFont);
        jlblDescTitle.setFont(titleFont);
        
        jlblCustTel.setFont(displayFont);
        jlblCustName.setFont(displayFont);
        jlblCustAddress.setFont(displayFont);
        jlblTimeToDeliver.setFont(displayFont);
        jlblED.setFont(displayFont);
        jlblETA.setFont(displayFont);
        jlblDesc.setFont(displayFont);
        
//        String custIC = "";
//        double distance = 0;
//        Calendar cal = Calendar.getInstance();
//        for(int i = 0; i < arrList.getScOrderClass().size(); i ++){
//            if(orderID == arrList.getScOrderClass().getEntry(i).getOrderID()){
//                distance = Math.round(arrList.getScOrderClass().getEntry(i).getDistance());
//                jlblED.setText(String.valueOf(arrList.getScOrderClass().getEntry(i).getDistance()) + " KM");
//                jlblTimeToDeliver.setText(sdfTime.format(arrList.getScOrderClass().getEntry(i).getReceiveTime()));
//                cal.setTime(arrList.getScOrderClass().getEntry(i).getReceiveTime());
//                custIC = arrList.getScOrderClass().getEntry(i).getCustIC();
//            }
//        }
//        double timeToDeliver =(40/distance) * 60;
//        cal.add(Calendar.MINUTE, 0 - Integer.parseInt(String.valueOf(Math.round(timeToDeliver)))); 
//        for(int i = 0; i < arrList.getCustList().getSize(); i ++){
//            if(custIC.equals(arrList.getCustList().getAllData(i).getCustIC())){
//                jlblCustTel.setText(arrList.getCustList().getAllData(i).getCustTelNo());
//                jlblCustName.setText(arrList.getCustList().getAllData(i).getCustName());
//                jlblCustAddress.setText(arrList.getCustList().getAllData(i).getCustAddress());
//                jlblETA.setText(Math.round(timeToDeliver) +" Minutes");
//                jlblDesc.setText("Estimated time to deliver the order " + new SimpleDateFormat("hh:mm aa").format(cal.getTime()));
//            }
//        }
        
        jbtOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DeliveryDetails.this.setVisible(false);
            }
        });
        
        jpn.add(jlblCustNumberTitle);
        jpn.add(jlblCustTel);
        
        jpn.add(jlblCustNameTitle);
        jpn.add(jlblCustName);
        
        jpn.add(jlblCustAddressTitle);
        jpn.add(jlblCustAddress);
        
        jpn.add(jlblTimeToDeliverTitle);
        jpn.add(jlblTimeToDeliver);
        
        jpn.add(jlblEDTitle);
        jpn.add(jlblED);
        
        jpn.add(jlblETATitle);
        jpn.add(jlblETA);
        
        jpn.add(jlblDescTitle);
        jpn.add(jlblDesc);
        
        JPanel jpnWrap = new JPanel();
        jpnWrap.add(jpn);
        
        add(jlblTitle, BorderLayout.NORTH);
        add(jpnWrap, BorderLayout.CENTER);
        add(jbtOK, BorderLayout.SOUTH);
        
        setSize(900,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Delivery Details");
    }
   
}
