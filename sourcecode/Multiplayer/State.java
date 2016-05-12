/**
 * Write a description of class State here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface State  
{
    // instance variables - replace the example below with your own
    //States- 1. Betting 1.a.Idle 2. CardDistribution 3. ActionState 4. DealerAction
   public void bet(int betVal);
   public void setBlackJackWorld(BlackJackWorld p);
    public void done();
    public void clear();
    public void distribute();
   
    public void hit();
    public void stand();
    public void doubledown();
    public void surrender();
}
