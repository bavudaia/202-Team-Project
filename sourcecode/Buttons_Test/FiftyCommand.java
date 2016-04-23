/**
 * Write a description of class Fifty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiftyCommand implements BettingButtonCommand
{
    BlackJackWorld u;
   public void execute()
   {
              State s = u.getCurrentState();
       s.bet(50);
   }
   public void setBlackJackWorld(BlackJackWorld user)
   {
       u=user;
   }
}
