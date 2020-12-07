package model.poo;

public class Patient  extends Personne {
	
	/**
	 * On ajoute l'attribut CIN qui permet d'identifier chaque Patient 
	 */
    String CIN;
    Medcin Med;
    Secretaire sec;
    
	public Patient(String Nom_Complet, String email, String telephone, String CIN) {
		super(Nom_Complet, email, telephone);
		this.CIN=CIN;
		ID++;
	}
	public Patient(String Nom_Complet, String email, String telephone, String CIN,  Medcin Med, Secretaire sec) {
		super(Nom_Complet, email, telephone);
		this.CIN=CIN;
		this.Med=Med;
		this.sec=sec;
		ID++;
	}

 
	/**
	  * Cette méthode permet de récupérer le CIN  d'un patient crée.
	 * @return numéro de CIN
	 */
	public String  gettCIN() {
			return this.CIN;
	}
/**
 *  cette méthode permet de retourner le medcin d'un patient
 * @return medcin
 */
	public Medcin getMed() {
		   return this.Med;
	   }
	/***
	 * cette  méthode permet de retourner le secrétaire qui gére les rendez-vous  d'un patient
	 * 	 * @return Secretaire
	 */
	public Secretaire getsec() {
		   return this.sec;
	   }
	
	
	
	
	 /** 
	  *  Cette méthode permet de changer le CIN   d'un Patient  crée en
	  *   la donne comme paramétre le nouveau CIN.
	 * @param CIN
	 */
	public void  setCINe(String CIN ) {
			 this.CIN=CIN;
		 }
	/**
	 * cette méthode permet de modifier le medcin d'un patient 
	 * @param Med
	 */
	public void  setMed( Medcin Med) {
	    this.Med=Med;
   }
   
	/**
	 * cette méthode permet de modifier le secrétaire qui gére les RD d'un patient 
	 * @param sec
	 */
 public void  setsec( Secretaire sec) {
	    this.sec=sec;
   }
 
}
