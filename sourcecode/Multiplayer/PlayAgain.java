import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayAgain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgain extends Button
{
    private BlackJackWorld bjw = null; 
    private BlackJackMultiPlayer bjm = null;
    public PlayAgain(BlackJackWorld bjw){
        this.bjw = bjw;
    }
     public PlayAgain(BlackJackMultiPlayer bjw){
        this.bjm = bjw;
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            if(bjw != null)
            {
                Greenfoot.setWorld(bjw);
                bjw.startMusic();
                bjw.getUser().drawAsset();
                bjw.getBot1().drawAsset();
                bjw.getBot2().drawAsset();
                bjw.getBot3().drawAsset();
            }
            else
            {
                /*Greenfoot.setWorld(bjw);
              
                bjw.getMP().drawAsset();
                bjw.getBot1().drawAsset();
                bjw.getBot2().drawAsset();
                bjw.getBot3().drawAsset();*/
            }
            
        }
    }
}
