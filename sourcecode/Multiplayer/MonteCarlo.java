import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MonteCarlo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonteCarlo extends Actor
{
    /**
     * Act - do whatever the MonteCarlo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        public MonteCarlo()
    {
        GreenfootImage vegasImage = new GreenfootImage("montecarlo.png");
        vegasImage.scale(400,400);
        setImage(vegasImage);
        setLocation(500,0);
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
