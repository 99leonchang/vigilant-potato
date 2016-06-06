import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public boolean isGameStarted = false;
    public static boolean isInvincible;
    
    //PowerUps
    private int activePowerUp = 0;
    private boolean spawnFire = false;
    private int spawnFireTimestamp;
    private int currentX;
    private int currentY;
    public Player(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 280, image.getHeight() - 280);
        setImage(image);
        isInvincible = false;
        //getWorld().addObject(new Clock(), 100, 100);
    }

    public void act() 
    {
        
        if(Greenfoot.getMouseInfo() != null){
            MouseInfo info = Greenfoot.getMouseInfo();
            //turnTowards(info.getX(), info.getY());
            currentX = info.getX();
            currentY = info.getY();
            setLocation(currentX, currentY);
            //move(1);
        }
        
        if(isTouching(Enemy.class) && !isInvincible)
            Greenfoot.stop();
           
            
        //List <A> objects = getIntersectingObjects(null);
        PowerUp a = (PowerUp) getOneIntersectingObject(PowerUp.class);
                
        if(a != null){
            doPowerUp(a.getID());
        }
        
        //PowerUp runthroughs
        if(activePowerUp > 0){
            spawnFire(); //check spawnfire
        }
    }    
    
    public void startGame(){
        isGameStarted = true;
        getWorld().addObject(new Clock(), 100, 100);
    }
    
    public void changeInvincibility(boolean status){
        isInvincible = status;
    }
    
    private void doPowerUp(int id){
        switch(id){
            case 1:
                spawnFire = true;
                spawnFireTimestamp = Clock.getTime();
                activePowerUp++;
                break;
            default:
                break;
        }
    }
    
    private void spawnFire(){
        if(spawnFire){
            getWorld().addObject(new FireTrail(), currentX, currentY);
            //insert fire spawn
            if(Clock.getTime() - spawnFireTimestamp > 5){
                spawnFire = false;
                activePowerUp--;
            }
        }
    }
}
