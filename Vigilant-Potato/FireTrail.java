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
    public FireTrail(){
        startTime = Clock.getMSTime();
        GreenfootImage image = new GreenfootImage("fire.png");
        image.scale(image.getWidth() - 270, image.getHeight() - 270);
        setImage(image);
    }
    /**
     * Act - do whatever the FireTrail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Clock.getMSTime() - startTime > 5000) getWorld().removeObject(this);
        //Destructs after 8 seconds
    }    
}
