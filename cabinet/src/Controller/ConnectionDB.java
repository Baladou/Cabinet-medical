package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



/**
 *  la classe connetionDB nous permet de connecter à notre base de données  
 * @author Zineb baladou 
 *
 */
public class ConnectionDB {
	/***
	 * la fonction  ConnectDB permet de nous connecter à la base de données en retournat l'objet de la connexion
	 * @return Connection
	 */
	
     
	
		 public static  Connection ConnectDB() {
			 try {
				
					 Class.forName("com.mysql.jdbc.Driver");
						
					 String url="jdbc:mysql://localhost/cabinet medical?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
						String Username="root";
						String Password= "";
						
						Connection connection=DriverManager.getConnection(url,Username,Password);
						return connection;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				  
			 
			catch(SQLException e) {
				 JOptionPane.showMessageDialog(null,e);
				 
				 return null;
			 }
			

	
		
		
		
	}}