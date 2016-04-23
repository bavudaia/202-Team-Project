/**
 * Write a description of class Hundred here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HundredCommand  implements BettingButtonCommand
{
   User u;
   public void execute()
   {
              State s = u.getCurrentState();
       s.bet(100);
   }
   public void setUser(User user)
   {
       u=user;
   }
}
