/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Sample comment.
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
    // Edited by AA.
    public static final int GAME_FIRST_STATE = 0;
    public static final int GAME_PLAY_STATE = 1;
    public static final int GAME_OVER_STATE = 2;
    public static final float GRAVITY = 0.7f;
    public static final float GROUNDY = 280;
   
    private MainCharacter mainCharacter;
    private Thread thread;
    private Land land;
    private Clouds clouds;
    private EnemiesManager enemiesManager;
    
    // Edited by AA.
    private int gameState = GAME_FIRST_STATE;
    
    public GameScreen() {
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
        mainCharacter.setX(30);
        land = new Land(this);
        clouds = new Clouds();
        enemiesManager = new EnemiesManager(mainCharacter); // Edited by AA.
        
    }
    
    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while(true) {
            // Edited by AA.
            update();
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   // Edited by AA. 
    public void update(){
        switch (gameState){
            case GAME_PLAY_STATE:
                 mainCharacter.update();
                 land.update();
                 clouds.update();
                 enemiesManager.update();
                 if (!mainCharacter.getAlive()) {
                     gameState = GAME_OVER_STATE;
                 }
                 break;
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
        
        // Edited by AA.
        switch (gameState){
            case GAME_FIRST_STATE:
                 mainCharacter.draw(g);
                break;
            case GAME_PLAY_STATE:
                clouds.draw(g);
                land.draw(g);
                mainCharacter.draw(g);
                enemiesManager.draw(g);
                break;
        }
                
        
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
        switch (e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                if (gameState = GAME_FIRST_STATE){
                    gameState = GAME_PLAY_STATE;
                }
                
                break;
        }
    }
}
