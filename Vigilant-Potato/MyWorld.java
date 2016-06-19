import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public boolean isGameStarted = false;
    public int highScore = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        //addObject(new Player(), 500, 350);
        //addObject(new Clock(), 100, 100);
        addObject(new Screen(1), 500,350);
    }
    
    public void startGame(Actor screen){
        addObject(new Player(), 500, 350);
        addObject(new Clock(), 100, 100);
        isGameStarted = true;
        removeObject(screen);
    }
    
    public void endGame(int score){
        isGameStarted = false;
        if(score>highScore) highScore = score;
        addObject(new Screen(4), 500,350);
        addObject(new Score(score),500,260);
        addObject(new Score(highScore),500,420);
    }
}

