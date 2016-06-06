import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireBall extends DeathItems
{
    private int dirX, dirY;
    public FireBall(int newDirX, int newDirY){
        dirX = newDirX;
        dirY = newDirY;
        turnTowards(dirX, dirY);
    }
    public void act() 
    {
        
        move(2);
    }    
}
