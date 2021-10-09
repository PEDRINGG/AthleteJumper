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
import java.util.Random;

/**
 *
 * @author E P A
 */
public class EnemiesManager {
    private List<Enemy> enemies;
    private Random random;
    private BufferedImage imageHurdle2, imageHurdle3;
    
    public EnemiesManager() {
        enemies = new ArrayList<Enemy>();
        imageHurdle2 = Resource.getResourceImage("data/hurdle2.png");
        imageHurdle3 = Resource.getResourceImage("data/hurdle3.png");
        random = new Random();
        
        enemies.add(getRandomHurdle());  
        random = new Random();
    }
    
    public void update() {
        for(Enemy e : enemies) {
            e.update();
        }
        Enemy firstEnemy = enemies.get(0);
        if(firstEnemy.isOutOfScreen()) {
            enemies.remove(firstEnemy);
            enemies.add(getRandomHurdle());
        }
    }
    
    public void draw(Graphics g) {
        for(Enemy e : enemies) {
            e.draw(g);
        }
    }
    
    private Hurdle getRandomHurdle () {
        Hurdle hurdle;
        hurdle = new Hurdle();
        hurdle.setX(500);
        if(random.nextBoolean()) {           
            hurdle.setImage(imageHurdle2);
        } else {
            hurdle.setImage(imageHurdle3);
        }
        return hurdle;
    }
}
