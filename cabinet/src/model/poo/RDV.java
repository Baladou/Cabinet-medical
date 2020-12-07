package model.poo;

import java.sql.Time;
import java.util.Date;



/**
 * cette classe permet de créer des rendez-vous. 
 * @author Zineb Baladou
 *
 */

public class RDV {
	/***
	 * La classe RDV a 3 attribut : ID qui s'incrémente à chaque fois qu'on crée un rendez-vous,date et heure  qui permettent de  spécifier 
	 * la date et l'heure du rendez-vous.
	 */
  int ID; 
  Date date;
int  Heure;
  Secretaire sec;
  Plage_Horaire PH;
  Patient pat;
  Medcin med;
    /**
     * La constructeur de la classe RDV permet de créer des instances de type RDV en 
     * la donnant comme paramétre la date et l'heure du rendez et la secrétaire 
     * qui a affecté ce rendez-vous
     * @param date
     * @param Heure
     * @param sec
     */
    public RDV(Date date, int Heure,Secretaire sec) {
    	this.date=date;
    	this.Heure=Heure;
    	this.sec=sec;
    	ID++;
    }
    public RDV(Date date, int Heure,Secretaire sec, Plage_Horaire PH) {
    	this.date=date;
    	this.Heure=Heure;
    	this.sec=sec;
    	this.PH=PH;
    	ID++;
    }
    public RDV(Date date, int Heure,Secretaire sec, Plage_Horaire PH,Patient pat,Medcin med) {
    	this.date=date;
    	this.Heure=Heure;
    	this.sec=sec;
    	this.PH=PH;
    	this.pat=pat;
    	this.med=med;///getter setter
    	ID++;
    }
    /***
     * cette méthode permet de retourner la date d'un rendez-vous
     * @return date
     */
    public Date getDate() {
    	return this.date;
    }
    /**
     * cette méthode permet de retourner l'heure du RDV
     * @return
     */
   public int getHeure() {
	   return this.Heure;
   }
   /**
    * cette méthode permet de retourner le secrétaire qui a déclarée le RDV
    * @return secretaire
    */
   public Secretaire getsec() {
	   return this.sec;
   }
   /***
    * cette méthode permet de retourner  le medcin  
    * @return Medcin
    */
   public Medcin getMed() {
	   return this.med;
   }
   /**
    * cette méthode permet de retourner le patient qui a pris ce RDV
    * @return patient 
    */
   public Patient getpat() {
	   return this.pat;
   }
   /***
	  * cette méthode permet de modifier la date  d'un RDV
	  * @param date_Consultation
	  */
   
   public void setDate(Date date) {
	   this.date=date;
   }
   /**
    * cette méthode permet de modifier  l'heure d'un RDV
    * @param Heure
    */
   public void setHeure(int Heure ) {
	   this.Heure=Heure;
   }
   /**
	 * cette méthode permet de modifier le secrétaire qui a déclarée le RDV d'un patient 
	 * @param sec
	 */
   public void  setsec( Secretaire sec) {
	    this.sec=sec;
   }

	 /**
	  * cette méthode permet de modifier le patient qui a pris le RDV
	  * @param pat
	  */
   
   public void  setpat(Patient pat) {
	    this.pat=pat;
  }
   /**
	 * cette méthode permet de modifier le medcin qui va soigner un patient
	 * @param Med
	 */
   public void  setMed( Medcin med) {
	    this.med=med;
  }
   
  
}