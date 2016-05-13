import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoubleDown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoubleDown extends Button
{
    /**
     * Act - do whatever the DoubleDown wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public DoubleDown(){
     GreenfootImage ddImage = new GreenfootImage("doubledown.png");
        ddImage.scale(Constants.button_height,Constants.button_width);
        setImage(ddImage);
    }
    public void act() 
    {
        // Add your action code here.
               
        
           if(Greenfoot.mouseClicked(this))
      {
          World w = getWorld();
          if(w instanceof BlackJackWorld)
          {
          // get player from chain of responsibility
          BlackJackWorld bjw = (BlackJackWorld) getWorld();
          bjw.playClickSound();
         //
          AbstractFactory abf = new AbstractFactory();
          CommandFactory cf = abf.getCommandFactory();
          Command c = cf.getCommand("DoubleDown");
          c.setBlackJackWorld(bjw);
          c.execute();
        }
                else
        {
            BlackJackMultiPlayer bjw = (BlackJackMultiPlayer) getWorld();
            MultiPlayer mp = bjw.getMP();
                           if(mp.getCps()  instanceof InvalidMultiPlayerState)
                return;
            mp.doubleDown();
                          String player = mp.getName();
              String cmd= "Doubledown";
              String cardName = mp.getCards().get(mp.getCards().size()-1);
              
              String score = String.valueOf(mp.getScore());
              String bet = String.valueOf(mp.getBetting_amount());
              String data = player+","+cmd+"," + cardName + "," + score
              +"," + bet;
              bjw.sendMessage( "/greenfoot/player" , data );

        }
    }    
}
}
