import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class SignIn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SignIn extends Button
{
   
    TextBox username;
    TextBox password;
    
    String userPassword = "";
    /**
     * Act - do whatever the SignIn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SignIn()
    {
       
    }
    public SignIn(TextBox userName, TextBox password)
    {
       

       
             this.username = userName;
        this.password = password;
    }
    public void act() 
    {
         AuthenticationProxy myLogin = new PasswordProxy();
        if (Greenfoot.mouseClicked(this)) 
        {
            //TextBox username =(TextBox) getOneObjectAtOffset(400,140,TextBox.class);
            String usernameText = username.getText();
            System.out.println(usernameText);
            
            //TextBox password =(TextBox) getOneObjectAtOffset(400,240,TextBox.class);
            String passWordText = password.getText();
            System.out.println(passWordText);
            myLogin.authenticateLogin(usernameText,passWordText,getWorld()/*"TeamCMPE20218", "TestString"*/);
          
        }
    }    
}
