package vue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panne extends JPanel {
	 protected void paintComponent(Graphics g){
		    try {
		      Image img = ImageIO.read(new File("C:\\\\Users\\\\hp\\\\eclipse-workspace"
			      		+ "\\\\poo\\\\src\\\\media\\\\med.jpg"));
		      
		     // g.drawImage(img, 0, 0, this); //observer l'image
		      //Pour une image de fond
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); //observer une image tant que fond d'ecran
		    } catch (IOException e) {
		      e.printStackTrace();
		    }                
		  }             

}
