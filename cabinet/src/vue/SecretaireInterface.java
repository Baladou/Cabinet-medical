package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.Window.Type;
/***
 * cette JFrame nous permet de créer la vue de la secrétaire 
 * lors de sa connexion à l'application et il contient l'ensemble des tâches que la secrétaire doit gérer.
 * @author hp
 *
 */
public class SecretaireInterface extends JFrame {

	private Ph1pane p1=new Ph1pane();;
	private JTextField saisifield;
	private JTextField textField;
	/***
	 * la constructeur de la classe SecretaireInterface permet d'instancier la classe.
	 */
	


	public SecretaireInterface() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 663, 379);
		p1.setBackground(SystemColor.activeCaptionBorder);
		//contentPane = new JPanel();
		p1.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(p1);
		p1.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		/***
		 * bouton pour choisir Gestion des Plages Horaires.
		 */
		JButton btnNewButton = new JButton("Gestion des Plages Horaires");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * l'appel du frame qui permet de gérer les plages horaires.
				 */
				GestionPH gph=new GestionPH(); 
				gph.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(403, 129, 217, 23);
		p1.add(btnNewButton);
		
		/***
		 * bouton pour choisir Gestion des Dossiers médicaux.
		 */
		JButton btnNewButton_1 = new JButton("Gestion des Dossiers M\u00E9dicaux");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * l'instanciation du frame qui permet la gestion des dossiers médicaux.
				 */
				GestionDM gdm=new GestionDM();
				gdm.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.setBounds(403, 174, 217, 29);
		p1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Bienvenue");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setBounds(10, 11, 537, 58);
		p1.add(lblNewLabel);
		/****
		 * cette boutton permet à la secrétaire de gérer  les rendez-vous.
		 */
		JButton btnGestionDesRendezvous = new JButton("Gestion des Rendez-Vous");
		btnGestionDesRendezvous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionRDV rdv;
				try {
					/***
					 * l'instanciation du frame qui permet de gérer les rendez-vous.
					 */
					rdv = new GestionRDV();
					rdv.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnGestionDesRendezvous.setBackground(Color.PINK);
		btnGestionDesRendezvous.setBounds(403, 221, 217, 23);
		p1.add(btnGestionDesRendezvous);
		
		
	}
}
