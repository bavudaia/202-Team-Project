/**
 * Write a description of class BotBettingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotBettingState  implements State 
{
   BlackJackWorld bjw;
   public void bet(int betVal){}        
   public void setBlackJackWorld(BlackJackWorld p){}    
   public void clear(){}
   public  void done(){
    bjw.setCurrentState(bjw.getCardDistributionState());
    State s=bjw.getCardDistributionState();
    s.distribute();
    }
    @Override
    public void distribute()
    {
    }
}
