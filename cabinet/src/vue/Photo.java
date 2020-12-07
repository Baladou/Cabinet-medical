package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/***
 * la classe Photo nous permet de créer des 
 * instances de JPanel pour les utilisés dans la création des JFrame.
 * @author hp
 *
 */
public class Photo extends JPanel {
	/***
	 * cette méthode nous permet de d'ajouter un photo en arrière plan de notre JPanel
	 */
	 public void paintComponent(Graphics g){
		  
			
			try {
			      Image img = ImageIO.read(new File("C:\\Users\\hp\\eclipse-workspace\\poo\\src\\media\\acuiel.jpg"));
			     //g.drawImage(img, 0, 0, this);
			      //Pour une image de fond
			      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			    } catch (IOException e) {
			      e.printStackTrace();
			    }     

}
}