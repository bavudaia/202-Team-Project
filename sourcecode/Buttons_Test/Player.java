import greenfoot.*;
import java.util.*;

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
    protected List<String> cards;
    private int score;
    private int assets;
    private int betting_amount;
    protected GameController gc;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
    }
    public GameController getGameController()
    {
        return gc;
    }
    public void setGameController(GameController gc){
        this.gc = gc;
    }
    public int getAssets() {
        return assets;
    }
    public void setAssets(int assets) {
        this.assets = assets;
    }
    public int getBetting_amount() {
        return betting_amount;
    }
    public void setBetting_amount(int betting_amount) {
        this.betting_amount = betting_amount;
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
    
    public void getFirstCards()
    {
        for(int i=0;i<2;i++)
        {
            int cardsLeft = gc.getCardSize();
            Random r = new Random();
            int n = r.nextInt(cardsLeft);
            this.cards.add(gc.getCard(n));
            gc.remove(i);
        }   
    }

}
