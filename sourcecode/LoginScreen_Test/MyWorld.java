import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Label(200, 40, "Login Name",false), 200, 140);
        addObject(new Label(200, 40, "Password",false), 200, 240);
        addObject(new TextBox(200, 40, "",false), 400, 140);
        addObject(new TextBox(200, 40, "",true), 400, 240);
 
    }
}
