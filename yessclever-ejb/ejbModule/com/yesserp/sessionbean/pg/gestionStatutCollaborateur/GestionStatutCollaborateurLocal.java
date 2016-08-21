package com.yesserp.sessionbean.pg.gestionStatutCollaborateur;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.StatutCollaborateur;



@Local
public interface GestionStatutCollaborateurLocal {
	
	
	public void ajouterStatutCollaborateur(StatutCollaborateur i);
	public void supprimerStatutCollaborateur(StatutCollaborateur i);
	public void modifierStatutCollaborateur(StatutCollaborateur i);
	public List<StatutCollaborateur> AfficherTousStatutCollaborateur();
	
/*
	
	public List<StatutCollaborateur> trouverParNumStatutCollaborateur(String numStatutCollaborateur);
	public List<StatutCollaborateur> trouverParNom(String nom);
	*/
	

	

}
