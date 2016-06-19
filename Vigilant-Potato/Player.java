import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player object
 * 
 * @author Leon Chang 
 * @version 1.0
 */
public class Player extends Actor
{
    public static boolean isInvincible;
    
    //PowerUps
    private int activePowerUp = 0;
    private boolean spawnFire = false;
    private boolean objTick; //Slow down spawning
    public static boolean machineGun = false;
    private int spawnFireTimestamp;
    private int machineGunTimestamp;
    
    private int currentX;
    private int currentY;
    
    public static int fixedX;
    public static int fixedY;
    public Player(){
        //GreenfootImage image = getImage();
        //image.scale(image.getWidth() - 280, image.getHeight() - 280);
        //setImage("potato.png");
        isInvincible = false;
        //getWorld().addObject(new Clock(), 100, 100);
    }

    public void act() 
    {
        if(((MyWorld)getWorld()).isGameStarted){
            if(Greenfoot.getMouseInfo() != null){
                MouseInfo info = Greenfoot.getMouseInfo();
                //turnTowards(info.getX(), info.getY());
                currentX = info.getX();
                currentY = info.getY();
                if(!machineGun)setLocation(currentX, currentY);
                //move(1);
            }
            
            Enemy stuff = (Enemy) getOneIntersectingObject(Enemy.class);
            if(stuff != null && !isInvincible && stuff.isHarmful) ((MyWorld)getWorld()).endGame(Clock.getTime());
            
            //if(isTouching(Enemy.class) && !isInvincible)((MyWorld)getWorld()).endGame(Clock.getTime());
               
                
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
        
        }else{
            //Self Destruct
            getWorld().removeObject(this);
        }
    }    
    
    public void changeInvincibility(boolean status){
        isInvincible = status;
    }
    
    private void doPowerUp(int id){
        switch(id){
            //FireTrail
            case 1:
                spawnFire = true;
                spawnFireTimestamp = Clock.getTime();
                activePowerUp++;
                break;
            //FireBall
            case 2:
                getWorld().addObject(new FireBall(30), currentX, currentY);
                getWorld().addObject(new FireBall(150), currentX, currentY);
                getWorld().addObject(new FireBall(270), currentX, currentY);
                break;
            //MachineGun
            case 3:
                machineGun = true;
                isInvincible = true;
                machineGunTimestamp = Clock.getTime();
                fixedX = currentX;
                fixedY = currentY;
                //Check if conflicting with spawnFire
                if(spawnFire)spawnFire = false;
                else activePowerUp++;
                break;
            case 4:
                getWorld().addObject(new Wiper(), 0, 350);
                break;
            case 5:
                getWorld().addObject(new Shield(), currentX, currentY);
                isInvincible = true;
            default:
                break;
        }
    }
    
    private void spawnFire(){
        if(spawnFire){
            if(objTick)getWorld().addObject(new FireTrail(), currentX, currentY);
            objTick = !objTick;
            if(Clock.getTime() - spawnFireTimestamp > 5){
                spawnFire = false;
                activePowerUp--;
            }
        }
    }
    
    private void machineGun(){
        if(machineGun){
            if(objTick)getWorld().addObject(new MachineGunProjectile(currentX, currentY), fixedX, fixedY);
            objTick = !objTick;
            //insert fire spawn
            if(Clock.getTime() - machineGunTimestamp > 5){
                machineGun = false;
                isInvincible = false;
                activePowerUp--;
            }
        }
    }
}
