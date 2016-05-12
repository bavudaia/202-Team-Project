import greenfoot.*;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/*t
 * Write a description of class MultiPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiPlayer extends Actor  
{
    // instance variables - replace the example below with your own
    private int x;
    protected List<String> cards;
    protected List<Integer> indexes;
    protected int score;
    protected int assets;
    protected int betting_amount;
    private Boolean isBusted = false;
    private Boolean isSurrendered = false;
    private String name = "";
    
   // private Boolean isDoubleDown = false;
    //protected GameController gc;
    protected int nextX, nextY;
    protected int betX, betY;
    protected int scoreX, scoreY;
    protected int assetX, assetY;
    protected int tempX; 
    protected int tempY;
    MultiPlayerState vps;
    MultiPlayerState ivps;
    MultiPlayerState cps;
    
    /**
     * Constructor for objects of class MultiPlayer
     */
    public MultiPlayer(){
        cards = new ArrayList<String>();
        indexes = new ArrayList<Integer>();
        BlackJackMultiPlayer bjw = (BlackJackMultiPlayer)getWorld();
        vps = new ValidMultiPlayerState(this);
      
        vps.setBlackJackWorld(bjw);
        ivps = new InvalidMultiPlayerState(this);
        ivps.setBlackJackWorld(bjw);
        setInvalidMultiPlayerState();    
    }
    public void setName(String s)
    {
        name = s;
    }
    public String getName()
    {
        return name;
    }
    public void userBusted()
    {
        isBusted = true;
    }
    public void userSurrendered(){
        isSurrendered = true;
    }
    public void  setInvalidMultiPlayerState(){
        cps = ivps;
    }
    public void setValidMultiPlayerState(){
        cps = vps;
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
    public void setAssetX(int x)
    {
        assetX = x;
        drawAsset();
    }
    public void setAssetY(int y)
    {
        assetY = y;
    }
    
    public GameController getGameController()
    {
        return ((BlackJackMultiPlayer)getWorld()).getGc();
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
    public void addCard(){
            
            tempX = 900;
            tempY = 300;
        
            FlipCard fc = new FlipCard();
            BlackJackMultiPlayer bjc = (BlackJackMultiPlayer)getWorld();
            bjc.addObject(fc,900,300);
            double angle = directionToTurnTo(900, 300, nextX, nextY);
            
            for(int j =0 ; true ; j++)
            {
                move(angle,15.0,fc);
                Greenfoot.delay(1);
                if(nextX > tempX - 30)
                    break;
                //turn(-180);
            }
            bjc.removeObject(fc);
          
       
            GameController gc = getGameController();
            int cardsLeft = gc.getCardSize();
            //System.out.println(cardsLeft);
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
            this.nextX+=20;
            Greenfoot.delay(5);
    }
   
    public void updateScore(){
         GreenfootImage black =      getWorld().getBackground();
         Font font = new Font("Serif", Font.BOLD, 18);
        // f.setSize(400,400);
         black.setFont(font);
             /* Overlapping existing image of integer betting amount */
            //black.drawImage(new GreenfootImage("Score" + Integer.toString(100000) , 20, Color.BLACK,Color.BLACK),scoreX, scoreY);
            //GreenfootImage gfi =      getWorld().getBackground();
           // gfi.drawImage(new GreenfootImage("Score" + Integer.toString(score), 20, Color.RED, Color.WHITE),scoreX, scoreY);
           black.drawImage(new GreenfootImage("Score" + Integer.toString(100000) , 20, Color.BLACK,Color.BLACK),scoreX-10, scoreY - 20); 
           black.drawString("Score : " + Integer.toString(score),scoreX, scoreY);
    }
    public void drawBet()
    {
       /* World w = getWorld();
        
        GreenfootImage black =      w.getBackground();
         /* Overlapping existing image of integer betting amount */
       /* black.drawImage(new GreenfootImage(Integer.toString(100000), 20, null,null),betX, betY);
        GreenfootImage gfi =      w.getBackground();
        gfi.drawImage(new GreenfootImage(Integer.toString(betting_amount), 20, Color.RED, Color.WHITE),betX, betY);
        System.out.println("test" + score);*/
         
         GreenfootImage black =  getWorld().getBackground();
         Font font = new Font("Serif", Font.BOLD, 18);
        // f.setSize(400,400);
         black.setFont(font);
             /* Overlapping existing image of integer betting amount */
            black.drawImage(new GreenfootImage("bet" + Integer.toString(100000) , 20, Color.BLACK,Color.BLACK),betX-10, betY - 20);
            //GreenfootImage gfi =      getWorld().getBackground();
           // gfi.drawImage(new GreenfootImage("Score" + Integer.toString(score), 20, Color.RED, Color.WHITE),scoreX, scoreY);
        //  black.drawString("Bet : " +Integer.toString(100000) ,betX, betY);  
         black.drawString("Bet : " + Integer.toString(betting_amount),betX, betY);

    }
   
    public void drawAsset()
    {
       /* World w = getWorld();
        
        GreenfootImage black =      w.getBackground();
         /* Overlapping existing image of integer betting amount */
       /* black.drawImage(new GreenfootImage(Integer.toString(100000), 20, null,null),betX, betY);
        GreenfootImage gfi =      w.getBackground();
        gfi.drawImage(new GreenfootImage(Integer.toString(betting_amount), 20, Color.RED, Color.WHITE),betX, betY);
        System.out.println("test" + score);*/
    
         GreenfootImage black =  getWorld().getBackground();
         Font font = new Font("Serif", Font.BOLD, 18);
        // f.setSize(400,400);
         black.setFont(font);
             /* Overlapping existing image of integer betting amount */
         black.drawImage(new GreenfootImage("bet" + Integer.toString(100000) , 20, Color.BLACK,Color.BLACK),assetX-10, assetY - 20);
            //GreenfootImage gfi =      getWorld().getBackground();
           // gfi.drawImage(new GreenfootImage("Score" + Integer.toString(score), 20, Color.RED, Color.WHITE),scoreX, scoreY);
        //  black.drawString("Bet : " +Integer.toString(100000) ,betX, betY);  
         black.drawString("$" + Integer.toString(assets),assetX, assetY);

    }
    
    public List<String> getCards(){
      return cards;
    }
    public void setCards(List<String> cards){
     this.cards = cards;
    }
    
     public void hit(){
        // System.out.println("hit");
        BlackJackMultiPlayer bjw = (BlackJackMultiPlayer)getWorld(); 
      cps.doHit(bjw);

    }
    public void surrender(){
        
         cps.doSurrender();
         /*BlackJackMultiPlayer bjw = (BlackJackMultiPlayer) getWorld();
        bjw.setCurrentState(bjw.getBotTurnState());
        bjw.getCurrentState().done();*/
                //to be 
         //System.out.println("surrender");
            //to be replaced with surrender logic
    }    
    
    public void stand(){
        cps.doStand();
        
            //to be 
       // System.out.println("stand");
        //to be replaced with stand logic
        /*BlackJackMultiPlayer bjw = (BlackJackMultiPlayer) getWorld();
        bjw.setCurrentState(bjw.getBotTurnState());
        bjw.getCurrentState().done();*/
    }
    
    public void doubleDown(){
        //System.out.println("doubleDown*****************");
        cps.doDoubleDown();
        /*BlackJackMultiPlayer bjw = (BlackJackMultiPlayer) getWorld();
        bjw.setCurrentState(bjw.getBotTurnState());        
        bjw.getCurrentState().done();*/
        
                //to be replaced with doubledown logic
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    public void move(double angle, double speed,Actor fc) {
        angle = Math.toRadians(angle);
        tempX = tempX -  (int)(Math.cos(angle) * speed);
        tempY = tempY - (int)(Math.sin(angle) * speed);
        fc.setLocation(tempX, tempY);
    }
    public void getFirstCards()
    {
        
        GameController gc = getGameController();
        for(int i=0;i<2;i++)
        {
            tempX = 900;
            tempY = 300;
        
            FlipCard fc = new FlipCard();
            BlackJackMultiPlayer bjc = (BlackJackMultiPlayer)getWorld();
            bjc.addObject(fc,900,300);
            double angle = directionToTurnTo(900, 300, nextX, nextY);
            
            for(int j =0 ; true ; j++)
            {
                move(angle,15.0,fc);
                Greenfoot.delay(1);
                if(nextX > tempX - 30)
                    break;
                //turn(-180);
            }
            bjc.removeObject(fc);
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
            this.nextX+=20;
        }
        score= getScoreFromCards();
        updateScore();
        /*GreenfootImage black =      getWorld().getBackground();
         /* Overlapping existing image of integer betting amount */
       /* black.drawImage(new GreenfootImage("Score" + Integer.toString(100000) , 20, Color.BLACK,Color.BLACK),scoreX, scoreY);
        GreenfootImage gfi =      getWorld().getBackground();
        gfi.drawImage(new GreenfootImage("Score" + Integer.toString(score), 20, Color.RED, Color.WHITE),scoreX, scoreY);
        System.out.println(score); */
       
    }
    public double directionToTurnTo(double x, double y,double x1,double y1) {
        return direction(x - x1, y - y1);
    }
    
    public double direction(double deltaX, double deltaY) {
        double direction;
        if(deltaX == 0 && deltaY == 0) {
            direction = 0;
        }
        else if(deltaX == 0 && deltaY < 0) {
            direction = -90;
        }
        else if(deltaX == 0 && deltaY > 0) {
            direction = 90;
        }
        else if(deltaX > 0 && deltaY == 0) {
            direction = 0;
        }
        else if(deltaX < 0 && deltaY == 0) {
            direction = 180;
        }
        else {
            
            int w = (int) Math.toDegrees(Math.atan((double) deltaY / (double) deltaX));
            if(deltaX > 0) {
                direction = w;
            }
            else {
                direction = 180 + w;
            }
           // System.out.println("inside else" + direction);
        }
        return direction;
    }

    
    public int getScoreFromCards()
    {
        int score = 0;
        for(String card : cards)
        {
            score += BlackJackMultiPlayer.scoreMap.get(card);
        }
        return score;
    }
    
    public void addBet(int betValue)
    {
        this.betting_amount+=betValue;
        this.assets-=betValue;
        drawBet();
        drawAsset();
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
         black.drawImage(new GreenfootImage(Integer.toString(1000000000), 20, Color.BLACK,Color.BLACK),betX  , betY - 20);

    }

}
