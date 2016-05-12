/**
 * Write a description of class BettingCommandFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BettingCommandFactory  
{
   public BettingButtonCommand getBettingCommand(String S)
   {
       BettingButtonCommand bbc = null;
       switch(S)
       {
           case "Ten" :{ bbc = new TenCommand(); break;}
           case "Twenty" : {bbc = new TwentyCommand(); break;}
           case "Fifty" : {bbc = new FiftyCommand(); break;}
           case "Hundred" : {bbc = new HundredCommand(); break;}
           case "Clear" : {bbc = new ClearCommand(); break;}
           case "Deal" :{ bbc = new DealCommand(); break; }
        }
        return bbc;
    }
}
