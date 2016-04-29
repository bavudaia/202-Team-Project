import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.awt.*;
/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Player implements Observer
{
    /**
     * Act - do whatever the Dealer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Dealer()
    {
        
            GreenfootImage ddImage = new GreenfootImage("50.png");
        ddImage.scale(Constants.button_height,Constants.button_width);
        setImage(ddImage);
    }
    @Override
    public void getFirstCards()
    {
         for(int i=0;i<1;i++)
        {
            
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
            this.nextX+=50;
            
        }
        
        score= getScoreFromCards();
        GreenfootImage black =      getWorld().getBackground();
         /* Overlapping existing image of integer betting amount */
        black.drawImage(new GreenfootImage("Score" + Integer.toString(100000) , 20, Color.BLACK,Color.BLACK),scoreX, scoreY);
        GreenfootImage gfi =      getWorld().getBackground();
        gfi.drawImage(new GreenfootImage("Score" + Integer.toString(score), 20, Color.RED, Color.WHITE),scoreX, scoreY);
        System.out.println("scoreX :" + scoreX + "scoreY :"+ scoreY);
        System.out.println(score); 
    }
    public void update()
    {
        
    }
    public void act() 
    {
        // Add your action code here.
    }    
   
     public void addBet(int betValue)
    {
        //do nothing
    }
    
    public void clearBet()
    {
        //do nothing
    }
}
