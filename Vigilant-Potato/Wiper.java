import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wiper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wiper extends DeathItems
{
    /**
     * Act - do whatever the Wiper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10);
        if(isAtEdge()) getWorld().removeObject(this);
    }    
}
