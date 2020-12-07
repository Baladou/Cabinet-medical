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
	  * Cette m�thode permet de r�cup�rer le CIN  d'un patient cr�e.
	 * @return num�ro de CIN
	 */
	public String  gettCIN() {
			return this.CIN;
	}
/**
 *  cette m�thode permet de retourner le medcin d'un patient
 * @return medcin
 */
	public Medcin getMed() {
		   return this.Med;
	   }
	/***
	 * cette  m�thode permet de retourner le secr�taire qui g�re les rendez-vous  d'un patient
	 * 	 * @return Secretaire
	 */
	public Secretaire getsec() {
		   return this.sec;
	   }
	
	
	
	
	 /** 
	  *  Cette m�thode permet de changer le CIN   d'un Patient  cr�e en
	  *   la donne comme param�tre le nouveau CIN.
	 * @param CIN
	 */
	public void  setCINe(String CIN ) {
			 this.CIN=CIN;
		 }
	/**
	 * cette m�thode permet de modifier le medcin d'un patient 
	 * @param Med
	 */
	public void  setMed( Medcin Med) {
	    this.Med=Med;
   }
   
	/**
	 * cette m�thode permet de modifier le secr�taire qui g�re les RD d'un patient 
	 * @param sec
	 */
 public void  setsec( Secretaire sec) {
	    this.sec=sec;
   }
 
}
