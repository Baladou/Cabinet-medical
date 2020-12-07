package Controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import model.poo.RDV;

import vue.GestPane;


/** La classe Action nous permet de 
 * @author hp
 *
 */
public class Action {
	
	GestPane p1 =new GestPane();
	static int nbligne;
	static int columnCount;
	 Object[][] data;
	 boolean RowSelected;
	
	
	
	static ResultSet resultat;
	Statement st;
	static Connection cn=ConnectionDB.ConnectDB();
	/**
	 * cette méthode permet de retourner le max des identifiant existants dans une table afin de données 
	 * un identifiant une ligne ajoutée.
	 * @param nomtable
	 * @return
	 */
	
	public static int update_id(String nomtable) {
		try {
			Statement statement=cn.createStatement();
			String qy="select max(ID) as maxi  from "+nomtable;
			resultat=statement.executeQuery(qy);
			resultat.first();
			int id=resultat.getInt("maxi")+1;
			return id ;
		    //System.out.println(resultat.getInt("maxi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
		
	}
	}

