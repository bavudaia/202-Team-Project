/**
 * Write a description of class Twenty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwentyCommand  implements BettingButtonCommand 
{
   BlackJackWorld u;
   public void execute()
   {
       State s = u.getCurrentState();
       s.bet(20);
   }
   public void setBlackJackWorld(BlackJackWorld user)
   {
       u=user;
   }
}
