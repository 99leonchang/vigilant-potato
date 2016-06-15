import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player object
 * 
 * @author Leon Chang 
 * @version 1.0
 */
public class Player extends Actor
{
    public boolean isGameStarted = false;
    public static boolean isInvincible;
    
    //PowerUps
    private int activePowerUp = 0;
    private boolean spawnFire = false;
    public static boolean machineGun = false;
    private int spawnFireTimestamp;
    private int machineGunTimestamp;
    
    private int currentX;
    private int currentY;
    
    public static int fixedX;
    public static int fixedY;
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
            if(!machineGun)setLocation(currentX, currentY);
            //move(1);
        }
        
        if(isTouching(Enemy.class) && !isInvincible)
            Greenfoot.stop();
           
            
        //List <A> objects = getIntersectingObjects(null);
        PowerUp a = (PowerUp) getOneIntersectingObject(PowerUp.class);
                
        if(a != null){
            doPowerUp(a.getID());
            getWorld().removeObject(a);
        }
        
        //PowerUp runthroughs
        if(activePowerUp > 0){
            spawnFire(); //check spawnfire
            machineGun();
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
            case 2:
                getWorld().addObject(new FireBall(30), currentX, currentY);
                getWorld().addObject(new FireBall(150), currentX, currentY);
                getWorld().addObject(new FireBall(270), currentX, currentY);
                break;
            case 3:
                machineGun = true;
                isInvincible = true;
                machineGunTimestamp = Clock.getTime();
                fixedX = currentX;
                fixedY = currentY;
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
    
    private void machineGun(){
        if(machineGun){
            getWorld().addObject(new MachineGunProjectile(currentX, currentY), fixedX, fixedY);
            //insert fire spawn
            if(Clock.getTime() - machineGunTimestamp > 5){
                machineGun = false;
                isInvincible = false;
                activePowerUp--;
            }
        }
    }
}
