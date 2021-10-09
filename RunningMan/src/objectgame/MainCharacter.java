/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import static UserInterface.GameScreen.GRAVITY;
import static UserInterface.GameScreen.GROUNDY;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import util.Animation;


/**
 *
 * Emerson Pedro S. Arago II
 */
public class MainCharacter {
     private float x = 0;
    private float y = 0;
    private float speedY = 0;
    private Animation characterRun;
    private Rectangle rect;
    
    public MainCharacter() {
        characterRun= new Animation(200);
        characterRun.addFrame(Resource.getResourceImage("data/Run.png"));
        characterRun.addFrame(Resource.getResourceImage("data/Run2.png"));
        rect = new Rectangle();

        
    }
    
    public void update() {
        characterRun.update();
        //all of this code is for jumping
        if(y >= GROUNDY - characterRun.getFrame().getHeight()) {
                speedY = 0;
                y= GROUNDY - characterRun.getFrame().getHeight();
            } else {
            speedY+=GRAVITY;
           y+=speedY;
    }
    rect.x = (int) x;
    rect.y = (int) y;
    rect.width = characterRun.getFrame().getWidth();
    rect.height = characterRun.getFrame().getHeight();
            }
    
    public Rectangle getBound () {
        return rect;
    }
    public void draw(Graphics g) {
         g.setColor(Color.BLACK);
        g.drawRect((int) x,(int) y, characterRun.getFrame().getWidth(), characterRun.getFrame().getHeight());
        g.drawImage(characterRun.getFrame(), (int) x, (int) y, null);
      
    }
    public void jump() {
        speedY = -16;
        y += speedY;
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
    
    
}
