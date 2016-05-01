/**
 * Write a description of class BotTurnState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotTurnState  implements State
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
           public void hit(){
        
        }
    public void stand(){
    
    }
    public void doubledown(){
    
    }
    public void surrender(){
    
    }
}
