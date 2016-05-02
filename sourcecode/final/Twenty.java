import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Twenty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Twenty extends BettingButton
{
    /**
     * Act - do whatever the Twenty wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Twenty(){
    GreenfootImage ddImage = new GreenfootImage("20.png");
    ddImage.scale(Constants.button_height,Constants.button_width);
    setImage(ddImage);
    }
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
      {
                    AbstractFactory abf = new AbstractFactory();
          BettingCommandFactory cf = abf.getBettingCommandFactory();
          BettingButtonCommand b = cf.getBettingCommand("Twenty");
           
          // get player from chain of responsibility
        
           // b.setUser();//to be implemented later.
           //System.out.println(getWorld().toString());
           b.setBlackJackWorld((BlackJackWorld)getWorld()); 
           b.execute();
        }
    }  
    
    
    
}
