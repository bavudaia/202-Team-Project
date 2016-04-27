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
       User u=bjw.getUser();
       u.setNextX(100);
       u.setNextY(200);
       Bot b1=bjw.getBot1();
       b1.setNextX(200);
       b1.setNextY(300);
       Bot b2=bjw.getBot2();
       b2.setNextX(300);
       b2.setNextY(400);
       Bot b3=bjw.getBot3();
       b3.setNextX(400);
       b3.setNextY(500);
       Dealer d=bjw.getDealer();
       u.getFirstCards();
       b1.getFirstCards();
       b2.getFirstCards();
       b3.getFirstCards();
       d.getFirstCards();
       
   }
  
}
