import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guest extends Button
{
    
    /**
     * Act - do whatever the Guest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        AuthenticationProxy myLogin= new GuestProxy();
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)) 
        {
            myLogin.authenticateLogin("dummy","dummy",getWorld());
        }
    }    
}
