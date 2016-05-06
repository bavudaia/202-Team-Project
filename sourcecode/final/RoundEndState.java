/**
 * Write a description of class RoundEndState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoundEndState  implements State
{
   BlackJackWorld bjw;
   public void bet(int betVal){}
   public void setBlackJackWorld(BlackJackWorld p){
    bjw = p;
    }
    public void done(){
       System.out.println("Round end state");
       DecideWinner dw = new DecideWinner(bjw);
       dw.update();
        
    }
    public void clear(){}
    public void distribute(){}
   
    public void hit(){}
    public void stand(){}
    public void doubledown(){}
    public void surrender(){}
}
