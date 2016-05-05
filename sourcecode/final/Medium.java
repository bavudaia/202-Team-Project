/**
 * Write a description of class Medium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medium  implements Strategy
{
    //Dealer dealer;
    Bot bot ;
    public void execute(){     
        while(bot.getScore()<=12){
            bot.hit();
        }
        
            bot.stand();            
        
    }
    
        public void setBot(Bot b){
        bot = b;
    }
  }
