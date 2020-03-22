/*
   note:
         prodType
         "b" for bakery
         "d" for dairy
         "j" for juice      
         "f" for fruit
         "o" for other
   
   
*/

import java.awt.*;
import javax.swing.*;

class ProdInfo
{

  private String prodTitle;
  private char prodType;
  private boolean prodOnSpecial;
  // [0] regular price [1] special price
  private double prodPrice[] = new double[2];
    

  ProdInfo(String pTitle, char pType, boolean pSpecial, double pRegPrice, double pSpecialPrice)
  {
  
     prodTitle = pTitle;
	  prodType = pType;
     prodOnSpecial = pSpecial;
     
     prodPrice[0] = pRegPrice;
     prodPrice[1] = pSpecialPrice;
      
	   

  }
  
  ////////////////////////////////////////////////
  //Finish this class by writing the various public set/get methods
  // for the above instance variables
  ////////////////////////////////////////////////  
   public String getProdTitle()
   {
      return prodTitle;
   } 
   public void setProdTitle(String pTitle)
   {
      prodTitle = pTitle;
   }
   
   public char getProdType()
   {
      return prodType;
   } 
   public void setProdType(char pType)
   {
      prodType = pType;
   }
   
    public boolean getProdOnSpecial()
   {
      return prodOnSpecial;
   } 
   public void setProdOnSpecial(boolean pSpecial)
   {
      prodOnSpecial = pSpecial;
   }
   
   public double getRegPrice()
   {
      return prodPrice[0];
   } 
   public void setRegPrice(double pRegPrice)
   {
      prodPrice[0] = pRegPrice;
   }
   public double getSpecialPrice()
   {
      return prodPrice[1];
   } 
   public void setSpecialPrice(double pSpecialPrice)
   {
      prodPrice[1] = pSpecialPrice;
   }
 
}

///////////////////////////////

class ProdList
{

 public ProdInfo[] pList;
  
  public void createList()
  {
  
     pList = new ProdInfo[25];
		pList[0] = new ProdInfo("Apples - Farmer's Market",'f', false,4.99,2.99);
      pList[1] = new ProdInfo("Apples - Nintendo Market",'f', false,7.99,3.99);
      pList[2] = new ProdInfo("Bananas - Farmer's Market",'f', false,4.99,2.99);
      pList[3] = new ProdInfo("Bananas - Sony Farm",'f', true,8.99,1.99);
		
      pList[4] = new ProdInfo("Beef Pot Roast in Gravy - Western Family",'o', false,11.99,9.99);
      
      pList[5] = new ProdInfo("Bread - Garlic - PriceSmart",'b', false,5.99,4.99);
      pList[6] = new ProdInfo("Bread - Whole Grain - Save On Food",'b', true,8.99,4.99);
      
      
      pList[7] = new ProdInfo("Cake - Black Forest - Save On Food",'b', true,9.99,3.99);
      pList[8] = new ProdInfo("Cheese - Black Label",'d', true,8.99,4.99);
      pList[9] = new ProdInfo("Chips - Smoke Wood - Miss Vickier's",'o', false,4.99,2.99);
      
      pList[10] = new ProdInfo("Chips - Sour Cream - Lays",'o', false,9.99,6.99);
  
  
      
      pList[11] = new ProdInfo("Cookies - Chocolate - Save On Food",'b', true,3.99,1.99);
      pList[12] = new ProdInfo("Cookies - McVitie's Digestive",'b', true,3.99,1.99);
      
      
      pList[13] = new ProdInfo("Eggs - (Brown) Westwood",'d', false,4.99,1.99);
      pList[14] = new ProdInfo("Eggs - (White) Apple Farm",'d', false,4.99,2.99);
      pList[15] = new ProdInfo("Fried Chicken Wings - BBQ - Sony Farm",'o', true,7.99,5.99);
      
      pList[16] = new ProdInfo("Juice - Coca Cola",'j', false,0.99,0.59);
      pList[17] = new ProdInfo("Juice - Mango - Calpico",'j', false,6.99,2.99);
      pList[18] = new ProdInfo("Juice - Pepsi",'j', false,0.79,0.59);
      pList[19] = new ProdInfo("Juice - Milk Tea - Kirin",'j', false,6.99,3.99);
      pList[20] = new ProdInfo("Juice - Orange Juice - Western Family",'j', false,4.99,1.59);
      
      pList[21] = new ProdInfo("Milk - Microsoft Dairy",'d', true,3.99,1.99);
      pList[22] = new ProdInfo("Oranges - California",'f', true,5.99,2.99);		
     
      pList[23] = new ProdInfo("Roast Chicken - Lemon - Sony Farm",'o', false,11.99,7.99);
      pList[24] = new ProdInfo("Spare Ribs in BBQ Sauce - Android Market",'o', false,9.99,6.99);
     

  }
  //public ProductInfo[] getList()
  
} 
