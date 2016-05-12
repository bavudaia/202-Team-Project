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
           World w = getWorld();
          if(w instanceof BlackJackWorld)
          {
              BlackJackWorld bjw = (BlackJackWorld)getWorld();
              bjw.playClickSound();
              AbstractFactory abf = new AbstractFactory();
              BettingCommandFactory cf = abf.getBettingCommandFactory();
              BettingButtonCommand b = cf.getBettingCommand("Twenty");
              b.setBlackJackWorld(bjw); 
              b.execute();
          }
          else
          {
              BlackJackMultiPlayer bjw = (BlackJackMultiPlayer)getWorld();
              MultiPlayer mp = bjw.getMP();
              mp.addBet(20);
          }
      }
    }  
    
    
    
}
