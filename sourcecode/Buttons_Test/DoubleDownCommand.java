/**
 * Write a description of class DoubleDownCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoubleDownCommand implements Command 
{
    // instance variables - replace the example below with your own
    private Player player;

    /**
     * Constructor for objects of class DoubleDownCommand
     */
    public DoubleDownCommand()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public void execute(){
     player.doubleDown();
    }

}
