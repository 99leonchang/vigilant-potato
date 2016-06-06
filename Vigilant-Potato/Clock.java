import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Class that deals with timing
 * 
 * @author Leon Chang 
 * @version 1.0
 */
public class Clock extends Actor
{
    private static long start;
    private static int currentTime;
    private static int accuTime; //Time with more sig figs (ms)
    public Clock(){
        start = System.currentTimeMillis();
    }
    /**
     * Act - do whatever the Clock wants to do.
     */
    public void act() 
    {
        accuTime = ((int)System.currentTimeMillis() - (int)start);
        currentTime = accuTime/1000;
        GreenfootImage textImage = new GreenfootImage(" " + currentTime, 24, new Color(0, 255, 128), new Color(0, 0, 0, 0));
        setImage(textImage);
        spawnEnemy(currentTime/10 + 1);
    }
    
    public static int getTime(){
        return currentTime;
    }
    
    public static int getMSTime(){
        return accuTime;
    }
    
    public void spawnEnemy(int spawnSpeed){
        //Default speed runs at around 60 ticks per second.
        //At spawnSpeed 1, we want about 1 every two seconds thus 120/spawnSpeed
        int randNum = (int) (Math.random()*(120/spawnSpeed));

        if(randNum == 0) getWorld().addObject(new Enemy((int)(currentTime)), (int) (Math.random()*1001), (int) (Math.random()*701));
    }
}
