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
    
    String MosquittoBrokerUrl = "tcp://54.213.225.111:2882";
    
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
        
        hitButton = new Hit();
        addObject(hitButton,350,700);
        standButton = new Stand();
        addObject(standButton,450,700);
        surrenderButton = new Surrender();
        addObject(surrenderButton,550,700);
        doubleDownButton = new DoubleDown();
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
	        String clientId     = "smartchaircomputeengine";
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
