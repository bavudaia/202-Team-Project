import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayAgain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgain extends Button
{
    private BlackJackWorld bjw; 
    public PlayAgain(BlackJackWorld bjw){
        this.bjw = bjw;
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.setWorld(bjw);
            bjw.startMusic();
        }
    }
}
