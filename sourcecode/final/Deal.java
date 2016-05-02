import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Deal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deal extends BettingButton
{
    /**
     * Act - do whatever the Deal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Player p;
    public Deal()
    {
            GreenfootImage ddImage = new GreenfootImage("deal.png");
        ddImage.scale(80,80);
        setImage(ddImage);
    }
    //User u;
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        {
                                AbstractFactory abf = new AbstractFactory();
          BettingCommandFactory cf = abf.getBettingCommandFactory();
          BettingButtonCommand b = cf.getBettingCommand("Deal");
            b.setBlackJackWorld((BlackJackWorld)getWorld());
            b.execute();
          
        }
    }    
}
