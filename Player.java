import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public boolean isGameStarted = false;
    public Player(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 280, image.getHeight() - 280);
        setImage(image);
        //getWorld().addObject(new Clock(), 100, 100);
    }

    public void act() 
    {
        
        if(Greenfoot.getMouseInfo() != null){
            MouseInfo info = Greenfoot.getMouseInfo();
            //turnTowards(info.getX(), info.getY());
            setLocation(info.getX(), info.getY());
            //move(1);
        }
        if(isTouching(Enemy.class))
            Greenfoot.stop();
           
    }    
    
    public void startGame(){
        isGameStarted = true;
        getWorld().addObject(new Clock(), 100, 100);
    }
}
