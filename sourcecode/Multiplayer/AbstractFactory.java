/**
 * Write a description of class AbstractFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AbstractFactory  
{
  public CommandFactory getCommandFactory()
  {
      return new CommandFactory();
   }
    
    public BettingCommandFactory getBettingCommandFactory()
    {
        return new BettingCommandFactory();
    }
    
    
}
