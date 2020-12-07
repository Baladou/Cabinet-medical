package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.ConnectionDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
/***
 *  cette classe permet de créer la fenêtre qui permet à la secrétaire de
 *   gérer les plages horaires des médcins de 
 *   la cabinet.
 *   
 * @author zineb 
 *
 */

public class GestionPH extends JFrame {
	public static GestionPH frame;
	public static int firsttime=0;
	public static int Row=1;
	public static JTable tableau;
	public static DefaultTableModel Model; 

	GestPane p1 =new GestPane();
	ResultSet resultat;
	Connection cn=ConnectionDB.ConnectDB();
	
	int nbligne,  columnCount;
	 Object[][] data;
	 String date,id_Med,Heure_mat,Heure_soir;
   int id;
   
	
  
	
   /**
    * la constructeur de la classe GestionPH qui nous permet de l'instancier.
    */
	public GestionPH() {
		
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//this.setBounds(100, 100, 929, 433);
			this.setBounds(200, 200,1200, 500);
			p1.setBackground(SystemColor.activeCaptionBorder);
			//contentPane = new JPanel();
			p1.setBorder(new EmptyBorder(5, 5, 5, 5));
			this.setContentPane(p1);
			p1.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			/***
			 * ce bouton permet à la secrétaire de supprimer un plage horaire en selectionnant la ligne 
			 * désiré de la table affiché dans la fenêtre.
			 */
			
			JButton btnsupp = new JButton("Supprimer\r\n");
			btnsupp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						
						// récupérer le numéro de ligne selectionnée.
						int i = tableau.getSelectedRow();
						
					 // recupérer l'identifiant du ligne sélectionnée pour le supprimer de la base de données.
					int SelectedId=Integer.valueOf(tableau.
							getValueAt(tableau.getSelectedRow(), 0).toString());
					
					String qdel="DELETE from `PLAGE_HORRAIRE` where `ID`="+SelectedId;
					Statement stm=cn.createStatement();
					stm.executeUpdate(qdel);
					
			
					}
					catch(Exception ex) {
						// s'il ya un erreur d'insertion
						JOptionPane.showMessageDialog(null, ex);
					}
					
				}
			});
			btnsupp.setBackground(SystemColor.activeCaption);
			btnsupp.setBounds(355, 671, 142, 23);
			p1.add(btnsupp);
			
			JButton btnmod = new JButton("Modifier");
			btnmod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ModifierPH Mph=new ModifierPH(date,id_Med,Heure_mat,Heure_soir,tableau,Row,id);
	                   Mph.setVisible(true);
				}
			});
			btnmod.setBackground(SystemColor.activeCaption);
			btnmod.setBounds(609, 671, 136, 23);
			p1.add(btnmod);
			
			JButton btnajt = new JButton("Ajouter");
			btnajt.setBackground(SystemColor.activeCaption);
			btnajt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// pour ajouter un plage horaire on fait appel au frame AjouterPH
					
					AjouterPH AjtPH=new AjouterPH();
					AjtPH.setVisible(true);
				}
			});
			btnajt.setBounds(108, 671, 142, 23);
			p1.add(btnajt);
		
			/// appel de la fonction consulter qui permet de remplir le tableau à partir de la base de données.
			
			consulter();
				    tableau.setToolTipText("");
				    tableau.setRowSelectionAllowed(true);
				    
				    tableau.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent event) {
							Row = tableau.getSelectedRow();
							System.out.println(Row);
						}
					});
				   
				   
				    
				    JScrollPane scrollPane = new JScrollPane(tableau);
				    scrollPane.setBounds(23, 71, 939, 560);
				    p1.add(scrollPane);
				    
				    JLabel lblNewLabel = new JLabel("Plage Horaire des medcins");
				    lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 36));
				    lblNewLabel.setBounds(185, 11, 623, 49);
				    p1.add(lblNewLabel);
				    
				    JButton btnActualiser = new JButton("Actualiser");
				    btnActualiser.addActionListener(new ActionListener() {
				    	public void actionPerformed(ActionEvent e) {
				    		
				    		//ce bouton permet d'actualiser le tableau apés une suppression ou modification.
				    		
				    		firsttime++;
				    		consulter();
						    if(firsttime!=0) {
						    	 //frame.dispose();
								  frame = new GestionPH();
								  frame.setVisible(true);
						    }
				    		frame.update(getGraphics());
				    	}
				    });
				    btnActualiser.setBounds(1019, 71, 110, 23);
				    p1.add(btnActualiser);
				    
				    tableau.addMouseListener(new MouseAdapter(){
				        
				        @Override
				        public void mouseClicked(MouseEvent e){
				            
				        	/***
				        	 * recupérer les données du ligne sélectionnée pour les modifiées
				        	 */
				           
				        	id=Integer.valueOf(tableau.getValueAt(Row, 0).toString());
				            id_Med=tableau.getValueAt(Row, 1).toString();
				            date=tableau.getValueAt(Row, 2).toString();
				            Heure_mat=tableau.getValueAt(Row, 3).toString();
				            Heure_soir=tableau.getValueAt(Row, 4).toString();
				           
				            
				            		}
				        });
				  } 
	
	/**
	 * remplissage de la table des plages horaire.
	 */
	void consulter() {
		Statement statement;
		try {
			statement = cn.createStatement();
		
		Statement st=cn.createStatement();
		 String query="select * from PLAGE_HORRAIRE";
		 
		 

		 resultat=statement.executeQuery(query);
		 
		 
		 ResultSetMetaData resultsMetaData=resultat.getMetaData();
		  columnCount=resultsMetaData.getColumnCount();
		
		 resultat.last();
		 nbligne=resultat.getRow();
		 Object[][] data=new Object [nbligne][columnCount];
		 resultat.beforeFirst();
		 int j = 1;
		 while(resultat.next()) {
			 //out.write("<TR>");
		 for (int i=1;i<=columnCount;i++) {
				 
		    data[j-1][i-1]=resultat.getObject(i).toString();}
			  j++;    
			      
			   
		
			  String  title[] = {"ID Plage horaire", "ID Medcin","Date","Heure matin","Heure Soir"};
					  
			    tableau = new JTable(data, title);
			    
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



}
}
