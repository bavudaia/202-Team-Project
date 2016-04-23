/**
 * Write a description of class Ten here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TenCommand  implements BettingButtonCommand
{
   User u;
   public void execute()
   {
       State s = u.getCurrentState();
       s.bet(10);
   }
   public void setUser(User user)
   {
       u=user;
   }
}
