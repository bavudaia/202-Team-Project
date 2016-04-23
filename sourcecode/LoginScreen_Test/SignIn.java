import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SignIn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SignIn extends Button
{
    Login myLogin;
    TextBox username;
    TextBox password;
    /**
     * Act - do whatever the SignIn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SignIn()
    {
        myLogin = new AuthenticationProxy();
    }
    public SignIn(TextBox userName, TextBox password)
    {
        myLogin = new AuthenticationProxy();
        this.username = userName;
        this.password = password;
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            //TextBox username =(TextBox) getOneObjectAtOffset(400,140,TextBox.class);
            String usernameText = username.getText();
            System.out.println(usernameText);
            
            //TextBox password =(TextBox) getOneObjectAtOffset(400,240,TextBox.class);
            String passWordText = password.getText();
            System.out.println(passWordText);
                
            if(myLogin.authenticateLogin(usernameText,passWordText/*"TeamCMPE20218", "TestString"*/))
            {
                BlackJackWorld blackJackWorld = new BlackJackWorld();
                Greenfoot.setWorld(blackJackWorld);
            }
            else
            {
                World w = getWorld();
                w.addObject(new Label(200, 30, "        Invalid Password",false), 330, 360);
            } 
        }
    }    
}