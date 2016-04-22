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
  
    public BlackJackWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        getBackground().drawImage(new GreenfootImage("blackjackmenu.jpg"), 0, 0);
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
}
