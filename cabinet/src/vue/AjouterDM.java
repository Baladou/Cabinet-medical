
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
 * cette classe permet l'ajout d'un Dossier Médical.
 * @author hp
 *
 */
public class AjouterDM extends JFrame {
	ResultSet resultat;
	int rs;
	private JPanel contentPane;
	private JTextField Nom_Complet;
	private JTextField Rem;
	private JTextField Medi ;
	private JTextField ID_Sec;
	private JTextField id_med ;
	private JTextField datecosn;

	
	public AjouterDM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 474);
		contentPane = new JPanel();
		GestPane pane=new GestPane();
		//contentPane.add(pane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		pane.setLayout(null);
		setContentPane(pane);
		
		
		
		JButton btnNewButton = new JButton("Enregistrer");
		
		btnNewButton.setBounds(311, 383, 141, 23);
		pane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ajouter();
			
		
			}
		});
		
		
		JLabel lblR = new JLabel("Remarques\r\n");
		lblR.setBounds(25, 195, 89, 14);
		pane.add(lblR);
		
		JLabel lblM = new JLabel("M\u00E9dicaments");
		lblM.setBounds(25, 225, 96, 14);
		pane.add(lblM);
		JLabel lblmed = new JLabel("Id medcin");
		
		JLabel lblIdsecrtaire = new JLabel("ID_Secr\u00E9taire");
		lblIdsecrtaire.setBounds(25, 285, 82, 14);
		pane.add(lblIdsecrtaire);
		
		Nom_Complet = new JTextField();
		Nom_Complet.setColumns(10);
		Nom_Complet.setBounds(158, 165, 159, 20);
		pane.add(Nom_Complet);
		
		Rem = new JTextField();
		Rem.setColumns(10);
		Rem.setBounds(158, 195, 159, 20);
		pane.add(Rem);
		
		Medi = new JTextField();
		Medi.setColumns(10);
		Medi.setBounds(158, 225, 159, 20);
		pane.add(Medi);
		
		id_med= new JTextField();
		id_med.setColumns(10);
		id_med.setBounds(158, 255, 159, 20);
		pane.add(id_med);
		
		JLabel lblEntrerlesDonnesDu = new JLabel("Entrez les donn\u00E9es du Dossier M\u00E9dical");
		lblEntrerlesDonnesDu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblEntrerlesDonnesDu.setBounds(39, 46, 413, 45);
		pane.add(lblEntrerlesDonnesDu);
		
		ID_Sec = new JTextField();
		ID_Sec .setColumns(10);
		ID_Sec.setBounds(158, 285, 159, 20);
		pane.add(ID_Sec );
		//
		JLabel lblNomComplet = new JLabel("Nom Patient");
		lblNomComplet.setBounds(25, 165, 89, 14);
		pane.add(lblNomComplet);
		
		JLabel lblIdMedcin = new JLabel("Id Medcin");
		lblIdMedcin.setBounds(25, 255, 109, 14);
		pane.add(lblIdMedcin);
		
		JLabel lblDateDeConsultation = new JLabel("Date de Consultation");
		lblDateDeConsultation.setBounds(25, 315, 109, 14);
		pane.add(lblDateDeConsultation);
		
		datecosn = new JTextField();
		datecosn.setBounds(158, 315, 159, 20);
		pane.add(datecosn);
		datecosn.setColumns(10);
		
	}
	/**
	 * la méthode qui permet l'ajout d'un dossier médical à la BD.
	 */
	void ajouter() {
		try {
			Connection cn=ConnectionDB.ConnectDB();
			Statement statement=cn.createStatement();
			
			String query2="INSERT INTO `DM` VALUES ("+Action.update_id("DM")+",'"
			+Nom_Complet.getText().toString()+"','"
				+Rem.getText().toString()
			+"','"+Medi.getText().toString()+"','"+datecosn.getText().toString()+"',"
				+id_med.getText().toString()+","+id_med.getText().toString()+")";
			 statement.executeUpdate(query2);
			
			JOptionPane.showMessageDialog(null, "insertion réussite", "Information", 
					JOptionPane.INFORMATION_MESSAGE);
			
		}
			
			
		 catch (SQLException e1) {
			// TODO Auto-generated catch block
			 e1.getStackTrace();
			JOptionPane.showMessageDialog(null, "insertion non effectuée", "Erreur",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
