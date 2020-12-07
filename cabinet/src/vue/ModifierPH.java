package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Controller.ConnectionDB;

import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ModifierPH extends JFrame {
	/***
	 * cette classe permet au secrétaire de modifier les informations d'un PH.
	 * @author hp
	 *
	 */

	private JPanel contentPane;
	
	ResultSet resultat;
	Connection cn=ConnectionDB.ConnectDB();
	Statement stm;
	
	

	

	
	/***
	 * la construcreur de cette classe prend en paramétres les
 * informations de ligne sélectionnées afin de les modifiées
	 * @param date
	 * @param id_med
	 * @param heure_mat
	 * @param heure_soir
	 * @param tableau
	 * @param row
	 * @param id
	 */
	public ModifierPH(String date,String id_med,String heure_mat,String heure_soir,JTable tableau,
			int row,int id) {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 474);
		contentPane = new JPanel();
		GestPane pane=new GestPane();
		//contentPane.add(pane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		pane.setLayout(null);
		setContentPane(pane);
		
		JTextField idmed= new JTextField();
		idmed.setColumns(10);
		idmed.setBounds(147, 135, 170, 20);
		idmed.setText(id_med);
		pane.add(idmed);
		

		JTextField Date = new JTextField();
		Date.setColumns(10);
		Date.setBounds(147, 170, 170, 20);
		Date.setText(date);
		pane.add(Date);
		
		JTextField heur_mat = new JTextField();
		heur_mat.setColumns(10);
		heur_mat.setBounds(147, 205, 170, 20);
		heur_mat.setText(heure_mat);
		pane.add(heur_mat);
		
		JTextField heur_soir = new JTextField();
		heur_soir.setColumns(10);
		heur_soir.setBounds(147, 237, 170, 20);
		heur_soir.setText(heure_soir);
		pane.add(heur_soir);
		/**
		 * enregistrer les modification entrées
		 */
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(row);
				 if(row >= 0) 
	                { /***
						 * recupérer les informations entées0
						 */
					 
					 String id_med1=idmed.getText().toString();
			         String heur_soir1=heur_soir.getText().toString();
			         String date1=Date.getText().toString();
			         String heure_mat1=heur_mat.getText().toString();
			           
	                   tableau.setValueAt(idmed.getText(), row, 1);
	                   tableau.setValueAt(heur_soir.getText(), row, 4);
	                   tableau.setValueAt(Date.getText(), row, 2);
	                   tableau.setValueAt(heur_mat.getText(), row, 3);
	                 
	                   
	                   try {
	                	   /**
				             * mettre les informations dans la table.
				             */
	                   String qupdate="UPDATE `cabinet medical`.`PLAGE_HORRAIRE` SET `ID_Médcin` ="+id_med1+", `Date` ='"+date1+"' , "
	                   		+ "`Heures_Matin` ='"+heure_mat1+"' ,`Heures_soir`='"+heur_soir1+"'  WHERE (`ID` ="+id+")";
			                //cn.commit();
	                   Statement s=cn.createStatement();
							s.executeUpdate(qupdate);
							JOptionPane.showMessageDialog(null, "modification réussite", "Information", JOptionPane.INFORMATION_MESSAGE);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
	                }
	                else{
	                    System.out.println("Update Error");
	                }
			}
		});
		btnNewButton.setBounds(242, 375, 141, 23);
		pane.add(btnNewButton);
		
		
		
		JLabel lblNomComplet = new JLabel("ID medcin\r\n");
		lblNomComplet.setBounds(39, 135, 89, 17);
		pane.add(lblNomComplet);
		
		JLabel lblDate = new JLabel("Date ");
		lblDate.setBounds(39, 170, 89, 14);
		pane.add(lblDate);
		
		JLabel lblHeure = new JLabel("Heure matin");
		lblHeure.setBounds(39, 205, 46, 14);
		pane.add(lblHeure);
		
		JLabel lblIdsecrtaire = new JLabel("Heure Soir");
		lblIdsecrtaire.setBounds(39, 240, 71, 14);
		pane.add(lblIdsecrtaire);
		
		
		
		
		JLabel lblEntrerlesDonnesDu = new JLabel("\r\nModification des donn\u00E9es du Rendez-Vous");
		lblEntrerlesDonnesDu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblEntrerlesDonnesDu.setBounds(39, 46, 448, 45);
		pane.add(lblEntrerlesDonnesDu);
		
	}

	

}
