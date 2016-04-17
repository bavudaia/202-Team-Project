import greenfoot.*; 
import java.util.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Player implements Subject
{
    /**
     * Act - do whatever the Dealer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    List<Observer> bots;
    public int getScore()
    {
        return super.getScore();
    }
    public void notifyObserver()
    {
        
        for(Observer o:bots)
        {
            o.update();
        }
    }
    public void addObserver(Observer o)
    {
        bots.add(o);
    }
    public void removeObserver(Observer o)
    {
        bots.remove(o);
    }
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void setScore(int score)
    {
        super.setScore(score);
        notifyObserver();
    }
}
