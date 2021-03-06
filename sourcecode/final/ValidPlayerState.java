/**
 * Write a description of class ValidPlayerState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ValidPlayerState extends PlyrState 
{
    BlackJackWorld bjw;
    public ValidPlayerState(Player p){
        super(p);
    }
    public void setBlackJackWorld(BlackJackWorld b)
    {
        bjw = b;
    }
    public void doHit(BlackJackWorld bjw)
    {
        p.addCard();
        p.score= p.getScoreFromCards();
        if(p.score == 21)
        {
             p.updateScore();
             p.setInvalidPlayerState();
                   //BlackJackWorld bjw = (BlackJackWorld) getWorld();
             bjw.setCurrentState(bjw.getBotTurnState());
             bjw.getCurrentState().done();
        }
        else if(p.score > 21){
            p.userBusted();
            p.updateScore();
            p.setInvalidPlayerState();
                 // BlackJackWorld bjw = (BlackJackWorld) getWorld();
            bjw.setCurrentState(bjw.getBotTurnState());
            bjw.getCurrentState().done();
        }
            //isBusted = true;
            //System.out.println(score);
        p.updateScore();
    }
    public void doStand()
    {
        p.setInvalidPlayerState();
    }
    public void doSurrender()
    { 
        p.setInvalidPlayerState();
        p.userSurrendered();
    }
    public void doDoubleDown()
    {
        System.out.println("doDoubleDown --");
        p.addCard();
        p.score= p.getScoreFromCards();
        p.setInvalidPlayerState();
            //isBusted = true;
            //System.out.println(score);
        int assets = p.getAssets();
        int betting_amount = p.getBetting_amount();
        betting_amount *= 2;
        p.setBetting_amount(betting_amount);
        p.setAssets(assets);
        assets = assets - betting_amount;
         p.updateScore();
        p.drawBet();
        System.out.println("doub down --");
       
    }
}
