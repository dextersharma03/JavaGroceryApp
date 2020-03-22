import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.Vector;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;
/*

THE PASSWORD IS "012"

*/

public class CornerStore extends JFrame implements ListSelectionListener, MouseListener, ActionListener, ItemListener
{
  JButton bBakery, bDairy,bJuice,bFruit, b0,b1,b2,b3,b4,b5, bReset,bSel, bEnter;	
  JButton bOther,bClear,bClearAll,bSubmit;
  UpdateFrame window;
  DecimalFormat df2 = new DecimalFormat("#.##");
  
  JPanel p1,p2,p3,p4,p5,p5a,p6,p7, p8, p9,p10,p11,p12,p13,pQTY,p14, pDelivery,pTotal,pEmpty,pPrice;	// declare the JPanels
  JLabel Img, Pass, Pass1,jEmpty,jTotal,jLabel, Tst;
  JPasswordField t, p;
  JScrollPane jp,jp1, scrollB;
  JList lst,lst1,lstE, list, flist;
  JRadioButton rDelivery;
  JComboBox Qty;
  JTextArea t1;
  Color oldcolor;
  Vector v, v1, v2, v3;
  ImageIcon imgB, imgD, imgF, imgJ, imgO; 
  double total, vtotal, grossP;
  int res = 0;
  String title1, title2, title3, title4 ,password = "012";  /// PASSWORD 
  
  ProdList mylist = new ProdList();
  ProdInfo pinfo;
 public ProdInfo[] l,l1;
  
  Container con;
  
  public void createScreen()
  {   
      imgB = new ImageIcon("bakery.jpg"); 
      imgD = new ImageIcon("dairy.jpg");
      imgF = new ImageIcon("fruit.jpg");
      imgJ = new ImageIcon("juice.jpg");
      imgO = new ImageIcon("other.jpg");
      
   	bBakery = new JButton("Bakery");
   	bDairy = new JButton("Dairy");
   	bJuice = new JButton("Juice");
   	bFruit = new JButton("Fruit");	  
   	bOther = new JButton("Other");
	
////// Construct 1st JPanel
	// add components to 1st JPanel
	 p1 = new JPanel();
    p1.setLayout(new GridLayout(2,2,5,5));
    bBakery.addMouseListener(this);
    p1.add(bBakery);
    bJuice.addMouseListener(this);
    bDairy.addMouseListener(this);
    p1.add(bDairy);
    bJuice.addMouseListener(this);
    p1.add(bJuice);
    bFruit.addMouseListener(this);
    p1.add(bFruit);

/////// Construct 2nd JPanel
    p2 = new JPanel();
    p2.setLayout(new BorderLayout(5,5)); 
// add components to 2nd JPanel
   bOther.addMouseListener(this);
    p2.add (bOther,BorderLayout.CENTER);

    // Construct overall JPanel
   	p3 = new JPanel();
      p3.setLayout(new GridLayout(2,1,5,5));							
									 // set layout to gridlayout, 2 rows, 1 col
      p3.add(p1);
      p3.add(p2);
      p3.setBorder(new TitledBorder("Select Type")); 
						  //add overall JPanel to pane
      con = getContentPane();         
      con.setLayout(new GridLayout(3,2,5,5));	  ///MAIN GRIDLAYOUT						
									
      con.add(p3);
      
////////////////////////////////// JPanel (1x2) ////////////////////////////////////////////////////////////////////////   
       v = new Vector();
       mylist.createList();		// create vector vt				
	    l =  mylist.pList;        
      
      lst = new JList(v);
      lst.setFixedCellHeight(30); //sets the height of each item, in pixel length
   	lst.setFixedCellWidth(30);  //sets the width of each item, in pixel length
   	lst.setVisibleRowCount(10);
      lst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       bBakery.addActionListener(this);
       bDairy.addActionListener(this);
       bFruit.addActionListener(this);
       bJuice.addActionListener(this);
       bOther.addActionListener(this);
       lst.addListSelectionListener(this);
	    jp = new JScrollPane(lst);
       jp.setBorder(new TitledBorder("Select Product")); 
       con.add(jp);

////////////////////////////////// JPanel (1x3)////////////////////////////////////////////////////////////////////////   
      jLabel = new JLabel();
      pPrice = new JPanel();
      Tst = new JLabel(" ");
      pPrice.add(jLabel);
      pPrice.setOpaque(true);
      pPrice.setBorder(new TitledBorder("Price"));
      pPrice.setLayout(new BorderLayout(1,1)); 
      pPrice.setBackground(Color.yellow);
       pPrice.add (Tst,BorderLayout.NORTH);
       pPrice.add (Tst,BorderLayout.SOUTH);
       pPrice.add (Tst,BorderLayout.EAST);
       pPrice.add (jLabel,BorderLayout.WEST);
       pPrice.add (Tst,BorderLayout.CENTER);
      
      Qty = new JComboBox();
      Qty.addItem("1");
      Qty.addItem("2");
      Qty.addItem("3");
      Qty.addItem("4");
      Qty.addItem("5");
      Qty.addItemListener(this);
      pQTY = new JPanel();
      pQTY.setLayout(new BorderLayout(1,1));
      pQTY.add(Qty);
      pQTY.setBorder(new TitledBorder("Qty"));
      
      bSel = new JButton("Select");
      
      p11 = new JPanel();
      p11.setLayout(new GridLayout(1,2,1,1));
      p11.add(pQTY);
      p11.add(bSel);
      
      p12 = new JPanel();
      p12.setLayout(new GridLayout(2,1,1,1));
      p12.add(pPrice);
      p12.add(p11);

      con.add(p12);
      
////////////////////////////////// THIRD JPanel (2x1)////////////////////////////////////////////////////////////////////////   
      Img = new JLabel();
      p4 = new JPanel();
      p4.add(Img);

        scrollB = new JScrollPane(p4,
                     JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                     JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      con.add(scrollB);
////////////////////////////////// FOURTH JPanel (2x2)////////////////////////////////////////////////////////////////////////   
       v1 = new Vector();
       v2 = new Vector();
       v3 = new Vector();
	// create vector vt				
	    l1 =  mylist.pList; 
       lst1 = new JList(v1);
      lst1.setFixedCellHeight(30); //sets the height of each item, in pixel length
   	lst1.setFixedCellWidth(30);  //sets the width of each item, in pixel length
   	lst1.setVisibleRowCount(10);
      lst1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      bSel.addActionListener(this);
       
	    jp1 = new JScrollPane(lst1);
       jp1.setBorder(new TitledBorder("Your Selection")); 
       con.add(jp1);
////////////////////////////////// 7TH JPanel (2x3)////////////////////////////////////////////////////////////////////////   
       bClear = new JButton("Clear");
       bClearAll = new JButton("Clear All");
       bClear.addActionListener(this);
       bClearAll.addActionListener(this);
       p13 = new JPanel();
         p13.setLayout(new GridLayout(2,1,1,1));
         p13.add(bClear);
         p13.add(bClearAll);
         p13.setBorder(new TitledBorder("For Clearing Your Selection"));
       con.add(p13);
////////////////////////////////// FIFTH JPanel (3x1)////////////////////////////////////////////////////////////////////////   
          
      Pass = new JLabel("Use Keypad to enter password for settings");
      Tst = new JLabel(" ");
      p5 = new JPanel();
      p5.add(Pass); 
      p5.setLayout(new BorderLayout(1,1)); 
       p5.add (Tst,BorderLayout.NORTH);
       p5.add (Tst,BorderLayout.SOUTH);
       p5.add (Tst,BorderLayout.EAST);
       p5.add (Pass,BorderLayout.WEST);
       p5.add (Tst,BorderLayout.CENTER);
      //Paswd Field
      p = new JPasswordField();
      p.setEditable(false);
      
      //Pswd Buttons
      b0 = new JButton("0");
   	b1 = new JButton("1");
   	b2 = new JButton("2");
   	b3 = new JButton("3");
   	b4 = new JButton("4"); 
   	b5 = new JButton("5");
      b0.addActionListener(this);
   	b1.addActionListener(this);
   	b2.addActionListener(this);
   	b3.addActionListener(this);
   	b4.addActionListener(this); 
   	b5.addActionListener(this);
   	 p6 = new JPanel();
       p6.setLayout(new GridLayout(2,3,1,1));
       p6.add(b0);
       p6.add(b1);
       p6.add(b2);
       p6.add(b3);
       p6.add(b4);   
       p6.add(b5);
      
      p7 = new JPanel();
      p7.setLayout(new GridLayout(1,2,1,1));							
      p7.add(p);
      p7.add(p6);
      
      bReset = new JButton("Reset");
      bEnter = new JButton("Enter");
      bReset.addActionListener(this);
      bEnter.addActionListener(this);
      p8 = new JPanel();
      p8.setLayout(new GridLayout(1,2,1,1));
      p8.add(bReset);
      p8.add(bEnter);
      
      p9 = new JPanel();
      p9.setLayout(new GridLayout(3,1,1,1));
      p9.add(p5);
      p9.add(p7);
      p9.add(p8);
      p9.setBorder(new TitledBorder("For Employee use ONLY"));
      p9.setOpaque(true);
      p9.setBackground(Color.red);
      p5.setOpaque(true);
      p5.setBackground(Color.red);
      
      con.add(p9);
//////////////////////////////////Price Window//////////
      window = new UpdateFrame();
      window.setTitle("Price Update");
      window.setSize(1000,400);
      window.setLocationRelativeTo(null);
      
      
////////////////////////////////// SIXTH JPanel (3x2)////////////////////////////////////////////////////////////////////////   
      rDelivery = new JRadioButton("Home Delivery - $5.99");
      pDelivery = new JPanel();
      pDelivery.add(rDelivery);
      Tst = new JLabel(" "); 
      pDelivery.setLayout(new BorderLayout(1,1)); 
       pDelivery.add (Tst,BorderLayout.NORTH);
       pDelivery.add (Tst,BorderLayout.SOUTH);
       pDelivery.add (Tst,BorderLayout.EAST);
       pDelivery.add (rDelivery,BorderLayout.WEST);
       pDelivery.add (Tst,BorderLayout.CENTER);
           
      jTotal = new JLabel("Total: ");
      pTotal = new JPanel();
      pTotal.add(jTotal);
      pTotal.setOpaque(true);
      pTotal.setLayout(new BorderLayout(1,1)); 
      pTotal.setBackground(Color.green);
       pTotal.add (Tst,BorderLayout.NORTH);
       pTotal.add (Tst,BorderLayout.SOUTH);
       pTotal.add (Tst,BorderLayout.EAST);
       pTotal.add (jTotal,BorderLayout.WEST);
       pTotal.add (Tst,BorderLayout.CENTER);
      
      jEmpty = new JLabel();
      pEmpty = new JPanel();
      pEmpty.add(jEmpty);
      
      p10 = new JPanel();
      p10.setLayout(new GridLayout(3,1,1,1));
      p10.add(pDelivery);
      p10.add(pTotal);
      p10.add(pEmpty);
      p10.setBorder(new TitledBorder("Total"));
      con.add(p10);

////////////////////////////////// 8TH JPanel (3x3)////////////////////////////////////////////////////////////////////////   
      t = new JPasswordField();
      bSubmit = new JButton("Submit");
      bSubmit.addActionListener(this);
      p14 = new JPanel();
         p14.setLayout(new GridLayout(2,1,1,1));
         p14.add(t);
         p14.add(bSubmit);
         p14.setBorder(new TitledBorder("Enter CC#"));
       con.add(p14);
  }
  
  public void itemStateChanged(ItemEvent e){} 
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() instanceof JButton)
	  {
       if(e.getSource() == bBakery)
         {       
                v.clear();             
                v.addElement(l[5].getProdTitle());
                v.addElement(l[6].getProdTitle());
                v.addElement(l[7].getProdTitle());
                v.addElement(l[11].getProdTitle());
                v.addElement(l[12].getProdTitle());
                lst.setListData(v);
                Img.setIcon(imgB);
         }
         else if(e.getSource() == bDairy)
         {       
                v.clear();  
                v.addElement(l[8].getProdTitle());            
                v.addElement(l[13].getProdTitle());
                v.addElement(l[14].getProdTitle());
                v.addElement(l[21].getProdTitle());
                lst.setListData(v);
                Img.setIcon(imgD);
         }
         else if(e.getSource() == bJuice)
         {       
                v.clear(); 
                v.addElement(l[16].getProdTitle());
                v.addElement(l[17].getProdTitle());
                v.addElement(l[18].getProdTitle());
                v.addElement(l[19].getProdTitle());
                v.addElement(l[20].getProdTitle());
                lst.setListData(v);
                Img.setIcon(imgJ);
         }
         else if(e.getSource() == bFruit)
         {       
                v.clear();
                v.addElement(l[0].getProdTitle());
                v.addElement(l[1].getProdTitle());
                v.addElement(l[2].getProdTitle());
                v.addElement(l[3].getProdTitle());
                v.addElement(l[22].getProdTitle());
                lst.setListData(v);
                Img.setIcon(imgF);
         }
         else if(e.getSource() == bOther)
         {       
                v.clear();
                v.addElement(l[4].getProdTitle());
                v.addElement(l[9].getProdTitle());
                v.addElement(l[10].getProdTitle());
                v.addElement(l[15].getProdTitle());
                v.addElement(l[23].getProdTitle());
                v.addElement(l[24].getProdTitle());
                lst.setListData(v);
                Img.setIcon(imgO);
         }
         else  if(e.getSource() == bSel)
         { 
            try {
                  for(int i = 0; i < l.length; i++)
                    {
                           
                               if(lst.getSelectedValue().equals(l[i].getProdTitle()) == true)
                                  {
                                    if(window.l[i].getProdOnSpecial() == false)
                                        {                                   
                                          total += (Qty.getSelectedIndex() + 1) * window.l[i].getRegPrice();  
                                          vtotal = (Qty.getSelectedIndex() + 1) * window.l[i].getRegPrice(); 
                                          title1 = l[i].getProdTitle();  
                                          v1.addElement(title1+ " -- $"+vtotal);
                                          lst1.setListData(v1);
                                          jTotal.setText("Total: $");
                                          total=Double.parseDouble(df2.format(total));
                                          jTotal.setText(jTotal.getText() +total+" - (NOT inc. delivery)");     
                                       }
                                    else 
                                       if(window.l[i].getProdOnSpecial() == true) 
                                       {
                                          total += (Qty.getSelectedIndex() + 1) * window.l[i].getSpecialPrice();
                                          vtotal = (Qty.getSelectedIndex() + 1) * window.l[i].getSpecialPrice();
                                          title1=l[i].getProdTitle();
                                          v1.addElement(title1+ " -- $"+vtotal+ " **");
                                          lst1.setListData(v1);  
                                          jTotal.setText("Total:  $");  
                                          total=Double.parseDouble(df2.format(total));
                                          jTotal.setText(jTotal.getText() +total+ " - (NOT inc. delivery)");     
                                       }
                                  } 
                     }  
                }catch(NullPointerException ie) {}
           }
           else
      			if(e.getSource() == bSubmit)
      			{
                  res =	JOptionPane.showConfirmDialog(this, "Are You Sure ?","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
      				if(res == JOptionPane.YES_OPTION)
                    {   
                        if(lst1.getFirstVisibleIndex() == -1) 
                        {
                           JOptionPane.showMessageDialog(null, "No Product selected, Please select a product","Not Allowed",JOptionPane.ERROR_MESSAGE); //null will display it in centre
                        }
                        else if((lst1.getFirstVisibleIndex() != -1) )
                        {
                           if (t.getPassword().length == 0) 
                           {
                              JOptionPane.showMessageDialog(null, "Please enter a VALID Credit Card","Not Allowed",JOptionPane.ERROR_MESSAGE); //null will display it in centre
                           }
                            else                          
                            {
                              jTotal.setText("Total: $");  
                              if(rDelivery.isSelected()==true)
                              {
                                 jTotal.setText(jTotal.getText() +(df2.format(Math.abs(total)+5.99))+ " - (Including Delivery)");   
                                 JOptionPane.showMessageDialog(null, ("Total: $" +(df2.format(Math.abs(total)+5.99))+ " INC. Delivery"+ "\n"+" has been charged to your card, Thank You"),"Confirmation",JOptionPane.INFORMATION_MESSAGE); //null will display it in centre
                              }
                              else if(rDelivery.isSelected()!=true)
                              {
                                  jTotal.setText(jTotal.getText() +(total)+ " - (Not Including Delivery)");   
                                  JOptionPane.showMessageDialog(null, ("Total: $" +(df2.format(Math.abs(total)))+ " Not INC. Delivery"+ "\n"+" has been charged to your card, Thank You"),"Confirmation",JOptionPane.INFORMATION_MESSAGE); //null will display it in centr
                              }
                              v1.clear();
                              lst1.setListData(v1);
                              jTotal.setText("Total: ");  
                              t.setText("");
                              rDelivery.setSelected(false);
                              total = 0;
                              vtotal = 0;
                            }
                        } 
                    } 
             }
             else if(e.getSource() == bClear)
                     {
                           if(lst1.getSelectedIndex() != -1)
                           {
                              try {
                                    for(int i = 0; i < mylist.pList.length; i++)
                                      {   
                                          for(int s = 0; s<6; s++)
                                             {
                                               if(lst1.getSelectedValue().equals((l[i].getProdTitle() + " -- $" + ( (Qty.getSelectedIndex() + s) * window.l[i].getRegPrice()))) == true)
                                                    {
                                                      if(l1[i].getProdOnSpecial() == false)
                                                          {   
                                                            title1 = l[i].getProdTitle();   
                                                            v1.remove(lst1.getSelectedIndex());
                                                            lst1.setListData(v1); 
                                                            total -= ( (Qty.getSelectedIndex() + s) * window.l[i].getRegPrice()); 
                                                            jTotal.setText("Total: $");
                                                            jTotal.setText(jTotal.getText() +Double.parseDouble(df2.format(Math.abs(total)))+" - (NOT inc. delivery)");     
                                                         }
                                                      else 
                                                         if(l1[i].getProdOnSpecial() == true) 
                                                         {                 
                                                            title1 = l[i].getProdTitle();   
                                                            v1.remove(lst1.getSelectedIndex());
                                                            lst1.setListData(v1); 
                                                            total -= ( (Qty.getSelectedIndex() + s) * window.l[i].getRegPrice()); 
                                                            jTotal.setText("Total: $");
                                                            jTotal.setText(jTotal.getText() +Double.parseDouble(df2.format(Math.abs(total)))+" - (NOT inc. delivery)");    
                                                         }
                                                    } 
                                                    else
                                                     { if(lst1.getSelectedValue().equals((l[i].getProdTitle() + " -- $" + ( (Qty.getSelectedIndex() + s) * window.l[i].getSpecialPrice())+ " **")) == true)                                                    {
                                                         { 
                                                         
                                                         if(l1[i].getProdOnSpecial() == false)
                                                          {   
                                                           title1 = l[i].getProdTitle();   
                                                            v1.remove(lst1.getSelectedIndex());
                                                            lst1.setListData(v1); 
                                                            total -= ( (Qty.getSelectedIndex() + s) * window.l[i].getRegPrice()); 
                                                            jTotal.setText("Total: $");
                                                            jTotal.setText(jTotal.getText() +Double.parseDouble(df2.format(Math.abs(total)))+" - (NOT inc. delivery)");      
                                                          }
                                                         else 
                                                            if(l1[i].getProdOnSpecial() == true) 
                                                            {                 
                                                               title1 = l[i].getProdTitle();   
                                                               v1.remove(lst1.getSelectedIndex());
                                                               lst1.setListData(v1); 
                                                               total -= ( (Qty.getSelectedIndex() + s) * window.l[i].getSpecialPrice()); 
                                                               jTotal.setText("Total: $");
                                                               jTotal.setText(jTotal.getText() +Double.parseDouble(df2.format(Math.abs(total)))+" - (NOT inc. delivery)");   
       
                                                            }
                                                         }
                                                   }  
                                            }                 
                                       }
                                      }
                                     }catch(NullPointerException ie) {}
                            }
                            else if(lst1.getSelectedIndex() == -1)
                                 JOptionPane.showMessageDialog(null, "No Product selected, Please select a product","Not Allowed",JOptionPane.ERROR_MESSAGE); //null will display it in centre

             }
              else if(e.getSource() == bClearAll)
              {
                 res =	JOptionPane.showConfirmDialog(this, "Are You Sure ?","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
      				if(res == JOptionPane.YES_OPTION)
                    {
                        v1.clear();
                        lst1.setListData(v1);
                        jTotal.setText("Total:  $0.00");  
                        t.setText("");
                        total = 0;
                        vtotal = 0;
                    }
              }
              else if(e.getSource() == b0)
              {
                  p.setText(String.copyValueOf(p.getPassword()) + b0.getText());
              }
               else if(e.getSource() == b1)
              {
                  p.setText(String.copyValueOf(p.getPassword()) + b1.getText());
              }
               else if(e.getSource() == b2)
              {
                  p.setText(String.copyValueOf(p.getPassword()) + b2.getText());
              }
               else if(e.getSource() == b3)
              {
                  p.setText(String.copyValueOf(p.getPassword()) + b3.getText());
              }
               else if(e.getSource() == b4)
              {
                  p.setText(String.copyValueOf(p.getPassword()) + b4.getText());
              }
               else if(e.getSource() == b5)
              {
                  p.setText(String.copyValueOf(p.getPassword()) + b5.getText());
              }
                else if(e.getSource() == bEnter)
              {
                       char[] pass = p.getPassword();
                       String ps = new String(pass);
                      // if (ps.equals(password))
                      if(p.getText().equals(password))
                       {
                         if(lst1.getFirstVisibleIndex() != -1)
                            {  
                              JOptionPane.showMessageDialog(null, "Allow Customer to finish FIRST","Not Allowed",JOptionPane.ERROR_MESSAGE); //null will display it in centre  
                            } 
                         else                      
                          {
                           v.clear();
                           lst.setListData(v);
                           v1.clear();
                           jLabel.setText("");
                           Img.setIcon(null);
                           p.setText("");
                           bBakery.setBackground(bBakery.getForeground());
                           bJuice.setBackground(bJuice.getForeground());
                           bDairy.setBackground(bDairy.getForeground());
                           bFruit.setBackground(bFruit.getForeground());
                           bOther.setBackground(bOther.getForeground());
                           lst1.setListData(v1);
                           window.setVisible(true);
                          }
                          
                       } 
                       else
                       {
                           JOptionPane.showMessageDialog(null, "WRONG Password, Please re-enter","Not Allowed",JOptionPane.ERROR_MESSAGE); //null will display it in centre                       } 
                           if(lst1.getFirstVisibleIndex() != -1)
                                JOptionPane.showMessageDialog(null, "Allow Customer to finish FIRST","Not Allowed",JOptionPane.ERROR_MESSAGE); //null will display it in centre                       } 

                       }
              }
                else if(e.getSource() == bReset)
              {
                p.setText("");
              }              
      }
  }
   
  
  
  public void valueChanged(ListSelectionEvent e)
  {
       if(e.getSource() instanceof JList)
       {
         for(int i = 0; i < l.length; i++)
           {
                  try {
                      if(lst.getSelectedValue().equals(l[i].getProdTitle()) == true)
                        {
                        if(window.l[i].getProdOnSpecial() == false)
                        {
                           jLabel.setText("Reg: $"+String.valueOf(window.l[i].getRegPrice()));
                           }
                        else 
                          if(window.l[i].getProdOnSpecial() == true)
                            jLabel.setText("** Special: $"+String.valueOf(window.l[i].getSpecialPrice())+ "**   " +"Reg: $"+String.valueOf(window.l[i].getRegPrice()));
                        }
                    } 
                    catch(NullPointerException ie) 
                    {    
                    } 
           } 
       }
  }  
  
public void mouseClicked(MouseEvent e) {}
public void setBackground() 
{
   Img.setBackground(Img.getForeground());
   bBakery.setBackground(bBakery.getForeground());
   bJuice.setBackground(bJuice.getForeground());
   bDairy.setBackground(bDairy.getForeground());
   bFruit.setBackground(bFruit.getForeground());
   bOther.setBackground(bOther.getForeground());
} 
 
public void mousePressed(MouseEvent e) 
{ 
  
    if(e.getSource() instanceof JButton)
     {
      if(e.getSource() == bBakery)
       {
           setBackground();   
           bBakery.setBackground(Color.yellow);
           oldcolor = Color.yellow;
       } 
      else if(e.getSource() == bJuice)
        {
           setBackground();   
           bJuice.setBackground(Color.yellow);
           oldcolor = Color.yellow;
        }
      else if(e.getSource() == bDairy)
        {
           setBackground();
           bDairy.setBackground(Color.yellow);
           oldcolor = Color.yellow;
        }
      else if(e.getSource() == bFruit)
        {
           setBackground();
           bFruit.setBackground(Color.yellow);
           oldcolor = Color.yellow;
        }
      else if(e.getSource() == bOther)
        {
           setBackground();
           bOther.setBackground(Color.yellow);
           oldcolor = Color.yellow;
        }
     }
}
 
   public void mouseReleased(MouseEvent e){}
   public void mouseEntered(MouseEvent e) 
   { 
     if(e.getSource() instanceof JButton)
     {
      if(e.getSource() == bBakery)
       {
        oldcolor = bBakery.getForeground();
        if(bBakery.getBackground() == Color.yellow)
           {
            oldcolor = Color.yellow;
           }
           else
            bBakery.setBackground(Color.green);
       } 
      else if(e.getSource() == bJuice)
        {
           oldcolor = bJuice.getForeground();
           if(bJuice.getBackground() == Color.yellow)
           {
            oldcolor = Color.yellow;
           }
           else
           bJuice.setBackground(Color.green);
        }
      else if(e.getSource() == bDairy)
        {
           oldcolor = bDairy.getForeground();
           if(bDairy.getBackground() == Color.yellow)
           {
            oldcolor = Color.yellow;
           }
           else
           bDairy.setBackground(Color.green);
        }
      else if(e.getSource() == bFruit)
        {
           oldcolor = bFruit.getForeground();
           if(bFruit.getBackground() == Color.yellow)
           {
            oldcolor = Color.yellow;
           }
           else
           bFruit.setBackground(Color.green);
        }
      else if(e.getSource() == bOther)
        {
           oldcolor = bOther.getForeground();
           if(bOther.getBackground() == Color.yellow)
           {
            oldcolor = Color.yellow;
           }
           else
             bOther.setBackground(Color.green);
        }
     } 
   }

   public void mouseExited(MouseEvent e)
   {        
    if(e.getSource() instanceof JButton)
      {
      if(e.getSource() == bBakery)
       {
        bBakery.setBackground(oldcolor);
       } 
      else if(e.getSource() == bJuice)
        {
          bJuice.setBackground(oldcolor);
        }
      else if(e.getSource() == bDairy)
        {
          bDairy.setBackground(oldcolor);
        }
      else if(e.getSource() == bFruit)
        {
           bFruit.setBackground(oldcolor);
        }
      else if(e.getSource() == bOther)
        {
           bOther.setBackground(oldcolor);
        }
     }
   }
   
 public static void main(String args[])
	{
		CornerStore jm = new CornerStore();
      jm.createScreen();
      jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jm.setTitle("Grocery App");
	
   	 // set size
   	 jm.setSize(1500,900);
       // display window
       jm.setVisible(true);    
	}
}