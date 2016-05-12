
import greenfoot.*; 
public class GuestProxy  implements AuthenticationProxy
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class GuestProxy
     */
    public GuestProxy()
    {
    }

    public void authenticateLogin(String Username, String Password, World w)
    {
          BlackJackWorld blackJackWorld = new BlackJackWorld();
          Greenfoot.setWorld(blackJackWorld);
    }
}
