import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Kills all objects it touches. Protects player
 * 
 * @author Leon Chang
 * @version 1.0
 */
public class Shield extends DeathItems
{
    private int startTime;
    public Shield(){
        startTime = Clock.getMSTime();
    }
    
    public void act() 
    {
      //Self destruct after 5 seconds
       if(Clock.getMSTime() - startTime > 5000 || !((MyWorld)getWorld()).isGameStarted){
            getWorld().removeObject(this);
            Player.isInvincible = false;
        }
       if(Greenfoot.getMouseInfo() != null){
                MouseInfo info = Greenfoot.getMouseInfo();
                int currentX = info.getX();
                int currentY = info.getY();
                if(!Player.machineGun)setLocation(currentX, currentY);
       }
    }    
}
