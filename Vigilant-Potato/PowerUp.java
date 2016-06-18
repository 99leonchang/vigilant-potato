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
        
        String imagename = "";
        switch(id){
            case 1:
                imagename = "powerup_fire.png";
                break;
            case 2:
                //Need new image
                imagename = "powerup_fire.png";
                break;
            case 3:
                imagename = "powerup_bullet.png";
                break;
            default:
                break;
         
        }
        GreenfootImage image = new GreenfootImage(imagename);
        image.scale(image.getWidth() - 478, image.getHeight() - 478);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public int getID(){
        return id;
    }
}
