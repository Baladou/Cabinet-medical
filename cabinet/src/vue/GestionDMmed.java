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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.ConnectionDB;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;


/***
 * la classe GestionPHmed permet au medcin de consulter les dossiers médicaux.
 * @author zineb
 *
 */
public class GestionDMmed extends JFrame {
	
	public static GestionDMmed frame;
	public static int firsttime=0;
	public static int Row=0;
	public static int col=0;
	public static JTable tableau;
	public static DefaultTableModel Model; 
	boolean sel;

	GestPane p1 =new GestPane();
	ResultSet resultat;
	Connection cn=ConnectionDB.ConnectDB();
	//tatement stm=cn.createStatement();
	  String  title[] = {"ID DM","Nom Patient", "ID Patient", "Nom Medcin",
	    		"Date de consultation","Médicaments","Remarques"};
	
	int nbligne,  columnCount;
	 Object[][] data;
	 boolean RowSelected;
	 Statement st;


	/**
	 * Launch the application.
	 */
	
/***
* la constructeur de cette classe nous aide à faire appel à se classe quand on a besoin.
*/
	public GestionDMmed() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 200,1200, 500);
		p1.setBackground(SystemColor.activeCaptionBorder);
		this.setTitle("Gestion des Dossiers Médicaux ");
		//contentPane = new JPanel();
		p1.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(p1);
		p1.setLayout(null);
		 this.setLocationRelativeTo(null);
		 this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	

			/**
			 * l'appel de la fonction consulter pour remplir le tableau par les information de la table 
			 * plage_horraire de la bese de données.
			 */
		
		consulter();
		
			    
			    tableau.setToolTipText("");
			    tableau.setCellSelectionEnabled(true);
			    tableau.changeSelection(Row, col, true, true);
			   
			    tableau.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						Row = tableau.getSelectedRow();
						 col=tableau.getSelectedColumn();
						System.out.println(Row);
						System.out.println(col);
						sel=tableau.getCellSelectionEnabled();
						
					}
				});
			    
			    JScrollPane scrollPane = new JScrollPane(tableau);
			    scrollPane.setBounds(23, 99, 948, 530);
			    p1.add(scrollPane);
			    
			    JLabel lblConsultationDesDossiers = new JLabel("Consultation des Dossiers M\u00E9dicaux");
			    lblConsultationDesDossiers.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 36));
			    lblConsultationDesDossiers.setBounds(23, 27, 716, 61);
			    p1.add(lblConsultationDesDossiers);
			    
			    
			   
			    
			    JButton btnConsulterLesRemarques = new JButton("Consulter les Remarques ou les médicaments ");
			    btnConsulterLesRemarques.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		
			    			int SelectedId=Integer.valueOf(tableau.
			    					getValueAt(Row, 0).toString());
			    			try {
			    				
			    			
			    			Statement st=cn.createStatement();
			    			String query="select * from `DM` where `ID`="+SelectedId;
			    			resultat=st.executeQuery(query);
			    			if(col==2) {
			    			resultat.first();
			    			String txt= resultat.getString("Remarques");
			    			Remarques  rm=new Remarques(txt);
			    			rm.setVisible(true);
			    			}
			    			else
			    				if (col==3) {
			    				
			    				resultat.first();
				    			String txt1= resultat.getString(col+1);
				    			
				    			Medicaments md=new Medicaments (txt1);
				    			md.setVisible(true);
				    			
			    				
			    			}
			    			}
			    			catch(Exception e1){
			    				
			    			}
			    			 
			    			
			    			
			    			
			    			
			    			
			    		}
			    	
			    });
			    btnConsulterLesRemarques.setBounds(702, 658, 251, 23);
			    p1.add(btnConsulterLesRemarques);
			  }  
	void consulter() {
		Statement statement;
		try {
			statement = cn.createStatement();
		
		Statement st=cn.createStatement();
		 String query="select * from DM";
		
		 

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
			      
			   
		
			    String  title[] = {"ID RDV","Nom Patient","Remarques","Medicaments",
			    		"Date de Consultation","ID Medcin","ID secrétaire"};
			   tableau = new JTable(data, title);
		
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



}
	}


