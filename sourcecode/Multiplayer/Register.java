import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.Block;

public class Register extends Button
{
    AuthenticationProxy myLogin;
    TextBox username;
    TextBox password;
    TextBox confirmPassword;
  /*  MongoClient mongoClient;
    MongoDatabase db;*/
    String userPassword = "";
    /**
     * Act - do whatever the SignIn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Register()
    {
       /* mongoClient = new MongoClient();
        db = mongoClient.getDatabase("LoginDetails");*/

        myLogin = new PasswordProxy();
    }
    public Register(TextBox userName, TextBox password, TextBox conformPassword)
    {
        myLogin = new PasswordProxy();
        this.username = userName;
        this.password = password;
        this.confirmPassword = conformPassword;
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            //TextBox username =(TextBox) getOneObjectAtOffset(400,140,TextBox.class);
            String usernameText = username.getText();
          //  System.out.println(usernameText);
            
            //TextBox password =(TextBox) getOneObjectAtOffset(400,240,TextBox.class);
            String passWordText = password.getText();
          //  System.out.println(passWordText);
            
            String confirmPasswordText = confirmPassword.getText();
            
          //  System.out.println(confirmPasswordText); 
            if(passWordText.equals(confirmPasswordText))
            {
                BlackJackWorld blackJackWorld = new BlackJackWorld();
             
                Greenfoot.setWorld(blackJackWorld);
             
                if(!recordAlreadyPresent())
                {
                    insertNotificationToMongoDB(usernameText, passWordText);
                }
            }
            else
            {
                 getWorld().addObject(new Label(200, 30, "        Password doesn't match",false), 330,  60);
            }
            
            //FindIterable<Document> iterable = db.getCollection("userdata").find(new Document("Username",usernameText));
            
        }
    }   
    public boolean recordAlreadyPresent()
    {
        return false;
    }
    public void insertNotificationToMongoDB(String Username, String Password)
    {
        
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("LoginDetails");
        
        Document d = new Document()
                .append("Username", Username)
                .append("Password", Password); 
                
        db.getCollection("userdata").insertOne(d);
        mongoClient.close();
        
    }   
    
}
