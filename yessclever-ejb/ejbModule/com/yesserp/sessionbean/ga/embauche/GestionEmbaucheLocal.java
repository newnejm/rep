package com.yesserp.sessionbean.ga.embauche;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.Contrat;
import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Salaire;

@Local
public interface GestionEmbaucheLocal {
	public void ajouterEmbauche(Embauche embauche);

	public void supprimerEmbauche(Embauche embauche);

	public void modifierEmbauche(Embauche embauche);

	public Embauche trouverParId(Long id);

	public void ajouterAffectation(Embauche embauche, Affectation affectation);
	public void modifierAffectation(Embauche embauche, Affectation affectation);

	public void ajouterListeAffectations(Embauche embauche,
			List<Affectation> affectations);

	public void ajouterSalaire(Embauche embauche, Salaire salaire);

	public void ajouterContrat(Embauche embauche, Contrat contrat);

	public Embauche trouverEmbaucheActifParIdentite(Identite identite);

	public List<Embauche> trouverHistoriqueEmbaucheParIdentite(
			Identite identite, int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Embauche trouverPrecedentEmbaucheParIdentite(Identite identite,
			Date max);

	public Embauche trouverSuivantEmbaucheParIdentite(Identite identite,
			Date min);

	public Embauche trouverPremierEmbaucheParIdentite(Identite identite);

	public Embauche trouverDernierEmbaucheParIdentite(Identite identite);
	
	public void modifierListeAffectations(Embauche embauche,
			List<Affectation> affectations);

	public void modifierSalaire(Embauche embauche, Salaire salaire);

	public void modifierContrat(Embauche embauche, Contrat contrat);

}
