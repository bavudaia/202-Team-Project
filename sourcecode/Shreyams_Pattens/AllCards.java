import java.util.Map;
import java.util.HashMap;
/**
 * Write a description of class AllCards here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllCards 
{
    
    public static Map<Integer,String> cardMap = new HashMap<>();
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
    
    public static String getCardImage(int i)
    {
        if(i<0 || i>51)
        {
            throw new IllegalArgumentException("Card Index out of bounds");
        }
        return (String)cardMap.get(i);  
    }
}
