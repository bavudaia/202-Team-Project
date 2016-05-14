import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackJackTable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackJackTable extends Actor
{
   
    public void act() 
    {
        GreenfootImage ddImage = new GreenfootImage("black.png");
        ddImage.scale(100,100);
        setImage(ddImage);
    }    
}
