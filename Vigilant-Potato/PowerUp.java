import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp extends Actor
{
    private int id;
    private static GreenfootImage image1 = new GreenfootImage("powerup_fire.png");
    private static GreenfootImage image2 = new GreenfootImage("powerup_fireball.png");
    private static GreenfootImage image3 = new GreenfootImage("powerup_bullet.png");
    private static GreenfootImage image4 = new GreenfootImage("powerup_wiper.png");
    public PowerUp(int powerid){
        id = powerid;
        //Add custom image capabilities
        switch(id){
            case 1:
                setImage(image1);
                break;
                //image1.scale(image1.getWidth() - 478, image1.getHeight() - 478);
            case 2:
                //image2.scale(image2.getWidth() - 478, image2.getHeight() - 478);
                setImage(image2);
                break;
            case 3:
                //image3.scale(image3.getWidth() - 478, image3.getHeight() - 478);
                setImage(image3);
                break;
            case 4:
                //image3.scale(image3.getWidth() - 478, image3.getHeight() - 478);
                setImage(image4);
                break;
            default:
                break;
        }
    }
    
    public void act() 
    {
        //Self Destruct
        if(!((MyWorld)getWorld()).isGameStarted) getWorld().removeObject(this);
    }    
    
    public int getID(){
        return id;
    }
}
