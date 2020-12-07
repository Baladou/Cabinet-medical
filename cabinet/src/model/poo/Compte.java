package model.poo;


/**
 * la classe  Compte nous permet de créer des compte.
 * @author hp
 *
 */


/**
 * @author hp
 *
 */

public class Compte {
	/***
	 * la classe Compte a 4 attributs  le Login , le Nom_Complet, le type et le Mot_de_passe.
	 */

	String Login,Nom_Complet,type,Mot_de_passe;
	
	/***
	 * le constructeur de la classe Compte permet de créer des objet de types compte en lui affectant un login,
	 * un nom,un type et un mot de passe.
	 * @param Login
	 * @param Nom_Complet
	 * @param type
	 * @param Mot_de_passe
	 */
	
	public Compte (String Login,String Nom_Complet, String type, String Mot_de_passe) {
		this.Login= Login;
		this.Mot_de_passe=Mot_de_passe;
		this.Nom_Complet=Nom_Complet;
		this.type=type;
	}
	/***
	 * la fonction getLogin permet de retourner le login d'un compte
	 * @return Login
	 */
	public String getLogin() {
		return  this.Login;
	}
	/**
	 * la fonction getMot_de_passe permet de retourner le mot de passe
	 * @return Mot_de_passe
	 */
	public String getMot_de_passe() {
		return  this.Mot_de_passe;
	}
	/**
	 * la fonction getNom_Complet permet de retourner le nom de l'utilisateur du compte
	 * @return Nom complet
	 */
	public String getNom_Complet() {
		return  this.Nom_Complet;
	}
	/***
	 * la fonction getType permet de retourner le type de l'utilisateur.
	 * @return Type
	 */
	public String gettype() {
		return  this.type;
	}
	/****
	 * 
	 * la fonction setLogin permet de modifier le login d'un compte exustant,
	 *  en la donne comme paramétre le nouveau nom.
	 */
	public void  setLogin(String Login) {
		  this.Login=Login ;
	}
	/****
	 * 
	 * la fonction setMot_de_passe( pert de modifier le login d'un compte existant, en la donne comme paramétre 
	 * le nouveau mot de passe.
	 */
	public void setMot_de_passe(String Mot_de_passe) {
	this.Mot_de_passe=Mot_de_passe;
	}

/****
 * 
 * la fonction setNom_Complet permet de modifier le nom d'un utilisateur de 
 * compte existant, en la donne comme paramétre 
 * le nouveau nom .
 */
	
	
	public void  setNom_Complet(String Nom_Complet ) {
		this.Nom_Complet=Nom_Complet;
	}

/****
 * 
 * la fonction setType( permet de modifier le type d'un compte existant, en la donne comme paramétre 
 * le nouveau type.
 */
	public void  settype() {
		 this.type=type;
	}
	
	
	
	
	
}
