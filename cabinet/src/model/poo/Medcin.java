package model.poo;

/**
 * Cette classe est une classe qui h�rite de la classe personne, elle permet de cr�er des medcins
 * @author Zineb_baladou
 *
 */
public class Medcin  extends Personne {
	/**
	 * On ajoute l'attribut qui determine la sp�cialit� du Medcin.
	 */
     String Sp�cialit�;
     
	/**
	 * Cette constructeur parmet de cr�er des instances de type Medcin en la donnant comme param�tre: Nom_Complet,  
	 * email, telephone,Sp�cialit�.
	 * @param Nom_Complet
	 * @param email
	 * @param telephone
	 * @param Sp�cialit�
	 */
	public Medcin(int ID,String Nom_Complet, String email, String telephone, String Sp�cialit�) {
		super(Nom_Complet, email, telephone);
		this.Sp�cialit�=Sp�cialit�;
		
	}
	
	
	/**
	 * Cette m�thode permet de r�cup�rer la Sp�cialit�   d'un Medcin  cr�e.
	 * @return Sp�cialit�
	 */
	public String  getSp�cialit�() {
		return this.Sp�cialit�;
	 }

	
	/**
	 * Cette m�thode permet de changer Sp�cialit�   d'un Medcin cr�e en
	  *   la donne comme param�tre la nouvelle Sp�cialit�.
	 * @param Sp�cialit�
	 */
	public void setSp�cialit�(String Sp�cialit�) {
		 this.Sp�cialit�=Sp�cialit�;
	 }
	}


