package model.poo;

/**
 * La classe Personne permet de d�finr toutes les classes dont on a besoin (Medcine,Patient,Secr�taire).
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
	 * La constructeur de la classe Personne  permet de cr�er des instances de type Personne  en prenant 4 param�tre : 
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
	  * Cette m�thode permet de r�cup�rer le Nom Complet d'une Personne cr�ee.
	 * @return  Nom_Complet
	 */
	public String  getNom_Complet() {
		return this.Nom_Complet;
	 }
	 
	
	 /**
	  * Cette m�thode permet de r�cup�rer l'email d'une Personne cr�ee.
	 * @return email
	 */
	public String  getemail() {
			return this.email;
		 }
	 
	 /**
	  * Cette m�thode permet de r�cup�rer le num�ro de t�l�phone  d'une Personne cr�ee.
	 * @return telephone
	 */
	public String  gettelephone() {
			return this.telephone;
		 }
	
	
	
	 /**
	  * Cette m�thode permet de changer le Nom Complet   d'une Personne cr�ee en la donne comme param�tre le nouveau nom.
	 * @param Nom_Complet
	 */
	public void setNom_Complet(String Nom_Complet) {
			 this.Nom_Complet=Nom_Complet;
	 }
	 
	 /**
	  *  Cette m�thode permet de changer l'email   d'une Personne cr�ee en la donne comme param�tre le nouveau email
	 * @param email
	 */
	public void setemail(String email) {
			 this.email=email;
		 }
	 
	 /** 
	  *  Cette m�thode permet de changer le num�ro de t�l�phone  d'une Personne cr�ee en
	  *   la donne comme param�tre le nouveau num�ro de t�l�phone.
	 * @param telephone
	 */
	public void  settelephone(String telephone ) {
			 this.telephone=telephone;
		 }
	

}
