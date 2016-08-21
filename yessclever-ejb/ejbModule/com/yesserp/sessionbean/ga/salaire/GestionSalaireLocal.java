package com.yesserp.sessionbean.ga.salaire;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Salaire;

@Local
public interface GestionSalaireLocal {

	public void ajouterSalaire(Salaire salaire);

	public void supprimerSalaire(Salaire salaire);

	public void modifierSalaire(Salaire salaire);

	public Salaire trouverParId(Long id);

	public Salaire trouverSalaireParEmbauche(Embauche embauche);

	public List<Salaire> trouverHistoriqueSalairesParEmbauche(
			Embauche embauche, int n);

	public Long trouverNombreOccurrencesParEmbauche(Embauche embauche);

	public Salaire trouverPrecedentSalaireParEmbauche(Embauche embauche,
			Date max);

	public Salaire trouverSuivantSalaireParEmbauche(Embauche embauche, Date min);
	
	public Salaire trouverPremierSalaireParEmbauche(Embauche embauche);

	public Salaire trouverDernierSalaireParEmbauche(Embauche embauche);
}
