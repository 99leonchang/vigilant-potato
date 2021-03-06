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
        if(((MyWorld)getWorld()).isGameStarted){
            accuTime = ((int)System.currentTimeMillis() - (int)start);
            currentTime = accuTime/1000;
            GreenfootImage textImage = new GreenfootImage(" " + currentTime, 24, new Color(0, 0, 0), new Color(0, 0, 0, 0));
            setImage(textImage);
            spawnEnemy(currentTime/10 + 1);
            spawnPowerUp(currentTime/10 + 1);
        }else{
            //Self Destruct
            getWorld().removeObject(this);
        }
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
    
    public void spawnPowerUp(int spawnSpeed){
        //Default speed runs at around 60 ticks per second.
        //At spawnSpeed 1, we want about 1 every 8 seconds thus 480/spawnSpeed
        //Cap powerup spawnspeed at 3 (4s)
        if(spawnSpeed>2) spawnSpeed=2;
        int randNum = (int) (Math.random()*(480/spawnSpeed));

        if(randNum == 0) getWorld().addObject(new PowerUp((int) (Math.random()*5)+1), (int) (Math.random()*1001), (int) (Math.random()*701));
    }
}
