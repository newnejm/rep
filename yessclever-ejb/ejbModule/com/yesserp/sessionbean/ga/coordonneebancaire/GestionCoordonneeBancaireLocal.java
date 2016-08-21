package com.yesserp.sessionbean.ga.coordonneebancaire;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.CoordonneeBancaire;
import com.yesserp.domain.ga.Identite;

@Local
public interface GestionCoordonneeBancaireLocal {

	public void ajouterCoordonneeBancaire(CoordonneeBancaire coordonneeBancaire);

	public void supprimerCoordonneeBancaire(
			CoordonneeBancaire coordonneeBancaire);

	public void modifierCoordonneeBancaire(CoordonneeBancaire coordonneeBancaire);

	public CoordonneeBancaire trouverParId(Long id);

	public CoordonneeBancaire trouverCoordonneeBancaireActiveParIdentite(
			Identite identite);

	public List<CoordonneeBancaire> trouverHistoriqueCoordonneeBancairesParIdentite(
			Identite identite, int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public CoordonneeBancaire trouverPrecedentCoordonneeBancaireParIdentite(
			Identite identite, Date max);

	public CoordonneeBancaire trouverSuivantCoordonneeBancaireParIdentite(
			Identite identite, Date min);
	
	public CoordonneeBancaire trouverDerniereCoordonneeBancaireParIdentite(Identite identite);
	
	public CoordonneeBancaire trouverPremiereCoordonneeBancaireParIdentite(Identite identite);
}
