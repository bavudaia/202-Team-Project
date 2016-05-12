import greenfoot.*;
import java.util.*;
public class DecideWinner  
{
    BlackJackWorld bjw;
    public DecideWinner(BlackJackWorld bjw){
       this.bjw = bjw;
    }
    public void update(){
        //System.out.println("Decide Winner");
        
        Player[] p = new Player[5];
        p[0] = bjw.getUser();
        p[1] = bjw.getBot1();
        p[2]= bjw.getBot2();
        p[3] = bjw.getBot3();
        p[4] = bjw.getDealer();
        
        ArrayList<Player> winners = new ArrayList<Player>(); 
        ArrayList<Player> losers = new ArrayList<Player>();
        ArrayList<Player> busted = new ArrayList<Player>();
        int max_score = 0;
        int[] score = new int[5];
        score[0] = p[0].getScore();
        max_score =  checkMaxScore(score[0],max_score);
        score[1] = p[1].getScore();
        max_score =  checkMaxScore(score[1],max_score);
        score[2] = p[2].getScore();
        max_score =  checkMaxScore(score[2],max_score);
        score[3] = p[3].getScore();
        max_score =  checkMaxScore(score[3],max_score);
        score[4] = p[4].getScore();
        max_score =  checkMaxScore(score[4],max_score);
       // System.out.println(max_score);

        for(int i = 0 ; i < 4 ; i++){
           if(score[4] > 21 && score[i] < 21){
               winners.add(p[i]);
               int assets = p[i].getAssets();
               int betAmount = p[i].getBetting_amount();
               assets = assets + 2 * betAmount;
               p[i].setAssets(assets);
             //  System.out.println("Winner : " + p[i].getName());
           }
           else if(score[i] > 21){
             //  System.out.println("Busted : " + p[i].getName());
               busted.add(p[i]);
            }
            else if(score[i] < score[4]){
              //  System.out.println("lost : " + p[i].getName());

                losers.add(p[i]);
            }
            else /*if(score[i] > score[4])*/{
              //   System.out.println("Winner : " + p[i].getName());
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
            winners.add(p[4]);
        }
        bjw.stopMusic();
         Result result = new Result(winners, losers , busted , bjw);
         Greenfoot.setWorld(result);
            /* if(score[i] == max_score || score[4] > 21 && i != 4) {
                winners.add(p[i]);
                System.out.println("Winner : " + p[i].getName());
                //p[i].setScore(
            }
            else 
            if(score[i] > 21){
                 System.out.println("Busted : " + p[i].getName());
                busted.add(p[i]);
            }
            else {
                 System.out.println("lost : " + p[i].getName());
                losers.add(p[i]);
            }
        }*/
    }
    public int checkMaxScore(int score , int maxScore){
        if(score > 21) return maxScore;
        return (score > maxScore)?score:maxScore;
    }
    
}
