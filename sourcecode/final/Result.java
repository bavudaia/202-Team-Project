import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Result here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Result extends World
{
    BlackJackWorld bjw;
    /**
     * Constructor for objects of class Result.
     * 
     */
    public Result()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        getBackground().drawImage(new GreenfootImage("black.png"), 0, 0);
     //   BlackJackWorld.backgroudmusic.setVolume(0);
        addObject(new PlayAgain(bjw), 330, 320);
    }
    public Result(ArrayList<Player> winners, ArrayList<Player> losers , ArrayList<Player> busted , BlackJackWorld bjw)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.bjw = bjw;
        getBackground().drawImage(new GreenfootImage("black.png"), 0, 0);
        Font font1 = new Font("Serif", Font.BOLD, 28);
        Font font = new Font("Serif", Font.ITALIC, 20);
        GreenfootImage black = getBackground();
        black.setFont(font1); 
        
         black.drawString("Game Results",260 , 90);
         black.drawString("____________",260 , 96);
          black.setFont(font);
        int i = 140;
        for(Player p : winners){
            String s = p.getName() + " has won";
            getBackground().drawImage(new GreenfootImage("rsz_rsz_user.png"), 260, i-15);
            black.drawString(s,300 , i);
            //addObject(new Label(200, 37, "Password",false), 200, 239);
            //setImage( image );
            i+=30;

        }
        for(Player p : losers){
            String s = p.getName() + " has lost";
            getBackground().drawImage(new GreenfootImage("rsz_rsz_user.png"), 260, i-15);
           
            black.drawString(s,300 , i);
            i+=30;
        }
        for(Player p : busted){
             String s = p.getName() + " is busted";
            getBackground().drawImage(new GreenfootImage("rsz_rsz_user.png"), 260, i-15);
            black.drawString(s,305 , i);
            i+=30;
        }
        BlackJackWorld bjwNew = new BlackJackWorld();
        bjwNew.getUser().setAssets(bjw.getUser().getAssets());
        bjwNew.getBot1().setAssets(bjw.getBot1().getAssets());
        bjwNew.getBot2().setAssets(bjw.getBot2().getAssets());
        bjwNew.getBot3().setAssets(bjw.getBot3().getAssets());
        bjwNew.stopMusic();
        addObject(new PlayAgain(bjwNew), 250, 320);
        addObject(new Quit(), 410, 320);
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
        }
    }
}
