/**
 * Write a description of class InvalidMultiPlayerState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DealingState extends MultiPlayerState 
{
 //    MultiPlayer p;
     public DealingState(MultiPlayer p){
        super(p);
    }
      public void doHit(BlackJackMultiPlayer bjw){}
    public void doStand(){}
    public void doSurrender(){}
    public void doDoubleDown(){}
     public void setBlackJackWorld(BlackJackMultiPlayer bjw){}
}
