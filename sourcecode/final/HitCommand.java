/**
 * Write a description of class HitCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitCommand implements Command 
{
    // instance variables - replace the example below with your own
    private Player player;

    /**
     * Constructor for objects of class HitCommand
     */
    public HitCommand()
    {
        
    }
    public HitCommand(Player player){
        this.player = player;
    }
    
    public void execute(){
        player.hit();
    }
    public void setPlayer(Player p)
    {
        player = p;
    }
}
