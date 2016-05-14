import greenfoot.*;
import java.util.*;
public class DecideRemoteWinner  
{
    BlackJackMultiPlayer bjw;
    public DecideRemoteWinner(BlackJackMultiPlayer bjw){
       this.bjw = bjw;
    }
    public void update(){
        //System.out.println("Decide Winner");
        
        MultiPlayer[] p = new MultiPlayer[3];
        p[0] = bjw.getMP();
        p[1] = bjw.getOther();
        p[2]= bjw.getDealer();
           
        ArrayList<MultiPlayer> winners = new ArrayList<MultiPlayer>(); 
        ArrayList<MultiPlayer> losers = new ArrayList<MultiPlayer>();
        ArrayList<MultiPlayer> busted = new ArrayList<MultiPlayer>();
        int max_score = 0;
        int[] score = new int[5];
        score[0] = p[0].getScore();
        max_score =  checkMaxScore(score[0],max_score);
        score[1] = p[1].getScore();
        max_score =  checkMaxScore(score[1],max_score);
        score[2] = p[2].getScore();
        
        for(int i = 0 ; i < 3 ; i++){
           if(score[2] > 21 && score[i] < 21){
               winners.add(p[i]);
               int assets = p[i].getAssets();
               int betAmount = p[i].getBetting_amount();
               assets = assets + 2 * betAmount;
               p[i].setAssets(assets);
               System.out.println("Winner : " + p[i].getName());
           }
           else if(score[i] > 21){
               System.out.println("Busted : " + p[i].getName());
               busted.add(p[i]);
            }
            else if(score[i] < score[2]){
                System.out.println("lost : " + p[i].getName());

                losers.add(p[i]);
            }
            else /*if(score[i] > score[4])*/{
                 System.out.println("Winner : " + p[i].getName());
                   int assets = p[i].getAssets();
               int betAmount = p[i].getBetting_amount();
               assets = assets + 2 * betAmount;
               p[i].setAssets(assets);
                winners.add(p[i]);
            }
        }
        if(winners.size() == 0)
        {
           // System.out.println("Winner : " + p[4].getName());
            winners.add(p[2]);
        }
       
         Result result = new Result(winners, losers , busted , bjw);
         Greenfoot.setWorld(result);
      
    }
    public int checkMaxScore(int score , int maxScore){
        if(score > 21) return maxScore;
        return (score > maxScore)?score:maxScore;
    }
    
}
