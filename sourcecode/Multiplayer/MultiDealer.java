import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MultiDealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiDealer extends MultiPlayer
{
   
    public void act() 
    {
        // Add your action code here.
    }    
    public void getFirstCards()
{
    for(int i=0;i<1;i++)
    {
        tempX = 900;
        tempY = 300;
    
        FlipCard fc = new FlipCard();
        BlackJackMultiPlayer bjc = (BlackJackMultiPlayer)getWorld();
        bjc.addObject(fc,900,300);
        double angle = directionToTurnTo(900, 300, nextX, nextY);
        
        for(int j =0 ; true ; j++)
        {
            move(angle,15.0,fc);
            Greenfoot.delay(1);
            if(nextX > tempX - 30)
                break;
            //turn(-180);
        }
        bjc.removeObject(fc);
        GameController gc = getGameController();
        int cardsLeft = gc.getCardSize();
        Random r = new Random();
        int n = r.nextInt(cardsLeft);
        String cardImage = gc.getCard(n);
         //System.out.println(cardImage);
        //System.out.println("X = " + nextX +" Y = " +nextY);
        this.cards.add(cardImage);
        gc.remove(n);
        GreenfootImage gi = new GreenfootImage(cardImage);
        getWorld().getBackground().drawImage(gi,nextX, nextY);
        this.nextX+=20;
        
    }
    
    score= getScoreFromCards();
    GreenfootImage black =      getWorld().getBackground();
     
    updateScore();
  }
    public void hit()
    {
         BlackJackMultiPlayer bjc = (BlackJackMultiPlayer)getWorld();
        while(score<=14)
        {
            addCard();
            
            String player = bjc.getMP().getName();
            String cmd= "DealerAddCard";
            score = getScoreFromCards();
            String cardName = this.getCards().get(this.getCards().size()-1);
              
              
              String data = player+","+cmd+"," + cardName + "," + score;
              bjc.sendMessage( "/greenfoot/player",data);
            
        }
        updateScore();
    }
}
