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
        public static int assetX = 215; 
        public static int assetY= 525;
                public static int nameX = 220; 
        public static int nameY= 500;
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
         public static int assetX = 45; 
        public static int assetY= 55;
                 public static int nameX = 50; 
        public static int nameY= 160;
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

                public static int assetX = 525; 
        public static int assetY= 525;
                 public static int nameX = 530; 
        public static int nameY= 500;
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
        public static int assetX = 525; 
        public static int assetY= 225;
        public static int nameX = 530; 
        public static int nameY= 200;
    }
    
    static class Dealer
    {
        public static String name = "Dealer";
        public static int x = 300;
        public static int y = 100;
                public static int scoreX = x+20 ;
        public static int scoreY = y - 10;
                 public static int assetX = 45; 
        public static int assetY= 55;
                         public static int nameX = 335; 
        public static int nameY= 325;

    }
    
    static class Screen{
        public static int x = 745;
        public static int y = 725;
    }

}
