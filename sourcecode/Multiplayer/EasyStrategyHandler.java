/**
 * Write a description of class EasyStrategyHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EasyStrategyHandler  implements StrategyHandler
{
     StrategyHandler sh;
    public void handle(Player p)
    {
        Strategy s = p.getStrategy();
        if(s instanceof Easy)
        {
          //  System.out.println("Chain of responsibility : Easy Strategy");
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
