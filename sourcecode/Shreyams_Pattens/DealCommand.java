/**
 * Write a description of class DealCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DealCommand implements BettingButtonCommand 
{
   BlackJackWorld u;
   public void execute()
   {
      State s = u.getCurrentState();
      s.done();
   }
   public void setBlackJackWorld(BlackJackWorld user)
   {
       u=user;
   }
}
