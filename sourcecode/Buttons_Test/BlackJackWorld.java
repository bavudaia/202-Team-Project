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
    List<Card> cards;
    private static Map<Integer,String> cardMap = new HashMap<>();
    Ten ten;
    Twenty twenty;
    Fifty fifty;
    Hundred hundred;
    Clear clear;
    static {
        cardMap.put(0,"ace_of_spades.png");
cardMap.put(1,"2_of_spades.png");
cardMap.put(2,"3_of_spades.png");
cardMap.put(3,"4_of_spades.png");
cardMap.put(4,"5_of_spades.png");
cardMap.put(5,"6_of_spades.png");
cardMap.put(6,"7_of_spades.png");
cardMap.put(7,"8_of_spades.png");
cardMap.put(8,"9_of_spades.png");
cardMap.put(9,"10_of_spades.png");
cardMap.put(10,"jack_of_spades.png");
cardMap.put(11,"queen_of_spades.png");
cardMap.put(12,"king_of_spades.png");
cardMap.put(13,"ace_of_clubs.png");
cardMap.put(14,"2_of_clubs.png");
cardMap.put(15,"3_of_clubs.png");
cardMap.put(16,"4_of_clubs.png");
cardMap.put(17,"5_of_clubs.png");
cardMap.put(18,"6_of_clubs.png");
cardMap.put(19,"7_of_clubs.png");
cardMap.put(20,"8_of_clubs.png");
cardMap.put(21,"9_of_clubs.png");
cardMap.put(22,"10_of_clubs.png");
cardMap.put(23,"jack_of_clubs.png");
cardMap.put(24,"queen_of_clubs.png");
cardMap.put(25,"king_of_clubs.png");
cardMap.put(26,"ace_of_diamonds.png");
cardMap.put(27,"2_of_diamonds.png");
cardMap.put(28,"3_of_diamonds.png");
cardMap.put(29,"4_of_diamonds.png");
cardMap.put(30,"5_of_diamonds.png");
cardMap.put(31,"6_of_diamonds.png");
cardMap.put(32,"7_of_diamonds.png");
cardMap.put(33,"8_of_diamonds.png");
cardMap.put(34,"9_of_diamonds.png");
cardMap.put(35,"10_of_diamonds.png");
cardMap.put(36,"jack_of_diamonds.png");
cardMap.put(37,"queen_of_diamonds.png");
cardMap.put(38,"king_of_diamonds.png");
cardMap.put(39,"ace_of_hearts.png");
cardMap.put(40,"2_of_hearts.png");
cardMap.put(41,"3_of_hearts.png");
cardMap.put(42,"4_of_hearts.png");
cardMap.put(43,"5_of_hearts.png");
cardMap.put(44,"6_of_hearts.png");
cardMap.put(45,"7_of_hearts.png");
cardMap.put(46,"8_of_hearts.png");
cardMap.put(47,"9_of_hearts.png");
cardMap.put(48,"10_of_hearts.png");
cardMap.put(49,"jack_of_hearts.png");
cardMap.put(50,"queen_of_hearts.png");
cardMap.put(51,"king_of_hearts.png");


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
