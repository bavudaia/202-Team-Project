import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


/**
 * Write a description of class BlackJackMultiPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackJackMultiPlayer extends World implements MqttCallback
{     
    Hit hitButton;
    Stand standButton;
    Surrender surrenderButton;
    DoubleDown doubleDownButton;
    
    public MqttClient client;
    Ten ten;
    Twenty twenty;
    Fifty fifty;
    Hundred hundred;
    Clear clear;
    Deal deal;
    
    MultiPlayer m ;
    MultiPlayer other;
    MultiDealer dealer;
    GameController gc;
    public int playerId;
    static int background ;
    
    private static Map<Integer,String> cardMap = new HashMap<>();
    
    String MosquittoBrokerUrl = "tcp://54.213.225.111:2882";
    
    public static Map <String,Integer> scoreMap;
    
    static
    {
    scoreMap = new HashMap<>();
    scoreMap.put("ace_of_spades.png",1);
    scoreMap.put("2_of_spades.png",2);
    scoreMap.put("3_of_spades.png",3);
    scoreMap.put("4_of_spades.png",4);
    scoreMap.put("5_of_spades.png",5);
    scoreMap.put("6_of_spades.png",6);
    scoreMap.put("7_of_spades.png",7);
    scoreMap.put("8_of_spades.png",8);
    scoreMap.put("9_of_spades.png",9);
    scoreMap.put("10_of_spades.png",10);
    scoreMap.put("jack_of_spades.png",10);
    scoreMap.put("queen_of_spades.png",10);
    scoreMap.put("king_of_spades.png",10);
    scoreMap.put("ace_of_clubs.png",1);
    scoreMap.put("2_of_clubs.png",2);
    scoreMap.put("3_of_clubs.png",3);
    scoreMap.put("4_of_clubs.png",4);
    scoreMap.put("5_of_clubs.png",5);
    scoreMap.put("6_of_clubs.png",6);
    scoreMap.put("7_of_clubs.png",7);
    scoreMap.put("8_of_clubs.png",8);
    scoreMap.put("9_of_clubs.png",9);
    scoreMap.put("10_of_clubs.png",10);
    scoreMap.put("jack_of_clubs.png",10);
    scoreMap.put("queen_of_clubs.png",10);
    scoreMap.put("king_of_clubs.png",10);
    scoreMap.put("ace_of_diamonds.png",1);
    scoreMap.put("2_of_diamonds.png",2);
    scoreMap.put("3_of_diamonds.png",3);
    scoreMap.put("4_of_diamonds.png",4);
    scoreMap.put("5_of_diamonds.png",5);
    scoreMap.put("6_of_diamonds.png",6);
    scoreMap.put("7_of_diamonds.png",7);
    scoreMap.put("8_of_diamonds.png",8);
    scoreMap.put("9_of_diamonds.png",9);
    scoreMap.put("10_of_diamonds.png",10);
    scoreMap.put("jack_of_diamonds.png",10);
    scoreMap.put("queen_of_diamonds.png",10);
    scoreMap.put("king_of_diamonds.png",10);
    scoreMap.put("ace_of_hearts.png",1);
    scoreMap.put("2_of_hearts.png",2);
    scoreMap.put("3_of_hearts.png",3);
    scoreMap.put("4_of_hearts.png",4);
    scoreMap.put("5_of_hearts.png",5);
    scoreMap.put("6_of_hearts.png",6);
    scoreMap.put("7_of_hearts.png",7);
    scoreMap.put("8_of_hearts.png",8);
    scoreMap.put("9_of_hearts.png",9);
    scoreMap.put("10_of_hearts.png",10);
    scoreMap.put("jack_of_hearts.png",10);
    scoreMap.put("queen_of_hearts.png",10);
    scoreMap.put("king_of_hearts.png",10);
       
    }
    public GameController getGc() {
        return gc;
    }


    public void setGc(GameController gc) {
        this.gc = gc;
    }

    public void setMP(MultiPlayer m) {
        this.m = m;
    }
    public MultiPlayer getMP() {
        return m;
    }
    public void setOther(MultiPlayer m) {
        this.other = m;
    }
     public MultiPlayer getOther() {
        return other;
    }
    public void setDealer(MultiDealer dealer) {
        this.dealer = dealer;
    }
    public MultiPlayer getDealer() {
        return dealer;
    }
    /**
     * Constructor for objects of class BlackJackMultiPlayer.
     * 
     */
    
    public BlackJackMultiPlayer(int id)
    {
        super(1024, 768, 1);
        playerId = id;
              
        getBackground().drawImage(new GreenfootImage("black.png"), 0, 0);     
        m = new MultiPlayer();
        
        addObject(m, -200,-200);
        
        other = new MultiPlayer();
        addObject(other, -200,-200);
        
        dealer = new MultiDealer();
        addObject(dealer,-200,-200);
        
        hitButton = new Hit();
        addObject(hitButton,350,700);
        standButton = new Stand();
        addObject(standButton,450,700);
        surrenderButton = new Surrender();
        addObject(surrenderButton,550,700);
        doubleDownButton = new DoubleDown();
        
         gc = new GameController();
        gc.initialize();
      //  System.out.println();
        addObject(doubleDownButton,650,700);
        addObject(new FlipCard(),900,300);
         ten = new Ten();
         addObject(ten,300,600);
        twenty = new Twenty();
         addObject(twenty,400,600);
        fifty = new Fifty();
         addObject(fifty,500,600);
        hundred = new Hundred();
         addObject(hundred,600,600);
        clear = new Clear();
         addObject(clear,700,600);
         deal = new Deal();
         addObject(deal, 800,665);
         
         m.setBetX(Constants.User.betX);
         m.setBetY(Constants.User.betY);
         m.setNextX(Constants.User.x);
         m.setNextY(Constants.User.y);
         m.setScoreX(Constants.User.scoreX);
         m.setScoreY(Constants.User.scoreY);
         m.setAssets(10000);
         m.setName("Player"+playerId);
         
         other.setBetX(Constants.Bot3.betX);
         other.setBetY(Constants.Bot3.betY);
         other.setNextX(Constants.Bot3.x);
         other.setNextY(Constants.Bot3.y);
         other.setScoreX(Constants.Bot3.scoreX);
         other.setScoreY(Constants.Bot3.scoreY);
         other.setAssets(10000);
         if(playerId==1)
         other.setName("Player2");
         else
         other.setName("Player1");
          
         dealer.setNextX(Constants.Dealer.x);
         dealer.setNextY(Constants.Dealer.y);
         dealer.setScoreX(Constants.Dealer.scoreX);
         dealer.setScoreY(Constants.Dealer.scoreY);
         dealer.setAssets(10000);
         dealer.setName("Dealer");
         
         GreenfootImage userImage = new GreenfootImage("user.png");
        userImage.scale(80,80);
        getBackground().drawImage(userImage, 510, 400);
        drawUserName(m.getName(), 520,400);
        userImage = new GreenfootImage("user1.png");
        userImage.scale(80,80);
        getBackground().drawImage(userImage, 510, 100);
        drawUserName(other.getName(), 520,100);
        userImage = new GreenfootImage("user2.png");
        userImage.scale(80,80);
        getBackground().drawImage(userImage, 30, 250); 
        drawUserName("Dealer", 50,250);
        userImage = new GreenfootImage("user3.png");
        userImage.scale(80,80);
          
         addObject(new Quit(), 110, 420);
    }

    public void startMqttCallback()
    {
         try{
          client = new MqttClient(MosquittoBrokerUrl, m.getName());
            client.connect();
            client.setCallback(this);   
            client.subscribe("/greenfoot/player");
           }
           catch(Exception ex){
               System.out.println(ex.toString());
           }
    }
       public void drawUserName(String s , int x , int y){
         GreenfootImage black = getBackground();
         Font font = new Font("Serif", Font.BOLD, 18);
         black.setFont(font);
         //black.drawImage(new GreenfootImage("Score" + Integer.toString(100000) , 20, Color.BLACK,Color.BLACK),scoreX-10, scoreY - 20); 
         black.drawString(s,x, y);
    }
    
        @Override
    public void connectionLost(Throwable cause) {
        

    }
    public void messageArrived(String topic, MqttMessage message)
            throws Exception {  
      try {
          System.out.println(message.toString());
          String messageReceived[] = message.toString().split(",");
          String playerId = messageReceived[0];
          String command  = messageReceived[1];
          if(!playerId.equals(m.getName()))
          {
              if(command.equals("Deal") ){
                  String betAmt = messageReceived[2];
                  String asset = messageReceived[3];
                  String score = messageReceived[4];
                  //List<String> l = messageReceived[5];
                  String card1 = messageReceived[5];
                  String card2 = messageReceived[6];
                  other.getRemoteFirstCards(card1, card2,Integer.parseInt(score), Integer.parseInt(betAmt));
                  //m.getFirstCards();
                  other.setDealerState();
            }
            if(command.equals("Addcard") ){
                 String card = messageReceived[2];
                 String score = messageReceived[3];
                 other.addRemoteCard(card, Integer.parseInt(score));
                 
                 //m.getFirstCards();
            }
             if(command.equals("Turnend") ){
                 other.setInvalidMultiPlayerState(false);
            }
             if(command.equals("Doubledown") ){
                                  String card = messageReceived[2];
                 String score = messageReceived[3];
                 other.addRemoteCard(card, Integer.parseInt(score));
                 String bet = messageReceived[4];
                 other.setBetting_amount(Integer.parseInt(bet));
                 other.drawBet();
            }
            if(command.equals("DealerUpdate"))
            {
                 String card = messageReceived[2];
                 String score = messageReceived[3];
                 dealer.addRemoteCard(card, Integer.parseInt(score));
                 m.setValidMultiPlayerState();
                 other.setValidMultiPlayerState();
            }
            
            if(command.equals("DealerAddCard") ){
                 String card = messageReceived[2];
                 String score = messageReceived[3];
                 dealer.addRemoteCard(card, Integer.parseInt(score));
                 
                 //m.getFirstCards();
            }
           // DealerAddCard
             if(command.equals("roundend") ){
                  DecideRemoteWinner drm = new DecideRemoteWinner(this);
                  drm.update();
                  
                 //m.getFirstCards();
            }
          }    
      }
      catch(Exception ex)
      {
          System.out.println(ex.toString());
      }
    }
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        
    }           
    public void sendMessage(String topicName , String messageContent)
    {
            String topic        = topicName;
            String content      = messageContent;
            int qos             = 2;
            String clientId     = "blackjack";
            MemoryPersistence persistence = new MemoryPersistence();
            try {
                MqttClient sampleClient = new MqttClient(MosquittoBrokerUrl, clientId, persistence);
                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setCleanSession(true);
                System.out.println("Connecting to broker: "+MosquittoBrokerUrl);
                sampleClient.connect(connOpts);
                System.out.println("Connected");
                System.out.println("Publishing message: "+content);
                MqttMessage message = new MqttMessage(content.getBytes());
                message.setQos(qos);
                sampleClient.publish(topic, message);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);   
            } catch(MqttException me) {
                System.out.println("reason "+me.getReasonCode());
                System.out.println("msg "+me.getMessage());
                System.out.println("loc "+me.getLocalizedMessage());
                System.out.println("cause "+me.getCause());
                System.out.println("excep "+me);
                me.printStackTrace();
            }
    }
}
