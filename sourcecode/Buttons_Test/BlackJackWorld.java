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
    Dealer dealer;
    User user;
    GameController gc;
    private static Map<Integer,String> cardMap = new HashMap<>();
    Ten ten;
    Twenty twenty;
    Fifty fifty;
    Hundred hundred;
    Clear clear;
        private State currentState;
    private State bettingState;
    private State botBettingState;
    private State cardDistributionState;
    public static Map <Integer,Integer> scoreMap;
    
    static
    {
        scoreMap = new HashMap<>();
        scoreMap.put(0,1);
scoreMap.put(1,2);
scoreMap.put(2,3);
scoreMap.put(3,4);
scoreMap.put(4,5);
scoreMap.put(5,6);
scoreMap.put(6,7);
scoreMap.put(7,8);
scoreMap.put(8,9);
scoreMap.put(9,10);
scoreMap.put(10,10);
scoreMap.put(11,10);
scoreMap.put(12,10);
scoreMap.put(13,1);
scoreMap.put(14,2);
scoreMap.put(15,3);
scoreMap.put(16,4);
scoreMap.put(17,5);
scoreMap.put(18,6);
scoreMap.put(19,7);
scoreMap.put(20,8);
scoreMap.put(21,9);
scoreMap.put(22,10);
scoreMap.put(23,10);
scoreMap.put(24,10);
scoreMap.put(25,10);
scoreMap.put(26,1);
scoreMap.put(27,2);
scoreMap.put(28,3);
scoreMap.put(29,4);
scoreMap.put(30,5);
scoreMap.put(31,6);
scoreMap.put(32,7);
scoreMap.put(33,8);
scoreMap.put(34,9);
scoreMap.put(35,10);
scoreMap.put(36,10);
scoreMap.put(37,10);
scoreMap.put(38,10);
scoreMap.put(39,1);
scoreMap.put(40,2);
scoreMap.put(41,3);
scoreMap.put(42,4);
scoreMap.put(43,5);
scoreMap.put(44,6);
scoreMap.put(45,7);
scoreMap.put(46,8);
scoreMap.put(47,9);
scoreMap.put(48,10);
scoreMap.put(49,10);
scoreMap.put(50,10);
scoreMap.put(51,10);

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
        getBackground().drawImage(new GreenfootImage("blackjackmenu.png"), 0, 0);
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
        gc = new GameController();
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
