/**
 * Write a description of class HardStrategyHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HardStrategyHandler  implements StrategyHandler
{
    StrategyHandler sh;
    public void handle(Player p)
    {
        Strategy s = p.getStrategy();
        if(s instanceof Hard)
        {
                        System.out.println("Chain of responsibility : Hard Strategy");
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
