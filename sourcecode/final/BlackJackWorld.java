import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class BlackJackWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackJackWorld extends World implements Subject
{

    /**
     * Constructor for objects of class BlackJackWorld.
     * 
     */
    private List<Observer> screenList;
    public  GreenfootSound backgroudmusic = new GreenfootSound("WastedYears.mp3");
    public  GreenfootSound clickSound = new GreenfootSound("click.mp3");
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
    
    static int background ;
    /* States */
    private State currentState;
    private State bettingState;
    private State botBettingState;
    private State cardDistributionState;
    private State userTurnState;
    private State botTurnState;
    private State dealerHitState;
    private State roundEndState;
    
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
    

    public void notifyObservers()
    {
        for(Observer o:screenList)
        o.update();
    }
    
    public void addObserver(Observer o)
    {
        screenList.add(o);
    }
    
    public void removeObserver(Observer o)
    {
        screenList.remove(o);
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
    public void stopMusic()
    {
        backgroudmusic.stop();
    }
    
    public User getUser()
    {
        return user;
    }
       public void setCurrentState(State s)
    {
        this.currentState = s;
        notifyObservers();
    }
    public State getCurrentState()
    {
        return currentState;
    }
        public void setBettingState(State s)
    {
        this.bettingState = s;
    }
    
        public State getUserTurnState() {
        return userTurnState;
    }


    public void setUserTurnState(State userTurnState) {
        this.userTurnState = userTurnState;
    }


    public State getBotTurnState() {
        return botTurnState;
    }


    public void setBotTurnState(State botTurnState) {
        this.botTurnState = botTurnState;
    }
    
    public State getRoundEndState() {
        return roundEndState;
    }


    public void setRoundEndState(State botTurnState) {
        this.roundEndState = botTurnState;
    }



    public State getDealerHitState() {
        return dealerHitState;
    }


    public void setDealerHitState(State dealerHitState) {
        this.dealerHitState = dealerHitState;
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
       startMusic();
       // backgroudmusic.stop();
        screenList=new ArrayList<>();
        Observer sc  = new Screen();
        sc.setBlackJackWorld(this);
        addObserver(sc);
        Random rand = new Random();
        //int  num = rand.nextInt(4) + 1;
        /*int num =  BlackJackWorld.background;
        if(num == 1)
            getBackground().drawImage(new GreenfootImage("blue.png"), 0, 0);
        else if(num==2)
            getBackground().drawImage(new GreenfootImage("brown.png"), 0, 0);
        else*/
            getBackground().drawImage(new GreenfootImage("black.png"), 0, 0);
            //getBackground().drawImage(new GreenfootImage("user.png"), 100, 100);
         BlackJackWorld.background =  (BlackJackWorld.background + 1) % 4;
        GreenfootImage userImage = new GreenfootImage("user.png");

        userImage.scale(80,80);
        getBackground().drawImage(userImage, 200, 400);
        drawUserName("User", 220,500);
        getBackground().drawImage(userImage, 510, 400);
        drawUserName("Bot1", 530,500);
        getBackground().drawImage(userImage, 30, 60); 
        drawUserName("Bot2", 50,160);
        getBackground().drawImage(userImage, 510, 100);
        drawUserName("Bot3", 530,200);
        userImage.scale(60,60);
        getBackground().drawImage(userImage, 330, 250);
        drawUserName("Dealer", 335,325);
        /* State initia;lizayion */
        
        bettingState = new BettingState();
        bettingState.setBlackJackWorld(this);
        botBettingState = new BotBettingState();
        botBettingState.setBlackJackWorld(this);
        cardDistributionState = new CardDistributionState();
        cardDistributionState.setBlackJackWorld(this);
        userTurnState = new UserTurnState();
        userTurnState.setBlackJackWorld(this);
        botTurnState = new BotTurnState();
        botTurnState.setBlackJackWorld(this);
        dealerHitState = new DealerHitState();
        dealerHitState.setBlackJackWorld(this);
        roundEndState = new RoundEndState();
        roundEndState.setBlackJackWorld(this);
        
        hitButton = new Hit();
        addObject(hitButton,350,700);
        standButton = new Stand();
        addObject(standButton,450,700);
        surrenderButton = new Surrender();
        addObject(surrenderButton,550,700);
        doubleDownButton = new DoubleDown();
        System.out.println();
        addObject(doubleDownButton,650,700);
        addObject(new FlipCard(),900,300);
        bot1 = new Bot();
        bot1.setName("Bot1");
        bot2 = new Bot();
        bot2.setName("Bot2");
        bot3 = new Bot();
        bot3.setName("Bot3");
        dealer = new Dealer();
        dealer.setName("Dealer");
        user = new User();
        user.setName("user");
         addObject(user,-100,-100);
          addObject(bot1,-100,-100);
           addObject(bot2,-100,-100); 
           addObject(bot3,-100,-100);
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
         addObject(deal, 800,665);
         user.setBetX(Constants.User.betX);
         user.setBetY(Constants.User.betY);
         
         /* initial state is betting state */
          setCurrentState(bettingState);
         
         bot1.setBetX(Constants.Bot1.betX);
         bot1.setBetY(Constants.Bot1.betY);
         bot2.setBetX(Constants.Bot2.betX);
         bot2.setBetY(Constants.Bot2.betY);        
         bot3.setBetX(Constants.Bot3.betX);
         bot3.setBetY(Constants.Bot3.betY);
         
         dealer.setNextX(Constants.Dealer.x);
         dealer.setNextY(Constants.Dealer.y);
         
         user.setAssetX(Constants.User.assetX);
         user.setAssetY(Constants.User.assetY);
         
         bot1.setAssetX(Constants.Bot1.assetX);
         bot1.setAssetY(Constants.Bot1.assetY);
         
         bot2.setAssetX(Constants.Bot2.assetX);
         bot2.setAssetY(Constants.Bot2.assetY);
         
         bot3.setAssetX(Constants.Bot3.assetX);
         bot3.setAssetY(Constants.Bot3.assetY);
         
         
         Strategy e = new Easy();
         Strategy n = new Medium();
         Strategy h = new Hard();
         e.setBot(bot1);
         n.setBot(bot2);
         h.setBot(bot3);
         
         bot1.setStrategy(e);
         bot2.setStrategy(n);
         bot3.setStrategy(h);         
         /* setting the betting strategy*/
         BettingStrategy eb = new Extravagant();
          BettingStrategy nb = new Normal();
           BettingStrategy fb = new Frugal();
           
           eb.setBot(bot1);
           nb.setBot(bot2);
           fb.setBot(bot3);
           
         /*Easy*/
         bot1.setBettingStrategy(eb);
         /* med*/
         bot2.setBettingStrategy(nb);
         /* Hard */
         bot3.setBettingStrategy(fb);
         
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
       
       dealer.setScoreX(Constants.Dealer.scoreX);
       dealer.setScoreY(Constants.Dealer.scoreY);
      
       user.drawAsset();
       bot1.drawAsset();
       bot2.drawAsset();
       bot3.drawAsset();

    }
        public Hit getHitButton() {
        return hitButton;
    }
    public void startMusic()
    {
        backgroudmusic.setVolume(20);
         backgroudmusic.playLoop();
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

    public void playClickSound()
    {
        //clickSound.setVolume(5);
        clickSound.play();
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

    public void drawUserName(String s , int x , int y){
         GreenfootImage black = getBackground();
         Font font = new Font("Serif", Font.BOLD, 18);
         black.setFont(font);
         //black.drawImage(new GreenfootImage("Score" + Integer.toString(100000) , 20, Color.BLACK,Color.BLACK),scoreX-10, scoreY - 20); 
         black.drawString(s,x, y);
    }




}
