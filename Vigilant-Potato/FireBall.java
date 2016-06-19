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
    public FireBall(int dir){
        //setImage("fireball.png");
        setRotation(dir);
    }
    public void act() 
    {
        //Self Destruct
        if(!((MyWorld)getWorld()).isGameStarted || isAtEdge()) getWorld().removeObject(this);
        move(8);
    }    
}
