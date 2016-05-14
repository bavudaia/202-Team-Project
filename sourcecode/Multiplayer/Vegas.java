import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vegas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vegas extends Actor
{
    /**
     * Act - do whatever the Vegas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Vegas()
    {
        GreenfootImage vegasImage = new GreenfootImage("vegas.png");
        vegasImage.scale(350,350);
        setImage(vegasImage);
        setLocation(0,0);
    }
    
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
      {
          BlackJackWorld bjw = new BlackJackWorld();
          Greenfoot.setWorld(bjw);
        }
    }    
}
