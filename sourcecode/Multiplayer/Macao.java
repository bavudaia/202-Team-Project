import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Macao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Macao extends Actor
{
    /**
     * Act - do whatever the Macao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
            public Macao()
    {
        GreenfootImage vegasImage = new GreenfootImage("macao.png");
        vegasImage.scale(400,400);
        setImage(vegasImage);
        setLocation(0,500);
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
