/**
 * Write a description of class InvalidPlayerMove here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InvalidPlayerState extends PlyrState  
{
    BlackJackWorld bjw;
    public InvalidPlayerState(Player p){
        super(p);
    }
    public void doHit()
    {
    }
    public void doStand()
    {
    }
    public void doSurrender()
    {
    }
    public void doDoubleDown()
    {
    }
    
    public void setBlackJackWorld(BlackJackWorld bjw)
    {
        this.bjw = bjw;
    }
}
