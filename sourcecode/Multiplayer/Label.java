import greenfoot.*; 
import java.awt.Color;

public class Label extends Actor
{
    private boolean active = false;
    private boolean cursorActive = false;
    private boolean displayKeyNames;
    private boolean enabled = true;
    
    private static int activeTextField = 1;
    
    private int textFieldNumber;
    private int textFontSize;
    private int cursorPosition = 0;
    
    private long cursorTime = System.currentTimeMillis();
    
    private String input = "";
    private String text = "";
    private String temp = "";
    
    private Color bgColor = Color.white;
    private Color textColor = Color.black;
    private Boolean isPassword=false;

    public Label() {
        this(250, 50, false, true, Color.white, Color.black, "");
    }
    
    public Label(String text) {
        this(250, 50, false, true, Color.white, Color.black, text);
    }
    
    public Label(String text, boolean enabled) {
        this(250, 50, false, enabled, Color.white, Color.black, text);
    }
    
    public Label(int width, int height) throws IllegalArgumentException {
        this(width, height, false, true, Color.white, Color.black, "");
    }
    
    public Label(int width, int height, boolean enabled) throws IllegalArgumentException {
        this(width, height, false, enabled, Color.white, Color.black, "");
    }
    
    public Label(int width, int height, String text,Boolean password) throws IllegalArgumentException {
        this(width, height, false, true, Color.white, Color.black, text);
        isPassword = password;
    }
    
    public Label(int width, int height, boolean displayKeyNames, String text) throws IllegalArgumentException {
        this(width, height, displayKeyNames, true, Color.white, Color.black, text);
    }
    
    public Label(int width, int height, Color bgColor, Color textColor) throws IllegalArgumentException {
        this(width, height, false, true, bgColor, textColor, "");
    }
    
    public Label(int width, int height, boolean displayKeyNames, Color bgColor, Color textColor) throws IllegalArgumentException {
        this(width, height, false, true, bgColor, textColor, "");
    }
    
    public Label(int width, int height, Color bgColor, Color textColor, String text) throws IllegalArgumentException {
        this(width, height, false, true, bgColor, textColor, text);
    }
    
    public Label(int width, int height, boolean displayKeyNames, Color bgColor, Color textColor, String text) throws IllegalArgumentException {
        this(width, height, displayKeyNames, true, bgColor, textColor, text);
    }
    
    public Label(int width, int height, boolean displayKeyNames, boolean enabled, Color bgColor, Color textColor, String text) throws IllegalArgumentException {
        if (width < 50) {
            throw new IllegalArgumentException("The width of the text field has to be greater or equal 50");
        }
        else if (height < 20) {
            throw new IllegalArgumentException("The height of the text field has to be greater or equal 20");
        }
        this.bgColor = bgColor;
        this.textColor = textColor;
        this.text = text;
        this.displayKeyNames = displayKeyNames;
        this.enabled = enabled;
        cursorPosition = text.length();
        getImage().clear();
        getImage().scale(width, height);
        textFontSize = height - 10;
        resetImage();
        displayText();
    }
    
    public void addedToWorld(World world) {
        textFieldNumber = getWorld().getObjects(Label.class).size();
    }
    
    public void act() {
        
    }
    
    private void displayText() {
        String sTemp = "";
        if(isPassword)
        {
            int i = 0;
            for(i = 0; i < text.length();i++)
                sTemp = sTemp + "*";
        }
        else
            sTemp = text;
        GreenfootImage textImage = new GreenfootImage(sTemp, textFontSize, textColor, new Color(0, 0, 0, 0));
      //  GreenfootImage textBeforeCursor = new GreenfootImage(sTemp.substring(0, cursorPosition), textFontSize, textColor, new Color(0, 0, 0, 0));
        resetImage();
        getImage().drawImage(textImage, (textImage.getWidth() > getImage().getWidth() - 10 ? -(textImage.getWidth() - getImage().getWidth()) - 10 : 5), (getImage().getHeight() / 2 - textImage.getHeight() / 2));
        getImage().setColor(textColor);
        getImage().setColor(bgColor);
        //getImage().fillRect(0, 0, 3, getImage().getHeight()-2);
    }
    
    private void resetImage() {
        getImage().setColor(bgColor);
        getImage().fill();
        getImage().setColor(Color.black);
        //getImage().fillRect(0, getImage().getHeight()-2, getImage().getWidth(), 3);
        //getImage().fillRect(getImage().getWidth()-2, 0, 3, getImage().getHeight());
    }
    
    public void setActiveTextField(int activeTextField) {
        this.activeTextField = activeTextField;
    }
    public void setActiveTextField() {
        activeTextField++;
        if (activeTextField > getWorld().getObjects(Label.class).size()) {
            activeTextField = 1;
        }
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
        cursorPosition = text.length();
    }
    
    public Color getBackgroundColor() {
        return bgColor;
    }
    public void setBackgroundColor(Color bgColor) {
        this.bgColor = bgColor;
    }
    
    public Color getTextColor() {
        return textColor;
    }
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}