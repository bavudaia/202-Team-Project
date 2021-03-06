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
        if(s instanceof Medium)
        {
                        System.out.println("Chain of responsibility : Medium Strategy");
            s.execute();
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
