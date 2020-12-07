package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * la classe GestionPHmed permet au medcin de consulter les plages Horaires
 * @author zineb
 *
 */

public class GestionPHmed extends JFrame {
	
	public static GestionPHmed frame;
	public static int firsttime=0;
	public static int Row=1;
	public static JTable tableau;
	public static DefaultTableModel Model; 

	GestPane p1 =new GestPane();
	ResultSet resultat;
	Connection cn=ConnectionDB.ConnectDB();
	
	
	int nbligne,  columnCount;
	 Object[][] data;
	

	
	

	/**
	 * Create the frame.
	 */
/***
 * la constructeur de cette classe nous aide à faire appel à se classe quand on a besoin.
 */
	public GestionPHmed() {
		
			
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
			
			/**
			 * l'appel de la fonction consulter pour remplir le tableau par les information de la table 
			 * plage_horraire de la bese de données.
			 */
			
			consulter();
			
				    tableau.setToolTipText("");
				    tableau.setRowSelectionAllowed(true);
				    
				    //Nous ajoutons notre tableau à notre contentPane dans un scroll
				    //Sinon les titres des colonnes ne s'afficheront pas !
				   
				    
				    JScrollPane scrollPane = new JScrollPane(tableau);
				    scrollPane.setBounds(23, 71, 950, 606);
				    p1.add(scrollPane);
				    
				    JLabel lblNewLabel = new JLabel("Plage Horaire des medcins");
				    lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 36));
				    lblNewLabel.setBounds(185, 11, 623, 49);
				    p1.add(lblNewLabel);
	}
	/***
	 * le remplissage du tableau : nous avons essayer d'utilider l'api DBUtils mais nous ne savons pas pourquoi
	 * il ne marche pas parsuite nous avons optez pour cette méthode. 
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
