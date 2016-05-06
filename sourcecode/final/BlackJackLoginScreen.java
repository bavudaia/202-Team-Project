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
        addObject(new Label(200, 37, "Login Name",false), 200, 139);
        addObject(new Label(200, 37, "Password",false), 200, 239);
        addObject(username, 420, 140);
        addObject(passWord, 420, 240);
        
        addObject(new SignIn(username,passWord), 250, 320);
        addObject(new Signup(), 410, 320);
        addObject(new Guest(), 320, 370);
    }
}
