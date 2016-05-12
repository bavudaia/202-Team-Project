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
       try{
          // System.out.println("Round end state");
           Thread.sleep(1000);
           DecideWinner dw = new DecideWinner(bjw);
           dw.update();
        }
        catch(Exception e){
            //System.out.println(e.toString());
        }
        
    }
    public void clear(){}
    public void distribute(){}
   
    public void hit(){}
    public void stand(){}
    public void doubledown(){}
    public void surrender(){}
}
