import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackJackLoginScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackJackLoginScreen extends World
{

    /**
     * Constructor for objects of class BlackJackLoginScreen.
     * 
     */
    public BlackJackLoginScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        getBackground().drawImage(new GreenfootImage("blackjackmenu.png"), 0, 0);
        TextBox username = new TextBox(200, 40, "",false);
        TextBox passWord = new TextBox(200, 40, "",true);
        addObject(new Label(200, 37, "Login Name",false), 170, 100);
        addObject(new Label(200, 37, "Password",false), 170, 200);
        addObject(username, 430, 100);
        addObject(passWord, 430, 200);
        
        addObject(new SignIn(username,passWord), 230, 290);
        addObject(new Signup(), 380, 290);
        addObject(new Guest(), 300, 350);
    }
}
