/**
 * Write a description of class PlayerState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface PlayerState  
{
    public void doHit(BlackJackWorld bjw);
    public void doStand();
    public void doSurrender();
    public void doDoubleDown();
     public void setBlackJackWorld(BlackJackWorld bjw);
}
