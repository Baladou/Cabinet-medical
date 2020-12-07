
package vue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Action;
import Controller.ConnectionDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * cette classe permet l'ajout d'un Plage Horaire 
 * @author hp
 *
 */

public class AjouterPH extends JFrame {
	ResultSet resultat;
	int rs;
	private JPanel contentPane;
	
	private JTextField Date;
	private JTextField Heure_Soir;
	private JTextField Heure_Matin;
	private JTextField ID_med;
	
	/**
	 * Create the frame.
	 */
	public AjouterPH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 474);
		contentPane = new JPanel();
		GestPane pane=new GestPane();
		//contentPane.add(pane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		pane.setLayout(null);
		setContentPane(pane);
		
		
		
		JButton btnNewButton = new JButton("Enregistrer");
		
		btnNewButton.setBounds(242, 375, 141, 23);
		pane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***
				 * appel de la fonction qui permet d'jouter une ligne  à la base de données.
				 *  */
				
				ajouter();
				
			
		
			}
		});
		
		
		JLabel lblDate = new JLabel("Date ");
		lblDate.setBounds(25, 200, 84, 14);
		pane.add(lblDate);
		
		JLabel lblHeure = new JLabel("Heure Matin");
		lblHeure.setBounds(39, 242, 86, 14);
		pane.add(lblHeure);
		JLabel lblmed = new JLabel("Id medcin");
		
		JLabel lblIdsecrtaire = new JLabel("Heure Soir");
		lblIdsecrtaire.setBounds(36, 280, 82, 14);
		pane.add(lblIdsecrtaire);
		
		Heure_Matin = new JTextField();
		Heure_Matin.setColumns(10);
		Heure_Matin.setBounds(135, 239, 159, 20);
		pane.add(Heure_Matin);
		
		Date = new JTextField();
		Date.setColumns(10);
		Date.setBounds(135, 197, 159, 20);
		pane.add(Date);
		
		ID_med = new JTextField();
		ID_med.setColumns(10);
		ID_med.setBounds(133, 316, 159, 20);
		pane.add(ID_med);
		
		Heure_Soir= new JTextField();
		Heure_Soir.setColumns(10);
		Heure_Soir.setBounds(133, 277, 159, 20);
		pane.add(Heure_Soir);
		
		JLabel lblEntrerlesDonnesDu = new JLabel("Entrez les donn\u00E9es du Rendez-vous");
		lblEntrerlesDonnesDu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblEntrerlesDonnesDu.setBounds(39, 46, 413, 45);
		pane.add(lblEntrerlesDonnesDu);
		
		
		//
		JLabel label = new JLabel("");
		label.setBounds(25, 200, 100, 14);
		pane.add(label);
		
		JLabel lblIdMedcin = new JLabel("Id Medcin");
		lblIdMedcin.setBounds(39, 319, 99, 14);
		pane.add(lblIdMedcin);
		
	}
	/****
	 * la méthode qui ajoute les informations données à la BD.
	 */
	void ajouter() {
		try {
			Connection cn=ConnectionDB.ConnectDB();
			Statement statement=cn.createStatement();
			
			
			
			String query2="INSERT INTO `PLAGE_HORRAIRE` VALUES ("+Action.update_id("PLAGE_HORRAIRE")+","
			+ID_med.getText().toString()+",'"+Date.getText().toString()+"', '"
					+Heure_Matin.getText().toString()+"' , '"+
				Heure_Soir.getText().toString()+"')";
			 statement.executeUpdate(query2);
			
			JOptionPane.showMessageDialog(null, "insertion réussite", "Information", JOptionPane.INFORMATION_MESSAGE);
			
		}
			
			
		 catch (SQLException e1) {
			// TODO Auto-generated catch block
			 e1.getStackTrace();
			JOptionPane.showMessageDialog(null, "insertion non effectuée", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
}
