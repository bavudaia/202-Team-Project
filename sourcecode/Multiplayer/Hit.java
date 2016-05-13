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
          World w = getWorld();
          if(w instanceof BlackJackWorld)
          {
              BlackJackWorld bjw = (BlackJackWorld) getWorld();
              Player p = bjw.getUser();
              bjw.playClickSound();
              AbstractFactory abf = new AbstractFactory();
              CommandFactory cf = abf.getCommandFactory();
              Command c = cf.getCommand("Hit");
              c.setBlackJackWorld(bjw);
              c.execute();
          }
        else
        {
           
              BlackJackMultiPlayer bjw = (BlackJackMultiPlayer) getWorld();
              MultiPlayer mp = bjw.getMP();
               if(mp.getCps()  instanceof InvalidMultiPlayerState)
                return;
              mp.hit();
              String player = mp.getName();
              String cmd= "Addcard";
              String cardName = mp.getCards().get(mp.getCards().size()-1);
              
              String score = String.valueOf(mp.getScore());
              String data = player+","+cmd+"," + cardName + "," + score;
              bjw.sendMessage(data , "/greenfoot/player");
            
          }
        }
     }
}
