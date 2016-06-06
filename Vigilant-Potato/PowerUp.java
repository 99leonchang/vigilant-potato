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
    public PowerUp(int powerid){
        id = powerid;
        //Add custom image capabilities
        /*
         GreenfootImage image = getImage();
        image.scale(image.getWidth() - 280, image.getHeight() - 280);
        setImage(image);
        */
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public int getID(){
        return id;
    }
}
