package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * 
 * @author hp
 *cette permet de définr la fenêtre qui affiche les Medicaments d'un patient
 */
public class Medicaments extends JFrame {
	
	RemPane p1=new RemPane();
   static String txt;
	

	/**
	 * Create the frame.
	 */
	public Medicaments(String txt) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 410);
		
		p1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p1);
		p1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(0, 148, 574, 104);
		p1.add(lblNewLabel);
		lblNewLabel.setText(txt);
		
		JLabel lblNewLabel_1 = new JLabel("Les M\u00E9dicaments");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 36));
		lblNewLabel_1.setBounds(10, 23, 324, 48);
		p1.add(lblNewLabel_1);
	}

}
