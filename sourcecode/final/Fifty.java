import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fifty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fifty extends BettingButton
{
    /**
     * Act - do whatever the Fifty wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Fifty(){
    GreenfootImage ddImage = new GreenfootImage("50.png");
        ddImage.scale(Constants.button_height,Constants.button_width);
        setImage(ddImage);
    }
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
      {
          // get player from chain of responsibility
                               AbstractFactory abf = new AbstractFactory();
          BettingCommandFactory cf = abf.getBettingCommandFactory();
          BettingButtonCommand b = cf.getBettingCommand("Fifty");
            // b.setUser();//to be implemented later.
            b.setBlackJackWorld((BlackJackWorld)getWorld());
            b.execute();
        }
    }    
}
