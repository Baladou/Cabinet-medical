package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
/**
 * 
 * @author hp
 *cette permet de définr la fenêtre qui affiche les Remarques de la situation  d'un patient
 */
public class Remarques extends JFrame {

	RemPane p1=new RemPane();
    static String  text;
	

	/**
	 * Create the frame.
	 */
	public Remarques(String text) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 410);
		
		p1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p1);
		p1.setLayout(null);
		
		JLabel rmq = new JLabel("Les Remarques");
		
		rmq.setFont(new Font("Times New Roman", Font.ITALIC, 36));
		rmq.setBounds(24, 24, 396, 48);
		p1.add(rmq);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(0, 146, 571, 106);
		p1.add(lblNewLabel);
		lblNewLabel.setText(text);
		
	}
}
