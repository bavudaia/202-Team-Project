/**
 * Write a description of class Screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Screen implements Observer
{
   Subject bjw; 
   public void update()
   {
       State s=bjw.getCurrentState();
       if(s instanceof BettingState)
       {
           System.out.println("Betting State");
       }
       
       else if(s instanceof BotBettingState)
       {
           System.out.println("Bot Betting State");
       }
       
       else if(s instanceof BotTurnState)
       {
           System.out.println("Bot Turn State");
       }
   }
   
   public void setBlackJackWorld(BlackJackWorld bjw)
   {this .bjw = bjw;
    }
   
   
   
}
