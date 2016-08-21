package com.yesserp.sessionbean.ga.contrat;


import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Contrat;
import com.yesserp.domain.ga.Embauche;

@Local
public interface GestionContratLocal {

	public void ajouterContrat(Contrat contrat);

	public void supprimerContrat(Contrat contrat);

	public void modifierContrat(Contrat contrat);

	public Contrat trouverParId(Long id);

	public List<Contrat> trouverContratsActifsParEmbauche(Embauche embauche);

	public List<Contrat> trouverHistoriqueContratsParEmbauche(
			Embauche embauche, int n);

	public Long trouverNombreOccurrencesParEmbauche(Embauche embauche);

	public Long trouverNombreOccurrencesActivesParEmbauche(Embauche embauche);

	public List<Contrat> trouverHistoriqueContratsParEmbaucheEtDateMin(
			Embauche embauche, Date min, int n);

	public List<Contrat> trouverPremiersHistoriqueContratsParEmbaucheEtDateMin(
			Embauche embauche, Date min, int n);
	
	public List<Contrat> trouverPremiersHistoriqueContratsParEmbauche(
			Embauche embauche, int n);

	public List<Contrat> trouverHistoriqueContratsParEmbaucheEtDateMax(
			Embauche embauche, Date max, int n);

	public List<Contrat> trouverHistoriqueContratsParEmbaucheEtDateMinMax(
			Embauche embauche, Date min, Date max, int n);
	


	public List<Contrat> findAll();
}
