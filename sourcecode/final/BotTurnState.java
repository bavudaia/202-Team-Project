/**
 * Write a description of class BotTurnState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotTurnState  implements State
{
   BlackJackWorld bjw;
   public void bet(int betVal){}        
   public void setBlackJackWorld(BlackJackWorld p){bjw=p;}    
   public void clear(){}
   public  void done(){
       Player bot1 = bjw.getBot1();
       Player bot2 = bjw.getBot2();
       Player bot3 = bjw.getBot3();
       
       StrategyHandler she = new EasyStrategyHandler();
       StrategyHandler shm = new MediumStrategyHandler();
       StrategyHandler shh = new HardStrategyHandler();
        shm.setStrategyHandler(shh);
       she.setStrategyHandler(shm);
      
       she.handle(bot1);
       she.handle(bot2);
       she.handle(bot3);
     //  try{
      // Thread.sleep(3000);
    //}
    //catch(Exception e){ System.out.println(e.getMessage()); }
       State s = bjw.getDealerHitState();
       s.done();
    }
    @Override
    public void distribute()
    {
    }
    
           public void hit(){
               
        }
    public void stand(){
    
    }
    public void doubledown(){
    
    }
    public void surrender(){
    
    }
}
