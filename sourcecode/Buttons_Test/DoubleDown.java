import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoubleDown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoubleDown extends Button
{
    /**
     * Act - do whatever the DoubleDown wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public DoubleDown(){
     GreenfootImage ddImage = new GreenfootImage("doubledown.png");
        ddImage.scale(Constants.button_height,Constants.button_width);
        setImage(ddImage);
    }
    public void act() 
    {
        // Add your action code here.
               
        
           if(Greenfoot.mouseClicked(this))
      {
          // get player from chain of responsibility
         Player p = new Player();
         //
         Command c =  new DoubleDownCommand(p);
         c.execute();
         
        }
    }    
}
