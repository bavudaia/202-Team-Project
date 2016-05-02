/**
 * Write a description of class MediumStrategyHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MediumStrategyHandler  implements StrategyHandler
{
     StrategyHandler sh;
    public void handle(Player p)
    {
        Strategy s = p.getStrategy();
        if(s instanceof Hard)
        {
            
        }
        else
        {
            sh.handle(p);
        }
    }
        public void setStrategyHandler(StrategyHandler sh){
        this.sh = sh;
    }
}
