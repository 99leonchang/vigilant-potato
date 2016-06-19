import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Manages Game screens (startscreens etc)
 * 
 * @author Leon Chang
 * @version 1.0
 */
public class Screen extends Actor
{
    private int screenID;
    //private static GreenfootImage start = new GreenfootImage("startscreen.png");
    /**
     * Constructor for objects of class Screen
     */
    public Screen(){
        
    }
    public Screen(int id)
    {
        /**
         * 
         */
        screenID = id;
        switch(id){
            //Start
            case 1:
                setImage("startscreen.png");
                break;
            //Credits
            case 2:
                setImage("credits.png");
                break;
            //Tutorial
            case 3:
                break;
            //End
            case 4:
                setImage("gameoverscreen.png");
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
                    if(clickX>=357 && clickX<=642 && clickY>=300 && clickY<=400)((MyWorld)getWorld()).startGame(this);
                    else if(clickX>=880 && clickY>=650) switchScreen(2, this);
                    break;
                case 2:
                    if(clickX>=900 && clickY>=640) switchScreen(1, this);
                    break;
                case 3:
                    break;
                case 4:
                    if(clickX>=355 && clickX<=645 && clickY>=490 && clickY<=590) switchScreen(1, this);
                    
                    break;
            }
        }
    }
    
    public void switchScreen(int screenID, Actor a){
        getWorld().addObject(new Screen(screenID), 500,350);
        getWorld().removeObject(a);
    }
}
