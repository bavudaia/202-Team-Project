/**
 * Write a description of class Screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import greenfoot.*;
public class Screen implements Observer
{
   Subject bjw; 
   public void update()
   {
       State s=bjw.getCurrentState();
       BlackJackWorld y = (BlackJackWorld)bjw;
                   GreenfootImage black = y.getBackground();
         Font font = new Font("Serif", Font.BOLD, 18);
        // f.setSize(400,400);
         black.setFont(font);
             /* Overlapping existing image of integer betting amount */
          black.drawImage(new GreenfootImage("betting state assdfasdasdfasdfasdffn" , 30, Color.BLACK,Color.BLACK),Constants.Screen.x - 10, Constants.Screen.y-20);
       if(s instanceof BettingState)
       {
          // System.out.println("Betting State");
           

         BlackJackWorld x = (BlackJackWorld)bjw;
         x.drawUserName("Betting State",Constants.Screen.x,Constants.Screen.y);
       }
       
       else if(s instanceof BotBettingState)
       {
            BlackJackWorld x = (BlackJackWorld)bjw;
 x.drawUserName("Bot Betting State",Constants.Screen.x,Constants.Screen.y);
       }
       
       else if(s instanceof BotTurnState)
       {
            BlackJackWorld x = (BlackJackWorld)bjw;
           x.drawUserName("Bot Turn State",Constants.Screen.x,Constants.Screen.y);
       }
        else if(s instanceof RoundEndState)
      {            BlackJackWorld x = (BlackJackWorld)bjw;
           x.drawUserName("Round End State",Constants.Screen.x,Constants.Screen.y);

        }
        else if(s instanceof CardDistributionState)
        {
                        BlackJackWorld x = (BlackJackWorld)bjw;
           x.drawUserName("Card Distribution State",Constants.Screen.x,Constants.Screen.y);
        }
        else if(s instanceof UserTurnState)
        {
                        BlackJackWorld x = (BlackJackWorld)bjw;
           x.drawUserName("User Turn State",Constants.Screen.x,Constants.Screen.y);

        }
        else if(s instanceof DealerHitState)
        {
                        BlackJackWorld x = (BlackJackWorld)bjw;
           x.drawUserName("Dealer Hit State",Constants.Screen.x,Constants.Screen.y);
        }
        
   }
   
   public void setBlackJackWorld(BlackJackWorld bjw)
   {this .bjw = bjw;
    }
   
   
   
}
