/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player  
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
    }
    public void hit(){
        System.out.println("hit");
    }
    public void surrender(){
    System.out.println("surrender");
    }
    
    
    public void stand(){}
    
    public void doubleDown(){}
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}