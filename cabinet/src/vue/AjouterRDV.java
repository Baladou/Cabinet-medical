
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
 * cette classe permet l'ajout d'un Rendez-vous 
 * @author hp
 *
 */

public class AjouterRDV extends JFrame {
	ResultSet resultat;
	int rs;
	private JPanel contentPane;
	private JTextField Nom_Complet;
	private JTextField Date;
	private JTextField Heure;
	private JTextField ID_Sec;
	private JTextField id_med ;

	
	/**
	 * Create the frame.
	 */
	public AjouterRDV() {
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
				
				ajouter();
			
		
			}
		});
		
		
		JLabel lblDate = new JLabel("Date ");
		lblDate.setBounds(39, 225, 89, 14);
		pane.add(lblDate);
		
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setBounds(39, 255, 46, 14);
		pane.add(lblHeure);
		JLabel lblmed = new JLabel("Id medcin");
		
		JLabel lblIdsecrtaire = new JLabel("ID_Secr\u00E9taire");
		lblIdsecrtaire.setBounds(39, 315, 82, 14);
		pane.add(lblIdsecrtaire);
		
		Nom_Complet = new JTextField();
		Nom_Complet.setColumns(10);
		Nom_Complet.setBounds(158, 195, 159, 20);
		pane.add(Nom_Complet);
		
		Date = new JTextField();
		Date.setColumns(10);
		Date.setBounds(158, 225, 159, 20);
		pane.add(Date);
		
		Heure = new JTextField();
		Heure.setColumns(10);
		Heure.setBounds(158, 255, 159, 20);
		pane.add(Heure);
		
		id_med= new JTextField();
		id_med.setColumns(10);
		id_med.setBounds(158, 285, 159, 20);
		pane.add(id_med);
		
		JLabel lblEntrerlesDonnesDu = new JLabel("Entrez les donn\u00E9es du Rendez-vous");
		lblEntrerlesDonnesDu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblEntrerlesDonnesDu.setBounds(39, 46, 413, 45);
		pane.add(lblEntrerlesDonnesDu);
		
		ID_Sec = new JTextField();
		ID_Sec .setColumns(10);
		ID_Sec.setBounds(158, 315, 159, 20);
		pane.add(ID_Sec );
		//
		JLabel label = new JLabel("Nom Complet");
		label.setBounds(39, 195, 89, 14);
		pane.add(label);
		
		JLabel lblIdMedcin = new JLabel("Id Medcin");
		lblIdMedcin.setBounds(39, 285, 99, 14);
		pane.add(lblIdMedcin);
		
	}
	/***
	 * l'ajout d'un rendez-vous
	 */
	void ajouter() {
		try {
			Connection cn=ConnectionDB.ConnectDB();
			Statement statement=cn.createStatement();
			
			String Query1="SELECT ID FROM PLAGE_HORRAIRE WHERE ID_Médcin="+(id_med.getText().toString());
			resultat=statement.executeQuery(Query1);
			resultat.first();
			int id= resultat.getInt(1);
			System.out.println(id);
			
			String query2="INSERT INTO `RDV` VALUES ("+Action.update_id("RDV")+",'"
			+Nom_Complet.getText().toString()+"',"
					+ID_Sec.getText().toString()+",'"+
				Date.getText().toString()
			+"' ,'"+Heure.getText().toString()+"',"+id+")";
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
