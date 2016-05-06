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
        addObject(new PlayAgain(bjw), 330, 320);
    }
    public Result(ArrayList<Player> winners, ArrayList<Player> losers , ArrayList<Player> busted , BlackJackWorld bjw)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.bjw = bjw;
        getBackground().drawImage(new GreenfootImage("black.png"), 0, 0);
        Font font = new Font("Serif", Font.BOLD, 18);
        GreenfootImage black = getBackground();
        black.setFont(font); 
        int i = 100;
        for(Player p : winners){
            String s = p.getName() + " has won";
             black.drawString(s,270 , i);
           
            i+=30;
        }
        for(Player p : losers){
             String s = p.getName() + " has lost";
            black.drawString(s,270 , i);
            i+=30;
        }
        for(Player p : busted){
             String s = p.getName() + " is busted";
            black.drawString(s,270 , i);
            i+=30;
        }
        BlackJackWorld bjwNew = new BlackJackWorld();
        bjwNew.getUser().setAssets(bjw.getUser().getAssets());
        bjwNew.getBot1().setAssets(bjw.getBot1().getAssets());
        bjwNew.getBot2().setAssets(bjw.getBot2().getAssets());
        bjwNew.getBot3().setAssets(bjw.getBot3().getAssets());
       
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
