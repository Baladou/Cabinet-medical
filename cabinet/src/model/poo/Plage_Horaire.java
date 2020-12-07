package model.poo;

import java.sql.Time;
import java.util.Date;
   /**
    * cette classe permet de définir les plages horaires des medcins
    * @author hp
    *
    */
public class Plage_Horaire {

	static int ID;
	Date date;
	Time heure_matin,heure_soir;
	Medcin Med;
	/**
	 * la constructeur qui permet de créer des plages horaires
	 * @param date
	 * @param heure_matin
	 * @param heure_soir
	 */
	public Plage_Horaire(Date date, Time heure_matin, Time heure_soir) {
		this.date=date;
		this.heure_matin=heure_matin;
		this.heure_soir=heure_soir;
	
		
	}
	public Plage_Horaire(Date date, Time heure_matin, Time heure_soir,Medcin Med) {
		this.date=date;
		this.heure_matin=heure_matin;
		this.heure_soir=heure_soir;
		this.Med=Med;
		
	}
	
	public Date getDate() {
    	return this.date;
    }
	public Time getheure_matin() {
		   return this.heure_matin;
	   }
	public Time getheure_soir() {
		   return this.heure_soir;
	   }
	public Medcin getMed() {
		   return this.Med;
	   }
	
	 public void setDate(Date date) {
		   this.date=date;
	   }
	   public void setheure_soir(Time heure_soir ) {
		   this.heure_soir=heure_soir;
	   }
	   public void setheure_matin(Time heure_matin ) {
		   this.heure_matin=heure_matin;
	   }
	   public void  setMed( Medcin Med) {
		    this.Med=Med;
	   }
}
