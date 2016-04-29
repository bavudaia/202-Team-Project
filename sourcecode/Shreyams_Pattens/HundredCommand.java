/**
 * Write a description of class Hundred here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HundredCommand  implements BettingButtonCommand
{
   BlackJackWorld bjw;
   public void execute()
   {
       State s = bjw.getCurrentState();
       s.bet(100);
   }
   public void setBlackJackWorld(BlackJackWorld bjw)
   {
       this.bjw = bjw;
   }
}
