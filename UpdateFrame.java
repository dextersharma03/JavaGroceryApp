import java.applet.Applet;
import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.Vector;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;

class UpdateFrame extends JFrame implements ActionListener, ItemListener
{
   JButton bClose;
	Container con;
   JComboBox jcombo;	
   JPanel pE,pL,p10, pE2, p1, p2, p3, p4, p5, p6, p7,p8;
   JLabel jEmpty,jEmpty2, Tst;
   Vector v1;
   JList lst1;
   JTextField price, special;
   JCheckBox spec;
   
    JMenuBar m;
	 JMenu updatePrice;
	 JMenuItem saveit; 

   
  ProdList mylist = new ProdList();
  ProdInfo pinfo;
  ProdInfo[] l,l1;
   
   UpdateFrame()
   {     
	   super();
		con = getContentPane();
		con.setLayout(new GridLayout(1,3,1,1));
      
      m = new JMenuBar();
      
      updatePrice = new JMenu("Update Price");
      updatePrice.setMnemonic('U');
      
      saveit = new JMenuItem("Save Current Record");
      
      saveit.addActionListener(this);
      saveit.setMnemonic('S');
      
      updatePrice.add(saveit);
      
      m.add(updatePrice);
			// set JMenuBar active
	  setJMenuBar(m);
  
/////////////////////////////////////////////First Panel 1x1///////////////////////////////////////////      
      mylist.createList();			
      v1 = new Vector();			
	   l =  mylist.pList; 
      jcombo = new JComboBox();
      
      for(int i = 0; i < l.length; i++)
            jcombo.addItem(l[i].getProdTitle());
      jcombo.addItemListener(this);
      
      jEmpty = new JLabel();
      pE = new JPanel();
      pE.add(jEmpty);
              
      
      Tst = new JLabel("");
      pL = new JPanel();
      pL.add(jcombo);
      pL.setLayout(new BorderLayout(1,1)); 
      pL.add (Tst,BorderLayout.NORTH);
       pL.add (Tst,BorderLayout.SOUTH);
       pL.add (Tst,BorderLayout.EAST);
       pL.add (jcombo,BorderLayout.WEST);
       pL.add (Tst,BorderLayout.CENTER);
      
      jEmpty2 = new JLabel();
      pE2 = new JPanel();
      pE2.add(jEmpty2);
      
      p10 = new JPanel();
      p10.setLayout(new GridLayout(3,1,1,1));
      p10.add(pE);
      p10.add(pL);
      p10.add(pE2);
      con.add(p10);
/////////////////////////////////////////////First Panel 1x2///////////////////////////////////////////      
      special = new JTextField();
      special.setText("2.99");
      p1 = new JPanel();
      p1.add(special);
      p1.setBorder(new TitledBorder("On Special Price"));
      p1.setLayout(new BorderLayout(1,1)); 
      p1.add (special,BorderLayout.CENTER);
      special.setBackground(Color.yellow);
      
      price = new JTextField();
      price.setText("4.99");
      p2 = new JPanel();
      p2.add(price);
      p2.setBorder(new TitledBorder("Regular Price"));
      p2.setLayout(new BorderLayout(1,1));
      p2.add (price,BorderLayout.CENTER);
      price.setBackground(Color.green);
      
      p3 = new JPanel();
      p3.setLayout(new GridLayout(2,1,1,1));
      p3.add(p1);
      p3.add(p2);
      con.add(p3);
/////////////////////////////////////////////First Panel 1x3///////////////////////////////////////////      
      p4 = new JPanel();
      p4.add(jEmpty);
              
      p5 = new JPanel();
      spec = new JCheckBox("On Special");
      p5.add(spec);
      p5.setLayout(new BorderLayout(1,1)); 
       p5.add (spec,BorderLayout.WEST);
      
      p6 = new JPanel();
      p6.add(jEmpty2);
      
      p7 = new JPanel();
      p7.setLayout(new GridLayout(3,1,1,1));
      p7.add(p4);
      p7.add(p5);
      p7.add(p6);
      con.add(p7);
   
   }
   public void itemStateChanged(ItemEvent e)
   {
      if(e.getSource() instanceof JComboBox)
		{
         if(e.getSource() == jcombo)
         {
            mylist.createList();					
         	   l =  mylist.pList;
               for(int i = 0; i < l.length; i++)
                    {
                        if(jcombo.getSelectedItem().equals(l[i].getProdTitle()) == true)
                        {
                             price.setText(String.valueOf(l[i].getRegPrice()));
                             special.setText(String.valueOf(l[i].getSpecialPrice()));
                              if(l[i].getProdOnSpecial() == true)
                                 spec.setSelected(true);
                              else
                                 spec.setSelected(false);
                         }
                     }
         }
      }
   } 
    
	public void actionPerformed(ActionEvent e)
	{
    if(e.getSource() instanceof JMenuItem)
		{
         if(e.getSource() == saveit)
            {
               mylist.createList();					
         	   l =  mylist.pList;
               for(int i = 0; i < l.length; i++)
                    {
                        if(jcombo.getSelectedItem().equals(l[i].getProdTitle()) == true)
                        {
                            try
                            {
                              l[i].setRegPrice(Double.valueOf(price.getText()));
                              l[i].setSpecialPrice(Double.valueOf(special.getText()));
                              if(spec.isSelected() == true)
                                 l[i].setProdOnSpecial(true);
                                 
                              JOptionPane.showConfirmDialog(this, "Update Complete","Confirmation",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                             }
                             catch(NumberFormatException k)
                             {}
                             
                        }
                    }
            }          
      }
	}

   public static void main(String args[])
	{
		UpdateFrame jm = new UpdateFrame();
     // jm.createScreen();
      jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jm.setTitle("Price Update");
	 // set size
	  jm.setSize(1500,900);
    // display window
    jm.setVisible(true);  
	}
}	


