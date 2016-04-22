import java.util.Random;
/**
 * Write a description of class Normal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Normal implements BettingStrategy
{
    private Bot bot;
    public int getBettingAmount()
    {
       int assets =  bot.getAssets();
       Random r = new Random();
       int  n = r.nextInt(8)+3;
       return min(10*n,assets);       
    }
    
    public int min(int a,int b){
     return a<b?a:b;
    }
}
