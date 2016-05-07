import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Bot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bot extends Player 
{
    /**
     * Act - do whatever the Bot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private BettingStrategy bs;
    public Bot(){
      super();
    }
    public void act() 
    {
        // Add your action code here.
    }    
    public void setBettingStrategy(BettingStrategy bs){
       this.bs=bs;
    }
    

    public void notifyUserDeal()
    {
        int betAmt = bs.getBettingAmount();
         this.assets -=betAmt;
        setBotBetting_amount(betAmt);
    }
        public void setBotBetting_amount(int amt)
    {
        setBetting_amount(amt);   
        World w = getWorld();
        GreenfootImage gfi =      w.getBackground();
        gfi.drawImage(new GreenfootImage("bet" + Integer.toString(100000) , 20, Color.BLACK,Color.BLACK),betX-10, betY - 20);
        gfi.drawString("Bet : " + Integer.toString(getBetting_amount()),betX, betY);

       //gfi.drawImage(new GreenfootImage(Integer.toString(getBetting_amount()), 20, Color.RED, Color.WHITE),betX, betY);
 
    }
   
         public void hit(){
             System.out.println("Inside bot.hit()");
            //if(cps instanceof ValidPlayerState)
            //{
              addCard();
              score= getScoreFromCards();
            if(score == 21)
            {
                 updateScore();
                 setInvalidPlayerState(); 
            }
            else if(score > 21){
                userBusted();
                updateScore();
                setInvalidPlayerState();
          //  setCurrentState(bjw.getBotTurnState());
          //  getCurrentState().done();
        }
            //isBusted = true;
            //System.out.println(score);
        updateScore();
    //}

    }
    public void surrender(){
                     System.out.println("Inside bot.surrender()");
      //  if(cps instanceof ValidPlayerState)
        //{
                setInvalidPlayerState();
                userSurrendered();
          //  }
                //BlackJackWorld bjw = (BlackJackWorld) getWorld();
      //  bjw.setCurrentState(bjw.getBotTurnState());
       // bjw.getCurrentState().done();
                //to be 
         //System.out.println("surrender");
            //to be replaced with surrender logic
    }    
    
    public void stand(){
                     System.out.println("Inside bot.stand()");
           //if(cps instanceof ValidPlayerState)
        //{
                setInvalidPlayerState();
               
          //  }
    }
    
    public void doubleDown(){
                     System.out.println("Inside bot.doubledow()");
         //if(cps instanceof ValidPlayerState)
         //{
             addCard();
        score= getScoreFromCards();
        setInvalidPlayerState();
            //isBusted = true;
            //System.out.println(score);
        int assets = getAssets();
        int betting_amount = getBetting_amount();
        betting_amount *= 2;
        setBetting_amount(betting_amount);
        setAssets(assets);
        assets = assets - betting_amount;
         updateScore();
        drawBet();
        System.out.println("doub down --");       
                
           // }
    }
}
