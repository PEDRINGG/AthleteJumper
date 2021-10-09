/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Arago
 */
public class Clouds {
    private BufferedImage cloudImage;
    private List<Cloud> clouds;
    
    public Clouds() {
        cloudImage = Resource.getResourceImage("data/cloud.png");
        clouds = new ArrayList<Cloud>();
        
        Cloud cloud1 = new Cloud();
        cloud1.posX = 0;
        cloud1.posY = 0;        
        clouds.add(cloud1);
        
        cloud1 = new Cloud();
        cloud1.posX = 500;
        cloud1.posY = 10;        
        clouds.add(cloud1);
        
    }
    public void update() {
        for(Cloud cloud : clouds) {
            cloud.posX --;
        }
        
        Cloud firstCloud = clouds.get(0);
        if(firstCloud.posX + cloudImage.getWidth() < 0) {
            firstCloud.posX = 550;
            clouds.remove(firstCloud);
            clouds.add(firstCloud);
        }
    }
    
    public void draw(Graphics g) {
        for(Cloud cloud : clouds) {
        g.drawImage(cloudImage, (int) cloud.posX, (int) cloud.posY, null);
     }
    }
    
    private class Cloud {
        float posX;
        float posY;
    }
}
