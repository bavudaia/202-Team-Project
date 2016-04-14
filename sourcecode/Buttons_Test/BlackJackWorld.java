import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackJackWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackJackWorld extends World
{

    /**
     * Constructor for objects of class BlackJackWorld.
     * 
     */
    public BlackJackWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        getBackground().drawImage(new GreenfootImage("blackjackmenu.png"), 0, 0);
        Hit hitButton = new Hit();
        addObject(hitButton,300,500);
        Stand standButton = new Stand();
        addObject(standButton,400,500);
        Surrender surrenderButton = new Surrender();
        addObject(surrenderButton,500,500);
        DoubleDown doubleDownButton = new DoubleDown();
        addObject(doubleDownButton,600,500);
    }
}
