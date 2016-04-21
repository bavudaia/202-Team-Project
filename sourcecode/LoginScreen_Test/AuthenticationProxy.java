/**
 * Write a description of class AuthenticationProxy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AuthenticationProxy implements Login 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class AuthenticationProxy
     */
    public AuthenticationProxy()
    {
    }
    public boolean authenticateLogin(String Username, String Password)
    {
        // need to connect with cloud DB here
        if(Username.equals("TeamCMPE20218") && Password.equals("TestString"))
        {
            return true;
        }
        return false;
    }
}
