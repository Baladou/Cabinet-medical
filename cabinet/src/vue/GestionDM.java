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
    * la classe 
    * @author zineb GestionDM permet à la secrétaire de gérer les dossiers médicaux des patients.
    *
    */
public class GestionDM extends JFrame {
	
	public static GestionDM frame;
	public static int firsttime=0;
	public static int Row=0;
	public static int col=0;
	public static JTable tableau;
	public static DefaultTableModel Model; 
	boolean sel;

	GestPane p1 =new GestPane();
	ResultSet resultat;
	Connection cn=ConnectionDB.ConnectDB();
	
	  String  title[] = {"ID DM","Nom Patient", "ID Patient", "Nom Medcin",
	    		"Date de consultation","Médicaments","Remarques"};
	
	int nbligne,  columnCount;
	 Object[][] data;
	 boolean RowSelected;
	 Statement st;
	 String nom,date,id_Med,id_Sec,Rem,Medi;
	    
     int id;


	

	/**
	 * la constructeur de la classe GestionDM permet d'instancier cette classe dans le cas du besoin.
	 */
	public GestionDM() {
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
		/***
		 * modifier un dossier médical
		 */
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierDM mdm=new ModifierDM(nom,id_Sec,date,Rem,Medi,id_Med,tableau,Row,id);
				mdm.setVisible(true);
			}
		});
		
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(409, 624, 136, 23);
		p1.add(btnNewButton_1);
		/**
		 * ajouter un DM
		 */
		JButton btnNewButton_2 = new JButton("Ajouter");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterDM dm=new AjouterDM();
				dm.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(167, 624, 142, 23);
		p1.add(btnNewButton_2);
		
		consulter();
		
			    
			    tableau.setToolTipText("");
			    tableau.getRowSelectionAllowed();
			    tableau.changeSelection(Row, col, true, true);
			    
			  
			    tableau.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						Row = tableau.getSelectedRow();
						 col=tableau.getSelectedColumn();
						
						sel=tableau.getRowSelectionAllowed();
						
					}
				});
			    //Nous ajoutons notre tableau à notre contentPane dans un scroll
			    //Sinon les titres des colonnes ne s'afficheront pas !
			    JScrollPane scrollPane = new JScrollPane(tableau);
			    scrollPane.setBounds(23, 99, 948, 483);
			    p1.add(scrollPane);
			    
			    JLabel lblConsultationDesDossiers = new JLabel("Gestion des Dossiers M\u00E9dicaux");
			    lblConsultationDesDossiers.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 36));
			    lblConsultationDesDossiers.setBounds(23, 27, 716, 61);
			    p1.add(lblConsultationDesDossiers);
			    
			    
			    /**
			     * actualiser la table après une modification
			     */
			    JButton btnActualiser = new JButton("Actualiser");
			    btnActualiser.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    	
				    		firsttime++;
				    		consulter();
						    if(firsttime!=0) {
						    	 //frame.dispose();
								  frame = new GestionDM();
								  frame.setVisible(true);
						    }
				    		frame.update(getGraphics());
			    		
			    	}
			    });
			    btnActualiser.setBounds(981, 102, 167, 23);
			    p1.add(btnActualiser);
			    /***
			     * afficher Remarques ou les médicaments dans une autre frame affin de faciliter la lecture.
			     */
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
			    btnConsulterLesRemarques.setBounds(981, 151, 167, 23);
			    p1.add(btnConsulterLesRemarques);
			    /****
			     * récupérer les information de la ligne sélectionnée afin de les modifiées.
			     */
			    tableau.addMouseListener(new MouseAdapter(){
			        
			        @Override
			        public void mouseClicked(MouseEvent e){
			            
			           
			        	
			        	id=Integer.valueOf(tableau.getValueAt(Row, 0).toString());
			            nom=tableau.getValueAt(Row, 1).toString();
			            Rem=tableau.getValueAt(Row, 2).toString();
			            Medi=tableau.getValueAt(Row, 3).toString();
			            date=tableau.getValueAt(Row, 4).toString();
			            id_Med=tableau.getValueAt(Row, 5).toString();
			            id_Sec=tableau.getValueAt(Row, 5).toString();
			            
			            		}
			        });
			  } 
	/**
	 * fonction de remplissage de la table.
	 */
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
			 
		 for (int i=1;i<=columnCount;i++) {
				 
		    data[j-1][i-1]=resultat.getObject(i).toString();}
			  j++;    
			      
			   
		
			    String  title[] = {"ID  DM","Nom Patient","Remarques","Medicaments",
			    		"Date de Consultation","ID Medcin","ID secrétaire"};
			   tableau = new JTable(data, title);
		
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



}
	}


