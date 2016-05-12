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
                    BlackJackWorld bjw = (BlackJackWorld) getWorld();
                    bjw.playClickSound();
          Player p = bjw.getUser();

                  AbstractFactory abf = new AbstractFactory();
          CommandFactory cf = abf.getCommandFactory();
          Command c = cf.getCommand("Surrender");
          c.setBlackJackWorld(bjw);
          c.execute();
         
        }
    }    
}
