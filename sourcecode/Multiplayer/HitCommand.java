/**
 * Write a description of class HitCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitCommand implements Command 
{
    // instance variables - replace the example below with your own



    private BlackJackWorld bjw;
    public void execute(){
        State s = bjw.getCurrentState();
       // System.out.println(s.toString());
        s.hit();
    }
    public void setBlackJackWorld(BlackJackWorld p)
    {
        bjw = p;
    }
}
