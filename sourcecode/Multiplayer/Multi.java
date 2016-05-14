import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Multi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Multi extends Actor
{
    /**
     * Act - do whatever the Multi wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
                public Multi()
    {
        GreenfootImage vegasImage = new GreenfootImage("multi.png");
        vegasImage.scale(400,400);
        setImage(vegasImage);
        setLocation(500,500);
       
    }
    public void act() 
    {
        // Add your action code here.
                if(Greenfoot.mouseClicked(this))
      {
         
          BlackJackRoom bjr = (BlackJackRoom)getWorld();
          bjr.sendMessage("/greenfoot/client","player"+bjr.playerId);
          int id = bjr.playerId;
          
           BlackJackMultiPlayer bjw = new BlackJackMultiPlayer(id);// send player id
          Greenfoot.setWorld(bjw);
           
        }
    }    
}
