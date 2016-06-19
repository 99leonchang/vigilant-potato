import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Screen extends Actor
{
    // instance variables - replace the example below with your own
    private int screenID;
    //private static GreenfootImage start = new GreenfootImage("startscreen.png");
    /**
     * Constructor for objects of class Screen
     */
    public Screen(int id)
    {
        screenID = id;
        switch(id){
            case 1:
                setImage("startscreen.png");
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    public void act(){
        if(Greenfoot.mousePressed(this)){
            int clickX=0, clickY=0;
            if(Greenfoot.getMouseInfo() != null){
                MouseInfo info = Greenfoot.getMouseInfo();
                clickX = info.getX();
                clickY = info.getY();
            }
            switch(screenID){
                case 1:
                    if(clickX>=357 && clickX<=642 && clickY>=300 && clickY<=400)
                        startGame();
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
    }
    
    public void startGame(){
        getWorld().addObject(new Player(), 500, 350);
        getWorld().addObject(new Clock(), 100, 100);
        ((MyWorld)getWorld()).isGameStarted = true;
        getWorld().removeObject(this);
    }
}
