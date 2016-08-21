package com.yesserp.sessionbean.pg.gestionTypeContrat;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.TypeContrat;



@Local
public interface GestionTypeContratLocal {
	
	
	public void ajouterTypeContrat(TypeContrat i);
	public void supprimerTypeContrat(TypeContrat i);
	public void modifierTypeContrat(TypeContrat i);
	public List<TypeContrat> AfficherTousTypeContrat();
	
/*
	
	public List<TypeContrat> trouverParNumTypeContrat(String numTypeContrat);
	public List<TypeContrat> trouverParNom(String nom);
	*/
	

	

}
