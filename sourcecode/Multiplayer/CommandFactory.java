
public class CommandFactory  
{
    public Command getCommand(String S)
    {
        Command c = null;
       switch(S)
       {
         case "Hit" : { c = new HitCommand(); break;}
         case "Stand" : {c = new StandCommand() ;break; }
         case "Surrender" : { c = new SurrenderCommand();break;}
         case "DoubleDown" : { c = new DoubleDownCommand(); break;}
       }
       return c;
    }
    
}
