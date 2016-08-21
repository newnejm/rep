package com.yesserp.sessionbean.pg.gestionDescription_poste;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Description_poste;



@Local
public interface GestionDescription_posteLocal {
	
	
	public void ajouterDescription_poste(Description_poste i);
	public void supprimerDescription_poste(Description_poste i);
	public void modifierDescription_poste(Description_poste i);
	public List<Description_poste> AfficherTousDescription_poste();
	
/*
	
	public List<Description_poste> trouverParNumDescription_poste(String numDescription_poste);
	public List<Description_poste> trouverParNom(String nom);
	*/
	

	

}
