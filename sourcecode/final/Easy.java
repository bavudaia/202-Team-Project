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
        int flag = 0;
        for(;;)
        {
        Random rand = new Random();
            
        int  n = rand.nextInt(4) + 1;
        switch(n){
            case 1:{
                bot.hit();
                break;
            }
            case 2:{
                flag = 1;
                bot.stand();
                break;
            }
            case 3:{
                flag= 1;
                bot.surrender();
                break;
            }
            case 4:{
                flag =1;
                bot.doubleDown();
                break;
            }
            
        }
        if(flag == 1)
          break;
        }
        
    }
}
