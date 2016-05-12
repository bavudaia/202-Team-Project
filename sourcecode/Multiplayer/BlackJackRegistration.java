import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackJackRegistration here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackJackRegistration extends World
{

    /**
     * Constructor for objects of class BlackJackRegistration.
     * 
     */
    public BlackJackRegistration()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        getBackground().drawImage(new GreenfootImage("blackjackmenu.png"), 0, 0);
        TextBox username = new TextBox(200, 40, "",false);
        TextBox passWord = new TextBox(200, 40, "",true);
        TextBox confirmPassword = new TextBox(200,40,"",true);
        addObject(new Label(200, 37, "UserName",false), 180, 139);
        addObject(new Label(200, 37, "Password",false), 180, 189);
        addObject(new Label(200, 37, "Confirm Password",false), 180, 239);
        addObject(username, 420, 140);
        addObject(passWord, 420, 190);
        addObject(confirmPassword, 420, 240);
        addObject(new Register(username,passWord,confirmPassword), 300, 320);
    }
}
