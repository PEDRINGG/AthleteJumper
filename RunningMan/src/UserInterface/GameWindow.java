/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import  javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author E P A
 */
public class GameWindow extends JFrame{
    
    private GameScreen gameScreen;
    
   public GameWindow() {
       super("Running Man");
       setSize(600,400);
       setLocation(500,300);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       gameScreen = new GameScreen();
       add(gameScreen);
       addKeyListener(gameScreen);
   }
   
   public void startGame() {
    gameScreen.startGame();
   }
   
   public static void main(String args[]) {
       GameWindow gw = new GameWindow();
       gw.setVisible(true);
       gw.startGame();  
   }
   
}
