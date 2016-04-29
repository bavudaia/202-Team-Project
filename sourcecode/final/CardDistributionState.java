/**
 * Write a description of class CardDistributionState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardDistributionState  implements State
{
    // instance variables - replace the example below with your own
    BlackJackWorld bjw;
   public void bet(int betVal){}
   public void setBlackJackWorld(BlackJackWorld p)
   {
       bjw=p;
   }
   public void done(){}
   public void clear(){}
   public void distribute()
   {
       System.out.println("Inside Carddiststate distribute");
       User u=bjw.getUser();

       Bot b1=bjw.getBot1();

       Bot b2=bjw.getBot2();

       Bot b3=bjw.getBot3();

       Dealer d=bjw.getDealer();
       u.getFirstCards();
       b1.getFirstCards();
       b2.getFirstCards();
       b3.getFirstCards();
       d.getFirstCards();
       
   }
  
}
