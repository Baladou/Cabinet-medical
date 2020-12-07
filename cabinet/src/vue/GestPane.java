package vue;


import java.awt.Graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * la classe Gestion nous permet de cr�er des instances de JPanel pour les utilis�s 
 * dans la cr�ation notre  JFrame de la page d'aceuil.
 * @author hp
 *
 */
public class GestPane extends JPanel {
	/***
	 * cette m�thode nous permet de d'ajouter un photo en arri�re plan de notre JPanel.
	 */
	public void paintComponent(Graphics g){
		
		try {
		      Image img = ImageIO.read(new File("C:\\\\Users\\\\hp\\\\eclipse-workspace"
		      		+ "\\\\poo\\\\src\\\\media\\\\img61.jpg"));
		     //g.drawImage(img, 0, 0, this);
		      //Pour une image de fon
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }     

	}
}