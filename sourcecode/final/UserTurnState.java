/**
 * Write a description of class UserTurnState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserTurnState  implements State
{
    // instance variables - replace the example below with your own
   BlackJackWorld bjw;
   public void bet(int betVal){}        
   public void setBlackJackWorld(BlackJackWorld p){bjw=p;}    
   public void clear(){}
   public  void done(){}
    @Override
    public void distribute()
    {
        
    }
    
       public void hit(){
           Player p = bjw.getUser();
           p.hit();
        }
    public void stand(){
        Player p = bjw.getUser();
        p.stand();
    }
    public void doubledown(){
     Player p = bjw.getUser();
     p.doubleDown();
    }
    public void surrender(){
         Player p = bjw.getUser();
         p.surrender();
    }
}
