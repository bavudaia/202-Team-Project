import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class BlackJackWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackJackWorld extends World
{

    /**
     * Constructor for objects of class BlackJackWorld.
     * 
     */
    Hit hitButton;
    Stand standButton;
    Surrender surrenderButton;
    DoubleDown doubleDownButton;
    Bot bot1;
    Bot bot2;
    Bot bot3;
    //private ArrayList<Bot> bots = new ArrayList<Bot>(); 
    Dealer dealer;
    User user;
    GameController gc;
    private static Map<Integer,String> cardMap = new HashMap<>();
    Ten ten;
    Twenty twenty;
    Fifty fifty;
    Hundred hundred;
    Clear clear;
    Deal deal;
    /* States */
    private State currentState;
    private State bettingState;
    private State botBettingState;
    private State cardDistributionState;
    public static Map <String,Integer> scoreMap;
    
    static
    {
        scoreMap = new HashMap<>();
 scoreMap.put("ace_of_spades.png",1);
scoreMap.put("2_of_spades.png",2);
scoreMap.put("3_of_spades.png",3);
scoreMap.put("4_of_spades.png",4);
scoreMap.put("5_of_spades.png",5);
scoreMap.put("6_of_spades.png",6);
scoreMap.put("7_of_spades.png",7);
scoreMap.put("8_of_spades.png",8);
scoreMap.put("9_of_spades.png",9);
scoreMap.put("10_of_spades.png",10);
scoreMap.put("jack_of_spades.png",10);
scoreMap.put("queen_of_spades.png",10);
scoreMap.put("king_of_spades.png",10);
scoreMap.put("ace_of_clubs.png",1);
scoreMap.put("2_of_clubs.png",2);
scoreMap.put("3_of_clubs.png",3);
scoreMap.put("4_of_clubs.png",4);
scoreMap.put("5_of_clubs.png",5);
scoreMap.put("6_of_clubs.png",6);
scoreMap.put("7_of_clubs.png",7);
scoreMap.put("8_of_clubs.png",8);
scoreMap.put("9_of_clubs.png",9);
scoreMap.put("10_of_clubs.png",10);
scoreMap.put("jack_of_clubs.png",10);
scoreMap.put("queen_of_clubs.png",10);
scoreMap.put("king_of_clubs.png",10);
scoreMap.put("ace_of_diamonds.png",1);
scoreMap.put("2_of_diamonds.png",2);
scoreMap.put("3_of_diamonds.png",3);
scoreMap.put("4_of_diamonds.png",4);
scoreMap.put("5_of_diamonds.png",5);
scoreMap.put("6_of_diamonds.png",6);
scoreMap.put("7_of_diamonds.png",7);
scoreMap.put("8_of_diamonds.png",8);
scoreMap.put("9_of_diamonds.png",9);
scoreMap.put("10_of_diamonds.png",10);
scoreMap.put("jack_of_diamonds.png",10);
scoreMap.put("queen_of_diamonds.png",10);
scoreMap.put("king_of_diamonds.png",10);
scoreMap.put("ace_of_hearts.png",1);
scoreMap.put("2_of_hearts.png",2);
scoreMap.put("3_of_hearts.png",3);
scoreMap.put("4_of_hearts.png",4);
scoreMap.put("5_of_hearts.png",5);
scoreMap.put("6_of_hearts.png",6);
scoreMap.put("7_of_hearts.png",7);
scoreMap.put("8_of_hearts.png",8);
scoreMap.put("9_of_hearts.png",9);
scoreMap.put("10_of_hearts.png",10);
scoreMap.put("jack_of_hearts.png",10);
scoreMap.put("queen_of_hearts.png",10);
scoreMap.put("king_of_hearts.png",10);


    }
    
    public void notifyDeal()
    {
        //for(Bot b : bots){
            bot1.notifyUserDeal();
            bot2.notifyUserDeal();
            bot3.notifyUserDeal();
        //}
    }
    public State getCardDistributionState()
    {
        return cardDistributionState;
    }
    
    public void setCardDistributionState(State s)
    {
           this.cardDistributionState=s;
    }
    
    public User getUser()
    {
        return user;
    }
       public void setCurrentState(State s)
    {
        this.currentState = s;
    }
    public State getCurrentState()
    {
        return currentState;
    }
        public void setBettingState(State s)
    {
        this.bettingState = s;
    }
    public State getBettingState()
    {
        return bettingState;
    }
        public void setBotBettingState(State s)
    {
        this.botBettingState = s;
    }
    public State getBotBettingState()
    {
        return botBettingState;
    }

    public BlackJackWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        getBackground().drawImage(new GreenfootImage("black.png"), 0, 0);
        
        /* State initia;lizayion */
        
             bettingState = new BettingState();
             bettingState.setBlackJackWorld(this);
               botBettingState = new BotBettingState();
               botBettingState.setBlackJackWorld(this);
                cardDistributionState = new CardDistributionState();
                cardDistributionState.setBlackJackWorld(this);
    
        hitButton = new Hit();
        addObject(hitButton,300,500);
        standButton = new Stand();
        addObject(standButton,400,500);
        surrenderButton = new Surrender();
        addObject(surrenderButton,500,500);
        doubleDownButton = new DoubleDown();
        addObject(doubleDownButton,600,500);
        bot1 = new Bot();
        bot2 = new Bot();
        bot3 = new Bot();
        dealer = new Dealer();
        user = new User();
         addObject(user,-100,-100);
          addObject(bot1,-100,-100);
           addObject(bot2,-100,-100); addObject(bot3,-100,-100);
           addObject(dealer,-100,-100);
           
           /* set assets of players */
           
           bot1.setAssets(1000);
           bot2.setAssets(1000);
           bot3.setAssets(1000);
           user.setAssets(1000);
           
        gc = new GameController();
        gc.initialize();
        // betting buttons
        ten = new Ten();
         addObject(ten,300,600);
        twenty = new Twenty();
         addObject(twenty,400,600);
        fifty = new Fifty();
         addObject(fifty,500,600);
        hundred = new Hundred();
         addObject(hundred,600,600);
        clear = new Clear();
         addObject(clear,700,600);
         deal = new Deal();
         addObject(deal, 800,600);
         user.setBetX(Constants.User.betX);
         user.setBetY(Constants.User.betY);
         
         /* initial state is betting state */
         currentState = bettingState;
         
         bot1.setBetX(Constants.Bot1.betX);
         bot1.setBetY(Constants.Bot1.betY);
         bot2.setBetX(Constants.Bot2.betX);
         bot2.setBetY(Constants.Bot2.betY);        
         bot3.setBetX(Constants.Bot3.betX);
         bot3.setBetY(Constants.Bot3.betY);
         
         dealer.setNextX(Constants.Dealer.x);
         dealer.setNextY(Constants.Dealer.y);
         //to be removed 
         //bot1.getFirstCards();;
         /* setting the betting strategy*/
         BettingStrategy e = new Extravagant();
          BettingStrategy n = new Normal();
           BettingStrategy f = new Frugal();
           
           e.setBot(bot1);
           n.setBot(bot2);
           f.setBot(bot3);
         /*Easy*/
         bot1.setBettingStrategy(e);
         /* med*/
         bot2.setBettingStrategy(n);
         /* Hard */
         bot3.setBettingStrategy(f);
         
       user.setNextX(Constants.User.x);
       user.setNextY(Constants.User.y);

       bot1.setNextX(Constants.Bot1.x);
       bot1.setNextY(Constants.Bot1.y);

       bot2.setNextX(Constants.Bot2.x);
       bot2.setNextY(Constants.Bot2.y);

       bot3.setNextX(Constants.Bot3.x);
       bot3.setNextY(Constants.Bot3.y);
       
       user.setScoreX(Constants.User.scoreX);
       user.setScoreY(Constants.User.scoreY);

       bot1.setScoreX(Constants.Bot1.scoreX);
       bot1.setScoreY(Constants.Bot1.scoreY);

       bot2.setScoreX(Constants.Bot2.scoreX);
       bot2.setScoreY(Constants.Bot2.scoreY);

       bot3.setScoreX(Constants.Bot3.scoreX);
       bot3.setScoreY(Constants.Bot3.scoreY);

    }
        public Hit getHitButton() {
        return hitButton;
    }


    public void setHitButton(Hit hitButton) {
        this.hitButton = hitButton;
    }


    public Stand getStandButton() {
        return standButton;
    }


    public void setStandButton(Stand standButton) {
        this.standButton = standButton;
    }


    public Surrender getSurrenderButton() {
        return surrenderButton;
    }


    public void setSurrenderButton(Surrender surrenderButton) {
        this.surrenderButton = surrenderButton;
    }


    public DoubleDown getDoubleDownButton() {
        return doubleDownButton;
    }


    public void setDoubleDownButton(DoubleDown doubleDownButton) {
        this.doubleDownButton = doubleDownButton;
    }


    public Bot getBot1() {
        return bot1;
    }


    public void setBot1(Bot bot1) {
        this.bot1 = bot1;
    }


    public Bot getBot2() {
        return bot2;
    }


    public void setBot2(Bot bot2) {
        this.bot2 = bot2;
    }


    public Bot getBot3() {
        return bot3;
    }


    public void setBot3(Bot bot3) {
        this.bot3 = bot3;
    }


    public Dealer getDealer() {
        return dealer;
    }


    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }




    public void setUser(User user) {
        this.user = user;
    }


    public GameController getGc() {
        return gc;
    }


    public void setGc(GameController gc) {
        this.gc = gc;
    }


    public Ten getTen() {
        return ten;
    }


    public void setTen(Ten ten) {
        this.ten = ten;
    }


    public Twenty getTwenty() {
        return twenty;
    }


    public void setTwenty(Twenty twenty) {
        this.twenty = twenty;
    }


    public Fifty getFifty() {
        return fifty;
    }


    public void setFifty(Fifty fifty) {
        this.fifty = fifty;
    }


    public Hundred getHundred() {
        return hundred;
    }


    public void setHundred(Hundred hundred) {
        this.hundred = hundred;
    }


    public Clear getClear() {
        return clear;
    }


    public void setClear(Clear clear) {
        this.clear = clear;
    }






}
