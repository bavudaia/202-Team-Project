import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackJackRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackJackRoom extends World
{

    /**
     * Constructor for objects of class BlackJackRoom.
     * 
     */
    public BlackJackRoom()
    {    
        super(1200, 800, 1);
        getBackground().drawImage(new GreenfootImage("black_room.jpg"), 0, 0);
       //  addObject(new BlackJackTable(), 0, 0);
    }
}
