package model.poo;

import java.util.Date;
/***
 * la classe Dossier_Medical permet de cr�er des dosssier m�dicaux qui contient des 
 * information sur l'�tat d'un patient du cabinet m�dical.
 * @author hp
 *
 */

public class Dossier_Medical  {
	

	static int ID;
	Patient pat;
	Medcin Med;
	Secretaire sec;
	String Medicaments,Remarques;
	Date date_Consultation;
	/***
	 * la constructeur du classe Dossier_Medical permet de cr�er des instances de la Classe Dossier_Medical	
	 * en lui donnant comme param�tre
	 * @param pat
	 * @param Med
	 * @param sec
	 * @param Medicaments
	 * @param Remarques
	 * @param date_Consultation
	 */
	
	public Dossier_Medical (Patient pat, Medcin Med, Secretaire sec, String Medicaments,String Remarques, Date date_Consultation  ) {
		this.pat=pat;
		this.sec=sec;
		this.Med=Med;
		this.Medicaments=Medicaments;
		this.Remarques=Remarques;
		this.date_Consultation=date_Consultation;
	}
	
	/***
	 * la m�thode getMed permet de nous retourner un objet de type medcin qui determine le medcin qui 
	 * fait la consultaion m�dical d'un patient. 
	 * @return medcin
	 */
	public Medcin getMed() {
		   return this.Med;
	   }
	
	/***
	 * la m�thode getsec permet de nous retourner un objet de type Secretaire  qui determine la  secr�taire qui
	 * g�re  le dossier m�dical d'un patient.
	 *  
	 * @return secretaire
	 */
	 public Secretaire getsec() {
		   return this.sec;
	   }
	 /***
	  * la m�thode getpat permet de retourner un objet de type Patient
	  * @return patient
	  */
	 public Patient getpat() {
		   return this.pat;
	   }
	 /***
	     * cette m�thode permet de retourner la date de consultation d'un patient
	     * @return date de consultation
	     */
	 public Date getdate_Consultation() {
	    	return this.date_Consultation;
	    }
	 /**
	  * cette m�thode permet de retourner les m�dicaments donn�es � un patient
	  * @return Medicaments
	  */
	 
	   public String getMedicaments() {
		   return this.Medicaments;
	   }
	   /**
		  * cette m�thode permet de retourner les Remarques sur la situation un patient
		  * @return Remarques
		  */
	   
	   public String getRemarques() {
		   return this.Remarques;
	   }
	
	//setters:
	
	  /**
		 * cette m�thode permet de modifier le medcin d'un patient 
		 * @param Med
		 */
	
	 public void  setMed( Medcin Med) {
		    this.Med=Med;
	   }
	  
	 /**
		 * cette m�thode permet de modifier le secr�taire qui g�re les DM d'un patient 
		 * @param sec
		 */
	 public void  setsec( Secretaire sec) {
		    this.sec=sec;
	   }
	 
	 /**
	  * cette m�thode permet de modifier le patient � qui appartient le DM
	  * @param pat
	  */
	 public void  setpat(Patient pat) {
		    this.pat=pat;
	   }
	 /***
	  * cette m�thode permet de modifier la date de consultation d'un patient
	  * @param date_Consultation
	  */
	 public void setDate(Date date_Consultation) {
		   this.date_Consultation=date_Consultation;
	   }
	 /***
	  * cette m�thode permet de modifier les Medicaments
	  * @param Medicaments
	  */
	   public void setMedicaments(String Medicaments) {
		   this.Medicaments=Medicaments;
	   }
	   /***
		  * cette m�thode permet de modifier Remarques
		  * @param Remarques
		  */
	   public void setRemarques(String Remarques) {
		   this.Remarques=Remarques;
	   }
}
