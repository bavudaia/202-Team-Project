import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class User here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class User extends Player implements Observer
{
    /**
     * Act - do whatever the User wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
    }
    public void deal()
    {
        
    }
    @Override
    public void update(int amount)
    {
        int currentAmount = getAssets();
        setAssets(currentAmount + amount);
        
        
    }
}
