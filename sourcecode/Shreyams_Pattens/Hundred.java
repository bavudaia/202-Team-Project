import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hundred here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hundred extends BettingButton
{
    /**
     * Act - do whatever the Hundred wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Hundred(){
    GreenfootImage ddImage = new GreenfootImage("100.png");
        ddImage.scale(Constants.button_height,Constants.button_width);
        setImage(ddImage);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
      {
          // get player from chain of responsibility
            BettingButtonCommand b = new HundredCommand();
            // b.setUser();//to be implemented later.
            b.setBlackJackWorld((BlackJackWorld)getWorld());
            b.execute();
        }
    }    
}
