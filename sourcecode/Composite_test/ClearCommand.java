import greenfoot.*;
/**
 * Write a description of class ClearButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ClearCommand implements BettingButtonCommand  
{
   User u;
   public void execute()
   {
              State s = u.getCurrentState();
       s.clear();
   }
   public void setUser(User user)
   {
       u=user;
   }
}
