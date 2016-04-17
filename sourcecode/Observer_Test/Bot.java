import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bot extends Player implements Observer
{
    /**
     * Act - do whatever the Bot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Subject dealer;
    public void update()
    {
        int dealerScore=dealer.getScore();
        System.out.println(dealerScore);
        
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
