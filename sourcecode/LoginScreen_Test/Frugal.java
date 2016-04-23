import java.util.Random;
/**
 * Write a description of class Frugal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frugal  implements BettingStrategy
{
    
    // instance variables - replace the example below with your own
   private Bot bot;
   
   public Frugal(){}
   /*public setBot(Bot b)
   {
       bot = b;
    }*/
   public int getBettingAmount()
    {
       int assets =  bot.getAssets();
       Random r = new Random();
       int  n = r.nextInt(2)+1;
       return min(10*n,assets);
       
    }
    
    public int min(int a,int b){
     return a<b?a:b;
    }
}
