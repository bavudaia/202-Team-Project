import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Signup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Signup extends Button
{
    /**
     * Act - do whatever the Signup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
             BlackJackRegistration bjr = new BlackJackRegistration();
             Greenfoot.setWorld(bjr);
        }
    }    
}
