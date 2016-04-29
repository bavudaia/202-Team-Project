import greenfoot.*;
import java.util.*;
import java.awt.Color;

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
    protected List<Integer> indexes;
    private int score;
    private int assets;
    private int betting_amount;
    protected GameController gc;
    private int nextX, nextY;
    protected int betX, betY;
    /**
     * Constructor for objects of class Player
     */
    public Player(){
        
    }
    
    public  int getNextY()
    {
        return nextY;
    }
 
    public void setBetY(int y)
    {
        betY = y;
    }
    public void setBetX(int x)
    {
        betX = x;
    }

    public void setNextY(int y)
    {
        nextY = y;
    }
    public int getNextX()
    {
        return nextX;
    }
    public void setNextX(int x)
    {
        nextX = x;
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
            String cardImage = gc.getCard(n);
            this.cards.add(cardImage);            
            this.indexes.add(n);
            gc.remove(n);
            getWorld().getBackground().drawImage(new GreenfootImage(cardImage),nextX, nextY);
            this.nextX+=50;
        }
        //int score=getScoreFromCards();
        //getWorld().getBackground().drawImage(new GreenfootImage(Integer.toString(score), 20, null, null),nextX, nextY+30);
        setScore(getScoreFromCards());
       
    }
    
    public int getScoreFromCards()
    {
        int score = 0;
        for(int cardIndex : indexes)
        {
            score += BlackJackWorld.scoreMap.get(cardIndex);
        }
        return score;
    }
    
    public void addBet(int betValue)
    {
        this.betting_amount+=betValue;
        this.assets-=betValue;
        
        World w = getWorld();
              GreenfootImage gfi =      w.getBackground();
       gfi.drawImage(new GreenfootImage(Integer.toString(betting_amount), 20, Color.RED, Color.WHITE),betX, betY);
        System.out.println(score);
    }
    
    public void clearBet()
    {
        this.assets += this.betting_amount;
        this.betting_amount=0;
        
        World w = getWorld();
        GreenfootImage gfi =      w.getBackground();
         gfi.drawImage(new GreenfootImage(Integer.toString(betting_amount), 20, Color.RED, Color.WHITE),betX, betY);
    }

}
