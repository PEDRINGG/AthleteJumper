/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import UserInterface.GameScreen;
import static UserInterface.GameScreen.GROUNDY;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *Emerson Pedro Arago
 */
public class Land {
    
    private List<ImageLand> listImage;
    private BufferedImage imageLand1, imageLand2, imageLand3;
    
    public Land(GameScreen game) {
        imageLand1 = Resource.getResourceImage("data/floor1.png");    
        listImage = new ArrayList<ImageLand>();
        int numberOfLandTitle = 700 / imageLand1.getWidth() + 2;
        for(int i = 0; i< numberOfLandTitle; i++) {
        ImageLand imageLand = new ImageLand();
        imageLand.posX = (int) (i * imageLand1.getWidth()); 
        imageLand.image = imageLand1;
        listImage.add(imageLand);
    }
    }
    
    public void update(){
        for(ImageLand imageLand : listImage){
            imageLand.posX -= 2;
        }
        ImageLand firstElement = listImage.get(0);
        if(firstElement.posX + imageLand1.getWidth() < 0) {
            firstElement.posX = listImage.get(listImage.size() - 1).posX + imageLand1.getWidth();
            listImage.add(firstElement);
            listImage.remove(0);
        }
    }
    public void draw(Graphics g) {
        for(ImageLand imageLand:listImage) {
          g.drawImage(imageLand.image, imageLand.posX, (int) GROUNDY - 235, null);
     }
    }
    private class ImageLand {
        int posX;
        BufferedImage image;
    }
}
