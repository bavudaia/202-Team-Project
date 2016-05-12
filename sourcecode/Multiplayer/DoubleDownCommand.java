/**
 * Write a description of class DoubleDownCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoubleDownCommand implements Command 
{
 
    private BlackJackWorld bjw;
    public void execute(){
        State s = bjw.getCurrentState();
       // System.out.println(s);
        s.doubledown();
    }
    public void setBlackJackWorld(BlackJackWorld p)
    {
        bjw = p;
    }
}
