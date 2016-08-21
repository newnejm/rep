package com.yesserp.sessionbean.ga.statut;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Statut;

@Local
public interface GestionStatutLocal {

	public void ajouterStatut(Statut statut);

	public void supprimerStatut(Statut statut);

	public void modifierStatut(Statut statut);

	public Statut trouverParId(Long id);

	public Statut trouverStatutParIdentite(Identite identite);

	public List<Statut> trouverHistoriqueStatutsParIdentite(Identite identite,
			int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Statut trouverPrecedentStatutParIdentite(Identite identite, Date max);

	public Statut trouverSuivantStatutParIdentite(Identite identite, Date min);

	public Statut trouverPremierStatutParIdentite(Identite identite);

	public List<Statut> trouverPremiersHStatutParIdentite(
			Identite identite, int n);

	public List<Statut> trouverPrecedentsHStatutParIdentiteEtDateMax(
			Identite identite, Date max, int n);

	public List<Statut> trouverSuivantsHStatutParIdentiteEtDateMin(
			Identite identite, Date min, int n);
}
