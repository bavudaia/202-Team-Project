/**
 * Write a description of class BettingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BettingState  implements State
{
    BlackJackWorld bjw;
    @Override    
    public void bet(int betValue)
    {
        User user = bjw.getUser();
        user.addBet(betValue); 
    }
    @Override
    public void setBlackJackWorld(BlackJackWorld bjw)
    {   
        this.bjw=bjw;
    }
    
    @Override
    public void done()
    {
        bjw.setCurrentState(bjw.getBotBettingState());
    }
    @Override
    public void clear(){
        bjw.getUser().clearBet();
    }
}
