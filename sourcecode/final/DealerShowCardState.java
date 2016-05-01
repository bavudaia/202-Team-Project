/**
 * Write a description of class DealerShowCardState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DealerShowCardState  implements State

{
    
    BlackJackWorld bjw;
      public void bet(int betVal){}
   public void setBlackJackWorld(BlackJackWorld p){ bjw = p;}
    public void done(){
        Dealer dealer = bjw.getDealer();
       // dealer.hitOnce();
       State s = bjw.getUserTurnState();
       
    }
    public void clear(){}
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
