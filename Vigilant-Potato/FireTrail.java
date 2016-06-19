import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireTrail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireTrail extends DeathItems
{
    private int startTime;
    //private static GreenfootImage image = new GreenfootImage("fire.png");
    public FireTrail(){
        startTime = Clock.getMSTime();
        //image.scale(image.getWidth() - 270, image.getHeight() - 270);
        //setImage("fire.png");
    }
    /**
     * Act - do whatever the FireTrail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Clock.getMSTime() - startTime > 5000 || !((MyWorld)getWorld()).isGameStarted) getWorld().removeObject(this);
        //Destructs after 8 seconds
    }    
}
