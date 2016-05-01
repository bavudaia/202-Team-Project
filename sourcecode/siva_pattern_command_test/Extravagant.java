import java.util.Random;
/**
 * Write a description of class Extravagant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Extravagant  implements BettingStrategy
{
    private Bot bot;
    public int getBettingAmount()
    {
       int assets =  bot.getAssets();
       Random r = new Random();
       int  n = r.nextInt(90)+11;
       return min(10*n,assets);       
    }
    
    public int min(int a,int b){
     return a<b?a:b;
    }

}
