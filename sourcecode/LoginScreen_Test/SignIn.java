import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.Block;

/**
 * Write a description of class SignIn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SignIn extends Button
{
    Login myLogin;
    TextBox username;
    TextBox password;
    MongoClient mongoClient;
    MongoDatabase db;
    String userPassword = "";
    /**
     * Act - do whatever the SignIn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SignIn()
    {
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("LoginDetails");

        myLogin = new AuthenticationProxy();
    }
    public SignIn(TextBox userName, TextBox password)
    {
        myLogin = new AuthenticationProxy();
        this.username = userName;
        this.password = password;
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            //TextBox username =(TextBox) getOneObjectAtOffset(400,140,TextBox.class);
            String usernameText = username.getText();
            System.out.println(usernameText);
            
            //TextBox password =(TextBox) getOneObjectAtOffset(400,240,TextBox.class);
            String passWordText = password.getText();
            System.out.println(passWordText);
            
            FindIterable<Document> iterable = db.getCollection("userdata").find(new Document("Username",usernameText));
            Boolean isCorrectPassword = false;
            
            
            iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                try{
                    String documentContent = document.toJson();
                    JSONObject jsonDoc = new JSONObject(documentContent);
                    userPassword =  jsonDoc.getString("Password");
                    
                }
                catch(Exception ex)             
                {
                    System.out.println(ex.toString());
                }
            }
        });
            if(myLogin.authenticateLogin(usernameText,userPassword/*"TeamCMPE20218", "TestString"*/))
            {
                BlackJackWorld blackJackWorld = new BlackJackWorld();
                Greenfoot.setWorld(blackJackWorld);
            }
            else
            {
                World w = getWorld();
                w.addObject(new Label(200, 30, "        Invalid Password",false), 330, 360);
            } 
        }
    }    
}
