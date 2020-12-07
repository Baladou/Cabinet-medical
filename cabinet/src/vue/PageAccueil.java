package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ConnectionDB;
import model.poo.Compte;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.JPasswordField;
/***
 * cette classe permet de céer la page d'accueil qui permet à l'utilisateur de 
 * s'authentifier et d'accéder à son compte.
 * @author zineb baladou
 *
 */
public class PageAccueil extends JFrame {

	/**
	 * on fait appel à la classe photo qui permet de créer un JPanel avec le photo de la page d'acceuil.
	 */
	Photo phPane=new Photo();
	/***
	 * on utilise trois Array list qui permet de stocker les données de la table Compte et
	 *  vérifier le nom d'utlisateur et son mot de passe.
	 */
	
	 static ArrayList passl=new ArrayList<String>();
	    static ArrayList loginl=new ArrayList<String>();
	    static ArrayList typel=new ArrayList<String>();
	   
	    static Connection connection;
	    JOptionPane jop1, jop2, jop3;
	
	private JTextField user;
	private JPasswordField password;
	private JTextField textField;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageAccueil frame = new PageAccueil();
					frame.setVisible(true);
					
					connection=ConnectionDB.ConnectDB();
					Statement statement=connection.createStatement();
					ResultSet resultat=statement.executeQuery("select * from COMPTE ");
					/**
					 * on parcour la table compte et on récupére les données dont on a besoin.
					 */
					while(resultat.next()) {
						String pass=resultat.getString("password"); passl.add(pass);
						String login=resultat.getString("logIN"); loginl.add(login);
						String type=resultat.getString("type"); typel.add(type);
						
					}
					}
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				
				
		});
	}
	
	/***
	 * cette méthode permet de vérifier les données insérées par 
	 * l'utlisateur et lui affiché la page qui le convient
	 */
	public void connect() {
		for (Object s : loginl) {
			if (s.equals(user.getText())) {
				int i=loginl.indexOf(s);
				
				for(Object p : passl) { 
					
					if(p.equals(password.getText()) && passl.indexOf(p)==i ) {
						
						/*
						 * vérification du type de l'utilisateur
						 */
							if(typel.get(i).equals("secrétaire")) {
								//System.out.print("y");
								SecretaireInterface s1=new SecretaireInterface();
								s1.setVisible(true);
								
						}
							
							if(typel.get(i).equals("Medcin")) {
								System.out.print("ok");
								InterfMédcin m=new InterfMédcin();
								m.setVisible(true);
							}
						
							
					
							
							
					}
					
					
				}
			}
			
		}
		
	}
	
	

	/**
	 * Create the frame.
	 */
	
	
	
	public PageAccueil() {
		setType(Type.POPUP);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 553, 328);
		//contentPane = new JPanel();
		phPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(phPane);
		phPane.setLayout(null);
		 this.setLocationRelativeTo(null);
		 /**
		  * les élement du frame : les labels, les textes et les boutons.
		  */
	
		JLabel Prénomlabel = new JLabel("Nom Utilisateur:");
		Prénomlabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		Prénomlabel.setBounds(214, 94, 138, 31);
		phPane.add(Prénomlabel);
		
		 user = new JTextField();
		 user.grabFocus();
		user.setBounds(352, 100, 155, 20);
		phPane.add(user);
		user.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(352, 131, 155, 20);
		phPane.add(password);
				
			
		
		
		JLabel lblMotDePasse = new JLabel("Mot  de Passe :");
		lblMotDePasse.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblMotDePasse.setBounds(214, 131, 102, 31);
		phPane.add(lblMotDePasse);
		
		JButton btnSeConnecter = new JButton("Se Connecter");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Compte c1=new Compte(user.getText(),password.getText());
				connect();
				//ana();
			}
		});
		
		btnSeConnecter.setForeground(Color.BLACK);
		btnSeConnecter.setBackground(new Color(127, 255, 212));
		btnSeConnecter.setBounds(298, 234, 113, 23);
		phPane.add(btnSeConnecter);
		
		
		
		JLabel lblNewLabel = new JLabel("Bienvenue \u00E0 AGCM\r\n");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setBounds(226, 11, 301, 47);
		phPane.add(lblNewLabel);
		
		
		

		
			
			
		}
	
	}
	
