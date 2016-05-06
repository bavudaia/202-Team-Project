/**
 * Write a description of class Constants here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Constants  
{
    // instance variables - replace the example below with your own
    public int button_height = 50;
    public int button_width = 50;
    static class User
    {
        public static String name = "User";
        public static int betX = 280;
        public static int betY = 390;
        public static int x = 300;
        public static int y = 400;
        public static int scoreX = betX + 100;
        public static int scoreY = betY;
    }
    static class Bot1
    {    
        public static String name = "Bot1";
        public static int betX  = 100;
        public static int betY = 190;
        public static int x = 0;
        public static int y = 200;
        public static int scoreX = betX-100;
        public static int scoreY = betY;
        
    }
        static class Bot2
    {
        public static String name = "Bot2";
        public static int betX = 600;
        public static int betY = 390;
        public static int x = 600;
        public static int y = 400;
        public static int scoreX = betX + 100 ;
        public static int scoreY = betY;
    }
        static class Bot3
    {
        public static String name = "Bot3";
        public static int betX = 700;
        public static int betY = 90;
        public static int x = 600;
        public static int y = 100;
        public static int scoreX = betX-100;
        public static int scoreY = betY;
    }
    
    static class Dealer
    {
        public static String name = "Dealer";
        public static int x = 300;
        public static int y = 100;
                public static int scoreX = x+20 ;
        public static int scoreY = y - 10;
    }
}
