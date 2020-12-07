package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Ph1pane extends JPanel {
	public void paintComponent(Graphics g){
	
	try {
	      Image img = ImageIO.read(new File("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\poo\\\\src\\\\media\\\\sec.jpg"));
	     //g.drawImage(img, 0, 0, this);
	      //Pour une image de fon
	      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }    
}
}
//"C:\\Users\\hp\\eclipse-workspace\\poo\\src\\media\\sec.jpg