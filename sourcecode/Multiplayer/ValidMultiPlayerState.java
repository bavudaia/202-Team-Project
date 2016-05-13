/**
 * Write a description of class ValidMultiPlayerState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ValidMultiPlayerState extends MultiPlayerState 
{
     public ValidMultiPlayerState(MultiPlayer p){
        super(p);
    }
      public void doHit(BlackJackMultiPlayer bjw){
           
                p.addCard();
        p.score= p.getScoreFromCards();
        if(p.score == 21)
        {
             p.updateScore();
             p.setInvalidMultiPlayerState();
            // BlackJackWorld bjw = (BlackJackWorld) getWorld();
            // bjw.setCurrentState(bjw.getBotTurnState());
            // bjw.getCurrentState().done();
        }
        else if(p.score > 21){
            p.userBusted(); 
            p.updateScore();
            p.setInvalidMultiPlayerState();
                 // BlackJackWorld bjw = (BlackJackWorld) getWorld();
           // bjw.setCurrentState(bjw.getBotTurnState());
            //bjw.getCurrentState().done();
        }
            //isBusted = true;
            //System.out.println(score);
        p.updateScore();
        }
    public void doStand(){
      p.setInvalidMultiPlayerState();
              p.userSurrendered();

    }
    public void doSurrender(){
    
      p.setInvalidMultiPlayerState();
    }
    public void doDoubleDown(){
    
      p.addCard();
        p.score= p.getScoreFromCards();
        p.setInvalidMultiPlayerState();
            //isBusted = true;
            //System.out.println(score);
        int assets = p.getAssets();
        int betting_amount = p.getBetting_amount();
        betting_amount *= 2;
        p.setBetting_amount(betting_amount);
        p.setAssets(assets);
        assets = assets - betting_amount;
         p.updateScore();
        p.drawBet();}
     public void setBlackJackWorld(BlackJackMultiPlayer bjw){}
}
