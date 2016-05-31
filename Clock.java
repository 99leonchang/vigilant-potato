import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Clock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clock extends Actor
{
    private static long start;
    public Clock(){
        start = System.currentTimeMillis();
    }
    /**
     * Act - do whatever the Clock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int diff = ((int)System.currentTimeMillis() - (int)start)/1000;
        GreenfootImage textImage = new GreenfootImage(" " + diff, 24, new Color(0, 255, 128), new Color(0, 0, 0, 0));
        setImage(textImage);
    }    
}
