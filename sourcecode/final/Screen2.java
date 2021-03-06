import java.util.*;
public class Screen2  
{
    BlackJackWorld bjw;
    public Screen2(BlackJackWorld bjw){
       this.bjw = bjw;
    }
    public void update(){
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
        max_score =  checkMaxScore(score[3],max_score);

        for(int i = 0 ; i < 5 ; i++){
            if(score[i] == max_score){
                winners.add(p[i]);
                //p[i].setScore(
            }
            if(score[i] > 21){
                busted.add(p[i]);
            }
            else {
                losers.add(p[i]);
            }
        }
    }
    public int checkMaxScore(int score , int maxScore){
        if(score > 21) return maxScore;
        return (score > maxScore)?score:maxScore;
    }
    
}
