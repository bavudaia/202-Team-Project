/**
 * Write a description of class Hard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hard  implements Strategy
{
    Bot bot ;
    public void execute(){        
        if(bot.getScore()<=10){
            bot.doubleDown();
        }
        else if(bot.getScore()>10&&bot.getScore()<16){
            bot.hit();
        }
        else {
            bot.stand();
        }
        
    }
    
        public void setBot(Bot b){
        bot = b;
    }
}
