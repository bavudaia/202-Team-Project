import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    //User u;
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        {
            State s = p.getCurrentState();
            s.done();
        }
    }    
}
