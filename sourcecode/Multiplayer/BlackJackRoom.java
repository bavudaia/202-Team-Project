import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
/**
 * Write a description of class BlackJackRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackJackRoom extends World implements MqttCallback
{

    /**
     * Constructor for objects of class BlackJackRoom.
     * 
     */
    Vegas vegas;
    Macao macao;
    MonteCarlo monteCarlo;
    Multi multi;
    
    public MqttClient client;
    String MosquittoBrokerUrl = "tcp://54.213.225.111:2882";
    public int playerId;
    public BlackJackRoom()
    {    
        super(1200, 800, 1);
        getBackground().drawImage(new GreenfootImage("black.png"), 0, 0);
        
        vegas = new Vegas();
        macao = new Macao();
        monteCarlo = new MonteCarlo();
        multi = new Multi();
        
        addObject(vegas,200,200);
        addObject(monteCarlo,800,200);
        addObject(macao,200,600);
        addObject(multi,800,600);
        startMqttCallback();
       //  addObject(new BlackJackTable(), 0, 0);
       playerId = 1;
    }
            @Override
    public void connectionLost(Throwable cause) {
        

    }
    
        public void startMqttCallback()
    {
         try{  
            client = new MqttClient(MosquittoBrokerUrl,"Player"+playerId);
            client.connect();
            client.setCallback(this);   
            client.subscribe("/greenfoot/client");
           }
           catch(Exception ex){
               System.out.println(ex.toString());
           }
    }
    @Override
        public void messageArrived(String topic, MqttMessage message)
            throws Exception {  
      try {
          System.out.println("playerId" + playerId);
          playerId++;
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
            String clientId     = "blackjack"+playerId;
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
