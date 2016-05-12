
 import greenfoot.*; 
 import org.json.JSONObject;

 import com.mongodb.MongoClient;
 import com.mongodb.client.MongoDatabase;
 import org.bson.Document;
 import com.mongodb.client.FindIterable;
 import com.mongodb.Block;
 /* Write a description of class AuthenticationProxy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PasswordProxy implements AuthenticationProxy 
{
    // instance variables - replace the example below with your own
    private int x;
    MongoClient mongoClient;
    MongoDatabase db;
    String userPassword = "";
    /**
     * Constructor for objects of class AuthenticationProxy
     */
    public PasswordProxy()
    {
    }
    public void authenticateLogin(String Username, String Password, World w)
    {
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("LoginDetails");
   
        FindIterable<Document> iterable = db.getCollection("userdata").find(new Document("Username",Username));
        Boolean isCorrectPassword = false;
        userPassword = "";
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                try{
                    String documentContent = document.toJson();
                    System.out.println(documentContent);
                    JSONObject jsonDoc = new JSONObject(documentContent);
                    userPassword =  jsonDoc.getString("Password");
                    System.out.println("From Mongo "+ userPassword);
                }
                catch(Exception ex)             
                {
                    System.out.println(ex.toString());
                }
            }
        });
        mongoClient.close();
            
        // need to connect with cloud DB here
        if( Password.equals(userPassword))
        {
                BlackJackWorld blackJackWorld = new BlackJackWorld();
                Greenfoot.setWorld(blackJackWorld);
        }
        else
        {
//                World w = getWorld();
                w.addObject(new Label(200, 30, "        Invalid Password",false), 330,  60);
        }
    }
}
