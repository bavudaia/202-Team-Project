/**
 * Write a description of class StandCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StandCommand implements Command 
{
    // instance variables - replace the example below with your own
    private Player player;

    /**
     * Constructor for objects of class StandCommand
     */
    public StandCommand()
    {
    }
    public StandCommand(Player p){
        player = p;
    }
    
    public void execute(){
        player.stand();
    }

  
}
