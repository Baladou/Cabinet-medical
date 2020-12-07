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
/***
 * cette classe permet au secrétaire de modifier les informations d'un RDV.
 * @author hp
 *
 */

public class ModifierRDV extends JFrame {

	private JPanel contentPane;
	
	ResultSet resultat;
	Connection cn=ConnectionDB.ConnectDB();
	Statement stm;
	
	static String nom;
	static String id_sec;
	static String date;
	static String heure;
	static String id_ph;
	static JTable tableau;
	static int row,id;

	
	
/***
 * la construcreur de cette classe prend en paramétres les
 *  informations de ligne sélectionnées afin de les modifiées
 * @param nom
 * @param id_sec
 * @param date
 * @param heure
 * @param id_ph
 * @param tableau
 * @param row
 * @param id
 */
	
	public ModifierRDV(String nom,String id_sec,String date,String heure,String id_ph,JTable tableau,
			int row,int id) {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 474);
		contentPane = new JPanel();
		GestPane pane=new GestPane();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		pane.setLayout(null);
		setContentPane(pane);
		
		JLabel id_PH = new JLabel("ID_Plage");
		id_PH.setBounds(39, 260, 89, 14);
		pane.add(id_PH);
		
		JTextField id_plage = new JTextField();
		id_plage.setBounds(147, 260, 159, 20);
		pane.add(id_plage);
		id_plage.setText(id_ph);
		id_plage.setColumns(10);
		
		JTextField Nom= new JTextField();
		Nom.setColumns(10);
		Nom.setBounds(147, 140, 159, 20);
		Nom.setText(nom);
		pane.add(Nom);
		

		JTextField Date = new JTextField();
		Date.setColumns(10);
		Date.setBounds(147, 170, 159, 20);
		Date.setText(date);
		pane.add(Date);
		
		JTextField Heure_field = new JTextField();
		Heure_field.setColumns(10);
		Heure_field.setBounds(147, 200, 159, 20);
		Heure_field.setText(heure);
		pane.add(Heure_field);
		
		JTextField Secid_field = new JTextField();
		Secid_field.setColumns(10);
		Secid_field.setBounds(147, 230, 159, 20);
		Secid_field.setText(id_sec);
		pane.add(Secid_field);
		/**
		 * enregistrer les modification entrées
		 */
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(row);
				 if(row >= 0) 
	                {
					 /***
						 * recupérer les informations entées0
						 */
					 String nom1=Nom.getText().toString();
					
			            String id_sec1=Secid_field.getText().toString();
			            
			            String date1=Date.getText().toString();
			           
			            String heure1=Heure_field.getText().toString();
			            String id_ph1=id_plage.getText().toString();
			            /**
			             * mettre les informations dans la table.
			             */
	                   tableau.setValueAt(Nom.getText(), row, 1);
	                   tableau.setValueAt(Secid_field.getText(), row, 2);
	                   tableau.setValueAt(Date.getText(), row, 3);
	                   tableau.setValueAt(Heure_field.getText(), row, 4);
	                   tableau.setValueAt(id_plage.getText(), row, 5);
	                 /**
	                  * modifier la base de données.  
	                  */
	                   try {
	                   String qupdate="UPDATE `cabinet medical`.`RDV` SET `Nom_Patient` ='"+nom1+"', `ID_Sec` ="+id_sec1+" ,`Date` ='"+date1+"' , "
	                   		+ "`Heure` ='"+heure1+"' ,`ID_PH`="+id_ph1+"  WHERE (`ID` ="+id+")";
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
		btnNewButton.setBounds(270, 372, 141, 23);
		pane.add(btnNewButton);
		
		
		
		JLabel lblNomComplet = new JLabel("Nom Complet");
		lblNomComplet.setBounds(39, 140, 89, 14);
		pane.add(lblNomComplet);
		
		JLabel lblDate = new JLabel("Date ");
		lblDate.setBounds(39, 170, 89, 14);
		pane.add(lblDate);
		
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setBounds(39, 200, 46, 14);
		pane.add(lblHeure);
		
		JLabel lblIdsecrtaire = new JLabel("ID_Secr\u00E9taire");
		lblIdsecrtaire.setBounds(39, 230, 71, 14);
		pane.add(lblIdsecrtaire);
		
		
		
		
		JLabel lblEntrerlesDonnesDu = new JLabel("\r\nModification des donn\u00E9es du Rendez-Vous");
		lblEntrerlesDonnesDu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblEntrerlesDonnesDu.setBounds(39, 46, 448, 45);
		pane.add(lblEntrerlesDonnesDu);
		
	}

	

}
