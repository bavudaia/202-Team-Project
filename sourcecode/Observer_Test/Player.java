import greenfoot.*;
import java.util.List;
/*t
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor  
{
    // instance variables - replace the example below with your own
    private int x;
    private List<String> cards;
    private int score;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
    }
    
    
    public void hit(){
        //to be 
        System.out.println("hit");
        //to be replaced with hit logic
    }
    
    public List<String> getCards(){
      return cards;
    }
    public void setCards(List<String> cards){
     this.cards = cards;
    }
    public void surrender(){
                //to be 

    System.out.println("surrender");
            //to be replaced with surrender logic
    }
    
    
    public void stand(){
            //to be 
        System.out.println("stand");
        //to be replaced with stand logic
    }
    
    public void doubleDown(){
    
            //to be 
        System.out.println("doubledown");
        //to be replaced with doubledown logic
    }
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
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
