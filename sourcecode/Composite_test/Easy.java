/**
 * Write a description of class Easy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
public class Easy  implements Strategy
{
    Dealer dealer;
    Bot bot ;
    public void execute(){
        
        Random rand = new Random();

        int  n = rand.nextInt(4) + 1;
        switch(n){
            case 1:{
                bot.hit();
                break;
            }
            case 2:{
                bot.stand();
                break;
            }
            case 3:{
                bot.surrender();
                break;
            }
            case 4:{
                bot.doubleDown();
                break;
            }
        }
        
        
    }
}
