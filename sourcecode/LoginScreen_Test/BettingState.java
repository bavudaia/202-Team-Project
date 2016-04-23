/**
 * Write a description of class BettingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BettingState  implements State
{
    Player p;
    @Override    
    public void bet(int betValue)
    {
       p.addBet(betValue); 
    }
    @Override
    public void setBlackJackWorld(Player p)
    {   
        this.p=p;
    }
    
    @Override
    public void done()
    {
        p.setCurrentState(p.getBotBettingState());
    }
    @Override
    public void clear(){
        p.clearBet();
    }
}
