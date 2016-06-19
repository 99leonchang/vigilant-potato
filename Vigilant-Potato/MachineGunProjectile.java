import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MachineGunProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MachineGunProjectile extends DeathItems
{
    private int dirX, dirY;
    public MachineGunProjectile(int currentX, int currentY){
        double dx = currentX - Player.fixedX;
        double dy = currentY - Player.fixedY;
        double angle = Math.atan2(dy,dx)*180.0/Math.PI;
        setRotation( (int)angle );
        //turnTowards(currentX, currentY);
    }
    public void act() 
    {
        move(6);
        if(isAtEdge()) getWorld().removeObject(this);
    }    
}
