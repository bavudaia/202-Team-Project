import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stand extends Button
{
    /**
     * Act - do whatever the Stand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Stand(){
     GreenfootImage standImage = new GreenfootImage("stand.png");
        standImage.scale(Constants.button_height,Constants.button_width);
        setImage(standImage);
    }
    public void act() 
    {
        // Add your action code here.
                  if(Greenfoot.mouseClicked(this))
      {
          Player p = new Player();
         Command c =  new StandCommand(p);
         c.execute();
         
        }
        
    }    
}
