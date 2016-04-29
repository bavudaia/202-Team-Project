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
        public static int betX = 250;
        public static int betY = 400;
        public static int x = 300;
        public static int y = 400;
        public static int scoreX = betX;
        public static int scoreY = betY-100;
    }
    static class Bot1
    {
        public static int betX  = 100;
        public static int betY = 100;
        public static int x = 0;
        public static int y = 200;
                public static int scoreX = betX-100;
        public static int scoreY = betY;
        
    }
        static class Bot2
    {
        public static int betX = 500;
        public static int betY = 400;
        public static int x = 600;
        public static int y = 400;
        public static int scoreX = betX ;
        public static int scoreY = betY-100;
    }
        static class Bot3
    {
        public static int betX = 500;
        public static int betY = 100;
        public static int x = 600;
        public static int y = 100;
        public static int scoreX = betX-100;
        public static int scoreY = betY;
    }
    
    static class Dealer
    {
                        public static int x = 300;
        public static int y = 100;
                public static int scoreX = x-50 ;
        public static int scoreY = y;
    }
}
