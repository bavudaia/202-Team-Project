import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ten here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ten extends BettingButton
{
    /**
     * Act - do whatever the Ten wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
              if(Greenfoot.mouseClicked(this))
      {
          World w  = getWorld();
          if(w instanceof BlackJackWorld)
          {
            BlackJackWorld bjw = (BlackJackWorld)getWorld();
            bjw.playClickSound(); 
            AbstractFactory abf = new AbstractFactory();
            BettingCommandFactory cf = abf.getBettingCommandFactory();
            BettingButtonCommand b = cf.getBettingCommand("Ten");
            // b.setUser();//to be implemented later.
             b.setBlackJackWorld((BlackJackWorld)getWorld());
             b.execute();
          }
          else
          {
              BlackJackMultiPlayer bjw = (BlackJackMultiPlayer)getWorld();
              bjw.startMqttCallback();
              MultiPlayer mp = bjw.getMP();
              if(!(mp.getCps()  instanceof DealingState))
                return;
              mp.addBet(10);
          }
          // get player from chain of responsibility
          
        }
    }
    public Ten(){
        GreenfootImage ddImage = new GreenfootImage("10.png");
        ddImage.scale(Constants.button_height,Constants.button_width);
        setImage(ddImage);
    }
}
