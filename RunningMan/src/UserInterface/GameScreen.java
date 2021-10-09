/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import objectgame.Clouds;
import objectgame.EnemiesManager;
import objectgame.Hurdle;
import objectgame.Land;
import objectgame.MainCharacter;
/**
 *
 * @author E P A
 */
public class GameScreen extends JPanel implements Runnable, KeyListener{
    public static final float GRAVITY = 0.7f;
    public static final float GROUNDY = 280;
   
    private MainCharacter mainCharacter;
    private Thread thread;
    private Land land;
    private Clouds clouds;
    private EnemiesManager enemiesManager;
    
    public GameScreen() {
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
        mainCharacter.setX(30);
        land = new Land(this);
        clouds = new Clouds();
        enemiesManager = new EnemiesManager();
        
    }
    
    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while(true) {
            mainCharacter.update();
            land.update();
            clouds.update();
            enemiesManager.update();
            
            
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.decode("#daf7fe"));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        g.drawLine(0, (int)GROUNDY, getWidth(), (int)GROUNDY);
        clouds.draw(g);
        land.draw(g);
        mainCharacter.draw(g);
        enemiesManager.draw(g);
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
      mainCharacter.jump();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }
}
