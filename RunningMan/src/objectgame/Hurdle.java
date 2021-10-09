/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import util.Resource;

/**
 *
 *Emerson Arago
 */
public class Hurdle extends Enemy{
    
    private BufferedImage image;
    private int posX, posY;
    private Rectangle rect;
        
    public Hurdle() {
        image = Resource.getResourceImage("data/hurdle2.png");
        posX = 200;
        posY = 235;
        rect = new Rectangle();
        
    }
     public void update() {
         posX -= 3;
         rect.x = posX;
         rect.y = posY;
         rect.width = image.getWidth();
         rect.height = image.getHeight();
     }
    @Override
     public Rectangle getBound() {
       return rect;  
     }
     @Override
    public void draw(Graphics g) {
                g.drawImage(image, posX, posY, null);                       
    }
    public void setX(int x) {
        posX = x;
    }
    public void setY(int y) {
        posY = y;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    @Override
    public boolean isOutOfScreen() {
    return (posX + image.getWidth() < 0);
    }
}
