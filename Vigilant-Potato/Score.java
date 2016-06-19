import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Screen
{
    public Score(int score){
        setImage(new GreenfootImage(" " + score, 48, new Color(0, 0, 0), new Color(0, 0, 0, 0)));
    }
    public void act(){
        //Self Destruct
        if(((MyWorld)getWorld()).isGameStarted) getWorld().removeObject(this);
    }
}
