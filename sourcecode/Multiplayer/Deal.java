import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Deal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deal extends BettingButton
{
    /**
     * Act - do whatever the Deal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Player p;
    public Deal()
    {
            GreenfootImage ddImage = new GreenfootImage("deal.png");
        ddImage.scale(80,80);
        setImage(ddImage);
    }
    //User u;
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        {
          World w = getWorld();
          if(w instanceof BlackJackWorld)
          {
              AbstractFactory abf = new AbstractFactory();
              BettingCommandFactory cf = abf.getBettingCommandFactory();
              BettingButtonCommand b = cf.getBettingCommand("Deal");
              b.setBlackJackWorld((BlackJackWorld)getWorld());
              b.execute();       
              BlackJackWorld bjw = (BlackJackWorld)getWorld();
           
              bjw.playClickSound();
          
          }
          else
          {
              
              BlackJackMultiPlayer bjw = (BlackJackMultiPlayer)getWorld();
              MultiPlayer mp = bjw.getMP();
              if(!(mp.getCps()  instanceof DealingState))
                return;
              mp.getFirstCards();
              String dealResult = "";
              String playerId = mp.getName()==null?"null":mp.getName();
              String command  = "Deal";
              String betAmt = String.valueOf(mp.getBetting_amount());
              String asset = String.valueOf(mp.getAssets());
              String score = String.valueOf(mp.getScore());
              List<String> l = mp.getCards();
              String card1 = l.get(0);
              String card2 = l.get(1);
              dealResult = playerId + "," + command + "," +  betAmt +"," +  asset +"," +  score +"," +  card1 +"," +  card2;
              bjw.sendMessage("/greenfoot/player", dealResult);
              mp.setDealerState();
              System.out.println("++");
              if(bjw.getOther().getCps() instanceof DealerState)
              {
                  System.out.println("inside if");
                  //execute the dealer code
                  mp.setValidMultiPlayerState();
                  bjw.getOther().setValidMultiPlayerState();
                  MultiDealer dealer = (MultiDealer)bjw.getDealer();
                  dealer.getFirstCards();
                  String player = mp.getName();
                  String cmd = "DealerUpdate";
                  int dealerscore = bjw.getDealer().getScore();
                  String card = bjw.getDealer().getCards().get(bjw.getDealer().getCards().size()-1);
                  
                  String message = player+","+cmd+","+card+","+dealerscore;
                  bjw.sendMessage("/greenfoot/player", message);
              }
              System.out.println("--");
              //
          }
        }
    }    
}
