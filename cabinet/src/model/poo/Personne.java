package model.poo;

/**
 * La classe Personne permet de définr toutes les classes dont on a besoin (Medcine,Patient,Secrétaire).
 * @author Zineb_baladou
 *
 */
public class Personne {
	
	/**
	 * La classe Personne a 3 attributs qui sont :Nom_Complet ,email, telephone.
	 */
	  static int ID;
	String Nom_Complet="",email="", telephone="";
	
	/**
	 * 
	 * La constructeur de la classe Personne  permet de créer des instances de type Personne  en prenant 4 paramétre : 
	 * ID, Nom_Complet ,email, telephone.
	 * @param Nom_Complet
	 * @param email
	 * @param telephone
	 */
	public  Personne (String Nom_Complet , String email, String telephone ){
		this.Nom_Complet=Nom_Complet;
		this.email=email;
		this.telephone=telephone;
     ID++;
		
	}
	
	 /**
	  * Cette méthode permet de récupérer le Nom Complet d'une Personne créee.
	 * @return  Nom_Complet
	 */
	public String  getNom_Complet() {
		return this.Nom_Complet;
	 }
	 
	
	 /**
	  * Cette méthode permet de récupérer l'email d'une Personne créee.
	 * @return email
	 */
	public String  getemail() {
			return this.email;
		 }
	 
	 /**
	  * Cette méthode permet de récupérer le numéro de téléphone  d'une Personne créee.
	 * @return telephone
	 */
	public String  gettelephone() {
			return this.telephone;
		 }
	
	
	
	 /**
	  * Cette méthode permet de changer le Nom Complet   d'une Personne créee en la donne comme paramétre le nouveau nom.
	 * @param Nom_Complet
	 */
	public void setNom_Complet(String Nom_Complet) {
			 this.Nom_Complet=Nom_Complet;
	 }
	 
	 /**
	  *  Cette méthode permet de changer l'email   d'une Personne créee en la donne comme paramétre le nouveau email
	 * @param email
	 */
	public void setemail(String email) {
			 this.email=email;
		 }
	 
	 /** 
	  *  Cette méthode permet de changer le numéro de téléphone  d'une Personne créee en
	  *   la donne comme paramétre le nouveau numéro de téléphone.
	 * @param telephone
	 */
	public void  settelephone(String telephone ) {
			 this.telephone=telephone;
		 }
	

}
