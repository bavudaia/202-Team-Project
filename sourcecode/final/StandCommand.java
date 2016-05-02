/**
 * Write a description of class StandCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StandCommand implements Command 
{
    // instance variables - replace the example below with your own

    private BlackJackWorld bjw;
    public void execute(){
        State s = bjw.getCurrentState();
        s.stand();
    }
    public void setBlackJackWorld(BlackJackWorld p)
    {
        bjw = p;
    }
}
