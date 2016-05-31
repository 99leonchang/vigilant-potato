import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Clock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clock extends Actor
{
    private static long start;
    private static int currentTime;
    public Clock(){
        start = System.currentTimeMillis();
    }
    /**
     * Act - do whatever the Clock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        currentTime = ((int)System.currentTimeMillis() - (int)start)/1000;
        GreenfootImage textImage = new GreenfootImage(" " + currentTime, 24, new Color(0, 255, 128), new Color(0, 0, 0, 0));
        setImage(textImage);
        spawnEnemy(currentTime/10 + 1);
    }
    
    public static int getTime(){
        return currentTime;
    }
    
    public void spawnEnemy(int spawnSpeed){
        //Default speed runs at around 60 ticks per second.
        //At spawnSpeed 1, we want about 1 every two seconds thus 120/spawnSpeed
        int randNum = (int) (Math.random()*(120/spawnSpeed));

        if(randNum == 0) getWorld().addObject(new Enemy((int)(Math.random()*spawnSpeed)+1, currentTime), (int) (Math.random()*1001), (int) (Math.random()*701));
    }
}
