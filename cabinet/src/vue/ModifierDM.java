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


/**
 * cette classe permet au secrétaire de modifier les informations d'un DM.
 * @author hp
 *
 */
public class ModifierDM extends JFrame {

	private JPanel contentPane;
	
	ResultSet resultat;
	Connection cn=ConnectionDB.ConnectDB();
	Statement stm;
	
	static String nom;
	static String id_sec;
	static String date;
	static String Rem;
	static String Medi;
	static String id_Med;
	static JTable tableau;
	static int row,id;
	private JTextField txtIdsec;
	private JTextField Sectext;

	/**
	 * a construcreur de cette classe prend en paramétres les
 * informations de ligne sélectionnées afin de les modifiées
	 * @param nom
	 * @param id_sec
	 * @param date
	 * @param Rem
	 * @param Medi
	 * @param id_Med
	 * @param tableau
	 * @param row
	 * @param id
	 */
	public ModifierDM(String nom,String id_sec,String date,String Rem,String Medi,String id_Med,JTable tableau,
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
		
		JLabel id_PH = new JLabel("ID Medcin");
		id_PH.setBounds(39, 255, 89, 14);
		pane.add(id_PH);
		
		JTextField id_med = new JTextField();
		id_med.setBounds(158, 255, 177, 20);
		pane.add(id_med);
		id_med.setText(id_Med);
		id_med.setColumns(10);
		
		JTextField Nom= new JTextField();
		Nom.setColumns(10);
		Nom.setBounds(158, 135, 177, 20);
		Nom.setText(nom);
		pane.add(Nom);
		

		JTextField remrq = new JTextField();
		remrq.setColumns(10);
		remrq.setBounds(158, 165, 177, 20);
		remrq.setText(Rem);
		pane.add(remrq);
		
		JTextField medic = new JTextField();
		medic.setColumns(10);
		medic.setBounds(158, 195, 177, 20);
		medic.setText(Medi);
		pane.add(medic);
		
		JTextField datec = new JTextField();
		datec.setColumns(10);
		datec.setBounds(158, 226, 177, 20);
		datec.setText(date);
		pane.add(datec);
		
		Sectext = new JTextField();
		Sectext.setBounds(158, 285, 177, 20);
		pane.add(Sectext);
		Sectext.setText(id_sec);
		Sectext.setColumns(10);
		
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
					
			            String datec1=datec.getText().toString();
			            String remrq1=remrq.getText().toString();
			         
			            String medic1=medic.getText().toString();
			            String id_med1=id_med.getText().toString();
			            String nom=Nom.getText().toString();
			            String id_sec1=Sectext.getText().toString();
			            
	                   tableau.setValueAt(Nom.getText(), row, 1);
	                   tableau.setValueAt(datec.getText(), row, 2);
	                   tableau.setValueAt(remrq.getText(), row, 3);
	                   tableau.setValueAt(medic.getText(), row, 4);
	                   tableau.setValueAt(id_med.getText(), row, 5);
	                   
	                   try {
	                	   /**
				             * mettre les informations dans la table.
				             */
	                   String qupdate="UPDATE `cabinet medical`.`DM` SET `Nom_Patient` ='"+nom+"', `Remarques` ='"+remrq1+"' ,`Médicaments` ='"+medic1+"' , "
	                   		+ "`Date_consult` ='"+datec1+"' ,`ID_Médcin`="+id_med1+" ,`ID_secrétaire`="+id_sec1+"  WHERE (`ID` ="+id+")";
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
		
		
		
		JLabel lblNomComplet = new JLabel("Nom Patient");
		lblNomComplet.setBounds(39, 135, 112, 14);
		pane.add(lblNomComplet);
		
		JLabel lblDate = new JLabel("Remarques\r\n");
		lblDate.setBounds(39, 165, 89, 14);
		pane.add(lblDate);
		
		JLabel med = new JLabel("M\u00E9dicaments");
		med.setBounds(39, 195, 89, 20);
		pane.add(med);
		
		JLabel lblIdsecrtaire = new JLabel("date Consultation");
		lblIdsecrtaire.setBounds(35, 225, 93, 14);
		pane.add(lblIdsecrtaire);
		
		
		
		
		JLabel lblEntrerlesDonnesDu = new JLabel("\r\nModification des donn\u00E9es du Rendez-Vous");
		lblEntrerlesDonnesDu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblEntrerlesDonnesDu.setBounds(39, 46, 448, 45);
		pane.add(lblEntrerlesDonnesDu);
		
		JLabel lblNewLabel = new JLabel("ID Secr\u00E9taire");
		lblNewLabel.setBounds(42, 285, 86, 14);
		pane.add(lblNewLabel);
		
	
		
	}
}
