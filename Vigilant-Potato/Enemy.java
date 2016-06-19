import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.Random;

/**
 * Enemy Object
 * 
 * @author Leon Chang 
 * @version 1.0
 */
public class Enemy extends Actor
{
    private int speed = 1;
    private int startTime;
    public boolean isHarmful = false;
    public Enemy(int timeStamp){
        /**
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
        **/
        
        int virusnum = (int)(Math.random()*6)+1;
        setImage("virus_"+virusnum+".png");
        
        //--- Sets enemy properties
        startTime = timeStamp;
        
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(((MyWorld)getWorld()).isGameStarted){
            if(Clock.getTime() - startTime == 20) getWorld().removeObject(this);
            else{
                //Kill if necessary
                
                if(isAtEdge()) getWorld().removeObject(this);
                else if(isTouching(DeathItems.class))getWorld().removeObject(this);
                
                //Set Direction
                if(Greenfoot.getMouseInfo() != null){
                    MouseInfo info = Greenfoot.getMouseInfo();
                    if(Player.machineGun) turnTowards(Player.fixedX, Player.fixedY);
                    else turnTowards(info.getX(), info.getY());
                }
                if(Player.isInvincible) turn(180); //run away if player invincible
                
                //Turn on harmfulness
                if(Clock.getTime() - startTime == 2) isHarmful = true;
                
                //Move
                if(Clock.getTime() - startTime > 2) move(speed);
            }
        }else{
            //Self Destruct
            getWorld().removeObject(this);
        }
    }    
}
