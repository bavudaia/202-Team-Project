import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Bot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bot extends Player implements Observer
{
    /**
     * Act - do whatever the Bot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private BettingStrategy bs;
    public void act() 
    {
        // Add your action code here.
    }    
    public void setBettingStrategy(BettingStrategy bs){
       this.bs=bs;
    }
    @Override
    public void update()
    {
        
    }
    public void notifyUserDeal()
    {
        int betAmt = bs.getBettingAmount();
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
}
