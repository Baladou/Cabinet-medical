package model.poo;

import java.util.Date;
/***
 * la classe Dossier_Medical permet de créer des dosssier médicaux qui contient des 
 * information sur l'état d'un patient du cabinet médical.
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
	 * la constructeur du classe Dossier_Medical permet de créer des instances de la Classe Dossier_Medical	
	 * en lui donnant comme paramétre
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
	 * la méthode getMed permet de nous retourner un objet de type medcin qui determine le medcin qui 
	 * fait la consultaion médical d'un patient. 
	 * @return medcin
	 */
	public Medcin getMed() {
		   return this.Med;
	   }
	
	/***
	 * la méthode getsec permet de nous retourner un objet de type Secretaire  qui determine la  secrétaire qui
	 * gére  le dossier médical d'un patient.
	 *  
	 * @return secretaire
	 */
	 public Secretaire getsec() {
		   return this.sec;
	   }
	 /***
	  * la méthode getpat permet de retourner un objet de type Patient
	  * @return patient
	  */
	 public Patient getpat() {
		   return this.pat;
	   }
	 /***
	     * cette méthode permet de retourner la date de consultation d'un patient
	     * @return date de consultation
	     */
	 public Date getdate_Consultation() {
	    	return this.date_Consultation;
	    }
	 /**
	  * cette méthode permet de retourner les médicaments données à un patient
	  * @return Medicaments
	  */
	 
	   public String getMedicaments() {
		   return this.Medicaments;
	   }
	   /**
		  * cette méthode permet de retourner les Remarques sur la situation un patient
		  * @return Remarques
		  */
	   
	   public String getRemarques() {
		   return this.Remarques;
	   }
	
	//setters:
	
	  /**
		 * cette méthode permet de modifier le medcin d'un patient 
		 * @param Med
		 */
	
	 public void  setMed( Medcin Med) {
		    this.Med=Med;
	   }
	  
	 /**
		 * cette méthode permet de modifier le secrétaire qui gére les DM d'un patient 
		 * @param sec
		 */
	 public void  setsec( Secretaire sec) {
		    this.sec=sec;
	   }
	 
	 /**
	  * cette méthode permet de modifier le patient à qui appartient le DM
	  * @param pat
	  */
	 public void  setpat(Patient pat) {
		    this.pat=pat;
	   }
	 /***
	  * cette méthode permet de modifier la date de consultation d'un patient
	  * @param date_Consultation
	  */
	 public void setDate(Date date_Consultation) {
		   this.date_Consultation=date_Consultation;
	   }
	 /***
	  * cette méthode permet de modifier les Medicaments
	  * @param Medicaments
	  */
	   public void setMedicaments(String Medicaments) {
		   this.Medicaments=Medicaments;
	   }
	   /***
		  * cette méthode permet de modifier Remarques
		  * @param Remarques
		  */
	   public void setRemarques(String Remarques) {
		   this.Remarques=Remarques;
	   }
}
