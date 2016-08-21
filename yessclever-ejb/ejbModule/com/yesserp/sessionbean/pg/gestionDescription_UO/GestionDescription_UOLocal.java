package com.yesserp.sessionbean.pg.gestionDescription_UO;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Description_UO;



@Local
public interface GestionDescription_UOLocal {
	

	public void ajouterDescription_UO(Description_UO i);
	public void supprimerDescription_UO(Description_UO i);
	public void modifierDescription_UO(Description_UO i);
	public List<Description_UO> AfficherTousDescription_UO();
	

	/*
	public List<Unite_organisationnelle> trouverParNumUnite_organisationnelle(String numUnite_organisationnelle);
	public List<Unite_organisationnelle> trouverParNom(String nom);
	
	
	*/
	

}
