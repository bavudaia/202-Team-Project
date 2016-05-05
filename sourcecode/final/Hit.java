import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hit extends Button
{
    /**
     * Act - do whatever the Hit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Hit()
    {
        GreenfootImage hitImage = new GreenfootImage("hit.png");
        hitImage.scale(Constants.button_height,Constants.button_width);
        setImage(hitImage);
    }
    public void act() 
    {    
      if(Greenfoot.mouseClicked(this))
      {
          BlackJackWorld bjw = (BlackJackWorld) getWorld();
          Player p = bjw.getUser();
          AbstractFactory abf = new AbstractFactory();
          CommandFactory cf = abf.getCommandFactory();
          Command c = cf.getCommand("Hit");
          c.setBlackJackWorld(bjw);
          c.execute();
        }
     }
}
