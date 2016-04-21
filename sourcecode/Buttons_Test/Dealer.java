import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Player
{
    /**
     * Act - do whatever the Dealer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    @Override
        public void getFirstCards()
    {
            for(int i=0;i<1;i++)
        {
            int cardsLeft = gc.getCardSize();
            Random r = new Random();
            int n = r.nextInt(cardsLeft);
            this.cards.add(gc.getCard(n));
            gc.remove(i);
        }   
    }
}
