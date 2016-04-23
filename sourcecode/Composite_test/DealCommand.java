/**
 * Write a description of class DealCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DealCommand implements BettingButtonCommand 
{
   User u;
   public void execute()
   {
      u.deal();
   }
   public void setUser(User user)
   {
       u=user;
   }
}
