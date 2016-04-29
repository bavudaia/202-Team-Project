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
      //  if(bjw==null)System.out.println("null"); else System.out.println(bjw.toString());
        this.bjw=bjw;
    }
    
    @Override
    public void done()
    {
        bjw.setCurrentState(bjw.getBotBettingState());
        bjw.notifyDeal();
        //Observer Pattern Call should be made here to notify the BOTS to bet
    }
    @Override
    public void clear(){
        bjw.getUser().clearBet();
    }
    @Override
    public void distribute()
    {
    }
}
