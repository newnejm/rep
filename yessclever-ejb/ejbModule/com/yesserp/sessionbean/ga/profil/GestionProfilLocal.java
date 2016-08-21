package com.yesserp.sessionbean.ga.profil;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Profil;

@Local
public interface GestionProfilLocal {

	public void ajouterProfil(Profil profil);

	public void supprimerProfil(Profil profil);

	public void modifierProfil(Profil profil);

	public Profil trouverParId(Long id);

	public Profil trouverProfilParIdentite(Identite identite);

	public List<Profil> trouverHistoriqueProfilsParIdentite(Identite identite,
			int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Profil trouverPrecedentProfilParIdentite(Identite identite, Date max);

	public Profil trouverSuivantProfilParIdentite(Identite identite, Date min);

}
