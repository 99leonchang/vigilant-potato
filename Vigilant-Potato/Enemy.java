import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.Random;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int speed = 1;
    private int startTime;
    public Enemy(int newSpeed, int timeStamp){
        
        GreenfootImage newImg = new GreenfootImage(10,10);
        
        //--- Generates random rainbow colour
        
        Random random = new Random();
        float hue = random.nextFloat();
        float saturation = 1.0f; //0.0-1.0, 1.0 = bright af, 0.0 = dull
        float luminance = 1.0f; //same as above
        Color newcol = Color.getHSBColor(hue, saturation, luminance);
        
        newImg.setColor(newcol);
        newImg.fillOval(0, 0, 10, 10);
        setImage(newImg);
        
        //--- Sets enemy properties
        if(newSpeed < 3) speed = newSpeed;
        else speed = 3;
        startTime = timeStamp;
        
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Clock.getTime() - startTime == 20) getWorld().removeObject(this);
        if(Clock.getTime() - startTime > 2) move(speed);
        if(Greenfoot.getMouseInfo() != null){
            MouseInfo info = Greenfoot.getMouseInfo();
            turnTowards(info.getX(), info.getY());
        }
    }    
}