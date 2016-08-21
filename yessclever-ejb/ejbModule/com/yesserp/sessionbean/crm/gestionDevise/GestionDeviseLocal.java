package com.yesserp.sessionbean.crm.gestionDevise;
import java.util.List;

import com.yesserp.domain.crm.Devise;
public interface GestionDeviseLocal {

	
	public void ajouterDevise (Devise Devise);
	public void supprimerDevise(Devise Devise);
	public void modifierDevise(Devise Devise);
	public List<Devise> AfficherTousDevise();
	public Devise afficherDeviseParId(Long id);

	public Devise afficherDeviseParNom(String nom);
}
