import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Clear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clear extends BettingButton
{
    /**
     * Act - do whatever the Clear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Clear(){
    GreenfootImage ddImage = new GreenfootImage("clear.png");
        ddImage.scale(Constants.button_height,Constants.button_width);
        setImage(ddImage);
    }
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
       {
          // get player from chain of responsibility
            BettingButtonCommand b = new ClearCommand();
            // b.setUser();//to be implemented later.
             b.setBlackJackWorld((BlackJackWorld)getWorld());
            b.execute();
        }
    }    
}
