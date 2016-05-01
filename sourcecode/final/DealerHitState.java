/**
 * Write a description of class DealerHitState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DealerHitState  implements State
{
   BlackJackWorld bjw;
   public void bet(int betVal){}        
   public void setBlackJackWorld(BlackJackWorld p){bjw=p;}    
   public void clear(){}
   public  void done(){
       
    }
    @Override
    public void distribute()
    {
    }
}
