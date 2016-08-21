package com.yesserp.sessionbean.ga.naissance;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Naissance;

@Local
public interface GestionNaissanceLocal {
	
	public void ajouterNaissance(Naissance naissance);

	public void supprimerNaissance(Naissance naissance);

	public void modifierNaissance(Naissance naissance);

	public Naissance trouverParId(Long id);

	public Naissance trouverParIdentite(Identite identite);
}
