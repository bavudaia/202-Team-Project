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
    protected int score;
    private int assets;
    private int betting_amount;
    //protected GameController gc;
    protected int nextX, nextY;
    protected int betX, betY;
    protected int scoreX, scoreY;
    /**
     * Constructor for objects of class Player
     */
    public Player(){
        cards = new ArrayList<String>();
        indexes = new ArrayList<Integer>();
    }
      public int getNextY()
    {
        return nextY;
    }
    public void setScoreY(int y)
    {
        scoreY = y;
    }
      public int getNextX()
    {
        return nextX;
    }
    public void setScoreX(int x)
    {
        scoreX = x;
    }
    
    public int getScoreX()
    {
        return scoreX;
    }

    public int getScoreY()
    {
        return scoreY;
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
 
    public void setNextX(int x)
    {
        nextX = x;
    }
    
    public GameController getGameController()
    {
        return ((BlackJackWorld)getWorld()).getGc();
    }
    /*
    public void setGameController(GameController gc){
        this.gc = gc;
    }
    */
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
        GameController gc = getGameController();
        for(int i=0;i<2;i++)
        {
            
            int cardsLeft = gc.getCardSize();
            Random r = new Random();
            int n = r.nextInt(cardsLeft);
            String cardImage = gc.getCard(n);
           // System.out.println(cardImage);
           // System.out.println("X = " + nextX +" Y = " +nextY);
            this.cards.add(cardImage);            
            this.indexes.add(n);
            gc.remove(n);            
            GreenfootImage gi = new GreenfootImage(cardImage);
            getWorld().getBackground().drawImage(gi,nextX, nextY);
            this.nextX+=50;
        }
        score= getScoreFromCards();
        GreenfootImage black =      getWorld().getBackground();
         /* Overlapping existing image of integer betting amount */
        black.drawImage(new GreenfootImage("Score" + Integer.toString(100000) , 20, Color.BLACK,Color.BLACK),scoreX, scoreY);
        GreenfootImage gfi =      getWorld().getBackground();
        gfi.drawImage(new GreenfootImage("Score" + Integer.toString(score), 20, Color.RED, Color.WHITE),scoreX, scoreY);
        System.out.println(score); 
       
    }
    
    public int getScoreFromCards()
    {
        int score = 0;
        for(String card : cards)
        {
            score += BlackJackWorld.scoreMap.get(card);
        }
        return score;
    }
    
    public void addBet(int betValue)
    {
        this.betting_amount+=betValue;
        this.assets-=betValue;
        
        World w = getWorld();
        
         GreenfootImage black =      w.getBackground();
         /* Overlapping existing image of integer betting amount */
         black.drawImage(new GreenfootImage(Integer.toString(100000), 20, null,null),betX, betY);
              GreenfootImage gfi =      w.getBackground();
       gfi.drawImage(new GreenfootImage(Integer.toString(betting_amount), 20, Color.RED, Color.WHITE),betX, betY);
        System.out.println(score);
    }
    
    public void clearBet()
    {
        this.assets += this.betting_amount;
        this.betting_amount=0;
        
        World w = getWorld();
       /* GreenfootImage gfi =      w.getBackground();
         gfi.drawImage(new GreenfootImage(Integer.toString(betting_amount), 20, Color.RED, Color.WHITE),betX, betY);*/
         GreenfootImage black =      w.getBackground();
         /* Overlapping existing image of integer betting amount */
         black.drawImage(new GreenfootImage(Integer.toString(100000), 20, Color.BLACK,Color.BLACK),betX, betY);

    }

}
