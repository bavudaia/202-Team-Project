import greenfoot.*;
/**
 * Write a description of class ClearButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ClearCommand implements BettingButtonCommand
{
   BlackJackWorld u;
   public void execute()
   {
       State s = u.getCurrentState();
       System.out.println("clear state " + u.getCurrentState());
       s.clear();
   }
   public void setBlackJackWorld(BlackJackWorld user)
   {
       u=user;
   }
}
