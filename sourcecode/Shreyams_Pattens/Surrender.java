import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Surrender here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Surrender extends Button
{
    /**
     * Act - do whatever the Surrender wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Surrender()
    {
        GreenfootImage surrenderImage = new GreenfootImage("surrender.png");
        surrenderImage.scale(Constants.button_height,Constants.button_width);
        setImage(surrenderImage);
    }
    public void act() 
    {
        // Add your action code here.
           if(Greenfoot.mouseClicked(this))
      {
          Player p = new Player();
         Command c =  new SurrenderCommand(p);
         c.execute();
         
        }
    }    
}
