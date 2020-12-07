package model.poo;

/**
 * Cette classe est une classe qui hérite de la classe personne, elle permet de créer des medcins
 * @author Zineb_baladou
 *
 */
public class Medcin  extends Personne {
	/**
	 * On ajoute l'attribut qui determine la spécialité du Medcin.
	 */
     String Spécialité;
     
	/**
	 * Cette constructeur parmet de créer des instances de type Medcin en la donnant comme paramétre: Nom_Complet,  
	 * email, telephone,Spécialité.
	 * @param Nom_Complet
	 * @param email
	 * @param telephone
	 * @param Spécialité
	 */
	public Medcin(int ID,String Nom_Complet, String email, String telephone, String Spécialité) {
		super(Nom_Complet, email, telephone);
		this.Spécialité=Spécialité;
		
	}
	
	
	/**
	 * Cette méthode permet de récupérer la Spécialité   d'un Medcin  crée.
	 * @return Spécialité
	 */
	public String  getSpécialité() {
		return this.Spécialité;
	 }

	
	/**
	 * Cette méthode permet de changer Spécialité   d'un Medcin crée en
	  *   la donne comme paramétre la nouvelle Spécialité.
	 * @param Spécialité
	 */
	public void setSpécialité(String Spécialité) {
		 this.Spécialité=Spécialité;
	 }
	}


