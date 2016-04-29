/**
 * Write a description of class Surrender here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SurrenderCommand implements Command 
{
    // instance variables - replace the example below with your own
    private Player player;
    /**
     * Constructor for objects of class Surrender
     */
    public SurrenderCommand()
    {
    }
    public SurrenderCommand(Player p){
      player = p;
    }
    public void execute(){
        player.surrender();
    }
        public void setPlayer(Player p)
    {
        player = p;
    }
}
