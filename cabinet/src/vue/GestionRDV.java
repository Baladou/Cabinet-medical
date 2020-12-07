package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.Action;
import Controller.ConnectionDB;
import model.poo.RDV;


import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *  la classe GestionRDV permet à la secrétaire de faire la gestion des rendez-vous.
 * @author zineb
 *
 */

public class GestionRDV extends JFrame {
	public static GestionRDV frame;
	public static int firsttime=0;
	public static int Row=1;
	public static JTable tableau;
	public static DefaultTableModel Model; 
	
	ResultSet resultat;
	Connection cn=ConnectionDB.ConnectDB();
	Statement stm=cn.createStatement();
	GestPane p1 =new GestPane();
	int nbligne,  columnCount;
	 Object[][] data;
	 ModifierRDV Mrdv;
	 String nom,date,heure,id_p,id_sec,id_ph;
    
     int id;
   
 	
	 
	
	
	/**
	 * la constructeur de la classe  GestionRDV.
	 * @throws SQLException 
	 */
	public GestionRDV() throws SQLException {
		
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setBounds(200, 200,1200, 500);
	p1.setBackground(SystemColor.activeCaptionBorder);
	
	p1.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.setContentPane(p1);
	 this.setLocationRelativeTo(null);
	 this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	
	 /***
	  * supprimer un ligne de la table.
	  */
	JButton btnNewButton = new JButton("Supprimer\r\n");
	btnNewButton.setBounds(416, 596, 142, 23);
	
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//get index row
			try {
				int i = tableau.getSelectedRow();
			
		
			 
			int SelectedId=Integer.valueOf(tableau.
					getValueAt(tableau.getSelectedRow(), 0).toString());
			
			String qdel="DELETE from `RDV` where `ID`="+SelectedId;
			stm.executeUpdate(qdel);
			
	
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
			
			
		}
	});
	p1.setLayout(null);
	
	
	
		

	btnNewButton.setBackground(SystemColor.activeCaption);
	p1.add(btnNewButton);
	
	/**
	 * 
	 * ajouter un ligne 
	 */
	
	JButton btnNewButton_2 = new JButton("Ajouter");
	btnNewButton_2.setBounds(150, 596, 142, 23);
	btnNewButton_2.setBackground(SystemColor.activeCaption);
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			/**
			 * appel au frame qui permet l' ajout .
			 */
			AjouterRDV Ardv=new AjouterRDV();
			Ardv.setVisible(true);
			
		}
	});
	p1.add(btnNewButton_2);
	
	consulter();
	
	tableau.setToolTipText("");
	tableau.setRowSelectionAllowed(true);
	/**
	 * selection du ligne avant suppression et modification.
	 */
	tableau.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent event) {
			Row = tableau.getSelectedRow();
			
		}
	});
		    
		   
		    
		    JScrollPane scrollPane = new JScrollPane(tableau);
		    scrollPane.setBounds(28, 82, 963, 479);
		    p1.add(scrollPane);
		    scrollPane.setViewportView(tableau);
		    /**
		     * actualisation du frame après modification ou suppression.
		     */
		    JButton btnActualiser = new JButton("Actualiser");
		    btnActualiser.setBackground(SystemColor.activeCaption);
		    btnActualiser.setBounds(1001, 82, 121, 23);
		    btnActualiser.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		firsttime++;
		    		consulter();
				    if(firsttime!=0) {
				    	
						  try {
							frame = new GestionRDV();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  frame.setVisible(true);
				   }
		    		frame.update(getGraphics());
		    	}
		    });
		    p1.add(btnActualiser);
		    /**
		     * modification d'un ligne enappelant la frame ModifierRDV
		     */
		    JButton btnModifier = new JButton("Modifier");
		    btnModifier.setBackground(SystemColor.activeCaption);
		    btnModifier.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		  
		           Mrdv=new ModifierRDV(nom,id_sec,date,heure,id_ph,tableau,Row,id);
                   Mrdv.setVisible(true);
		    		
		    	}
		    });
		    btnModifier.setBounds(692, 596, 142, 23);
		    p1.add(btnModifier);
		    
		    JLabel lblNewLabel = new JLabel("Gestion des Rendez-vous");
		    lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 36));
		    lblNewLabel.setBounds(76, 32, 466, 39);
		    p1.add(lblNewLabel);
		    tableau.addMouseListener(new MouseAdapter(){
		        
		        @Override
		        public void mouseClicked(MouseEvent e){
		            
		           
		        	 id=Integer.valueOf(tableau.getValueAt(Row, 0).toString());
		            nom=tableau.getValueAt(Row, 1).toString();
		            id_sec=tableau.getValueAt(Row, 2).toString();
		            date=tableau.getValueAt(Row, 3).toString();
		            heure=tableau.getValueAt(Row, 4).toString();
		            id_ph=tableau.getValueAt(Row, 5).toString();
		            
		            		}
		        });
		   
		  }   
	/*public void remplir(JTable tableau) {
		  try {
			  String query="select * from RDV";
			Statement statement=cn.createStatement();
			PreparedStatement prepared=cn.prepareStatement(query);
			
			 resultat=prepared.executeQuery(query);
			 tableau.setModel(DbUtils.resultSetToTableModel(resultat));
					 
			 
		}
		  catch(SQLException e) {
			  e.printStackTrace();
		  }
			  
		  }*/
			
			void consulter() {
				Statement statement;
				try {
					statement = cn.createStatement();
				
				
				 String query="select * from RDV";
				 resultat=statement.executeQuery(query);
				 
				 ResultSetMetaData resultsMetaData=resultat.getMetaData();
				  columnCount=resultsMetaData.getColumnCount();
				
				 resultat.last();
				 nbligne=resultat.getRow();
				 Object[][] data=new Object [nbligne][columnCount];
				 resultat.beforeFirst();
				 int j = 1;
				 while(resultat.next()) {
					 
				 for (int i=1;i<=columnCount;i++) {
						 
				    data[j-1][i-1]=resultat.getObject(i).toString();}
					  j++;    
					      
					   
				
					    String  title[] = {"ID RDV","Nom Patient","ID secrétaire","Date","Heure","ID Plage Horraire"};

					    tableau = new JTable(data, title);
					    
			}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
		

}
}