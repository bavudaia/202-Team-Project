import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class GameController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameController extends Player
{
    /**
     * Act - do whatever the GameController wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
   public GameController(){ cards = new ArrayList<String>();}
    
    public void initialize()
    {
        cards.add("ace_of_spades.png");
cards.add("2_of_spades.png");
cards.add("3_of_spades.png");
cards.add("4_of_spades.png");
cards.add("5_of_spades.png");
cards.add("6_of_spades.png");
cards.add("7_of_spades.png");
cards.add("8_of_spades.png");
cards.add("9_of_spades.png");
cards.add("10_of_spades.png");
cards.add("jack_of_spades.png");
cards.add("queen_of_spades.png");
cards.add("king_of_spades.png");
cards.add("ace_of_clubs.png");
cards.add("2_of_clubs.png");
cards.add("3_of_clubs.png");
cards.add("4_of_clubs.png");
cards.add("5_of_clubs.png");
cards.add("6_of_clubs.png");
cards.add("7_of_clubs.png");
cards.add("8_of_clubs.png");
cards.add("9_of_clubs.png");
cards.add("10_of_clubs.png");
cards.add("jack_of_clubs.png");
cards.add("queen_of_clubs.png");
cards.add("king_of_clubs.png");
cards.add("ace_of_diamonds.png");
cards.add("2_of_diamonds.png");
cards.add("3_of_diamonds.png");
cards.add("4_of_diamonds.png");
cards.add("5_of_diamonds.png");
cards.add("6_of_diamonds.png");
cards.add("7_of_diamonds.png");
cards.add("8_of_diamonds.png");
cards.add("9_of_diamonds.png");
cards.add("10_of_diamonds.png");
cards.add("jack_of_diamonds.png");
cards.add("queen_of_diamonds.png");
cards.add("king_of_diamonds.png");
cards.add("ace_of_hearts.png");
cards.add("2_of_hearts.png");
cards.add("3_of_hearts.png");
cards.add("4_of_hearts.png");
cards.add("5_of_hearts.png");
cards.add("6_of_hearts.png");
cards.add("7_of_hearts.png");
cards.add("8_of_hearts.png");
cards.add("9_of_hearts.png");
cards.add("10_of_hearts.png");
cards.add("jack_of_hearts.png");
cards.add("queen_of_hearts.png");
cards.add("king_of_hearts.png");

    }
    
    public void remove(int index)
    {
        
        if(index>= cards.size() || index <0)
          throw new ArrayIndexOutOfBoundsException();
        cards.remove(index);
    }
    
    public String getCard(int index)
    {
                if(index>= cards.size() || index <0)
          throw new ArrayIndexOutOfBoundsException();
        return cards.get(index);
    }
    
    public int getCardSize()
    {
        return cards.size();
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
