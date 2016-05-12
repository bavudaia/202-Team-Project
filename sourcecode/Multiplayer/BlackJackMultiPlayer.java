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
public class BlackJackMultiPlayer extends World
{
     
    Hit hitButton;
    Stand standButton;
    Surrender surrenderButton;
    DoubleDown doubleDownButton;
    
    Ten ten;
    Twenty twenty;
    Fifty fifty;
    Hundred hundred;
    Clear clear;
    Deal deal;
    
    MultiPlayer m ;
    MultiPlayer other;
    GameController gc;
    
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

    /**
     * Constructor for objects of class BlackJackMultiPlayer.
     * 
     */
    public BlackJackMultiPlayer()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1);
        getBackground().drawImage(new GreenfootImage("black.png"), 0, 0);
        
        GreenfootImage userImage = new GreenfootImage("user.png");
        userImage.scale(80,80);
        getBackground().drawImage(userImage, 510, 400);
        drawUserName("Player1", 520,400);
        userImage = new GreenfootImage("user1.png");
        userImage.scale(80,80);
        getBackground().drawImage(userImage, 510, 100);
        drawUserName("Player2", 520,100);
        userImage = new GreenfootImage("user2.png");
        userImage.scale(80,80);
        getBackground().drawImage(userImage, 30, 250); 
        drawUserName("Dealer", 50,250);
        userImage = new GreenfootImage("user3.png");
        userImage.scale(80,80);
        
        m = new MultiPlayer();
        addObject(m, -200,-200);
        
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
         m.setName("Player1");
        
    }
       public void drawUserName(String s , int x , int y){
         GreenfootImage black = getBackground();
         Font font = new Font("Serif", Font.BOLD, 18);
         black.setFont(font);
         //black.drawImage(new GreenfootImage("Score" + Integer.toString(100000) , 20, Color.BLACK,Color.BLACK),scoreX-10, scoreY - 20); 
         black.drawString(s,x, y);
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
