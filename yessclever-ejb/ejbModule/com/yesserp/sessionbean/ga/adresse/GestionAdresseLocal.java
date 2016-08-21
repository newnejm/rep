package com.yesserp.sessionbean.ga.adresse;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Adresse;
import com.yesserp.domain.ga.Identite;

@Local
public interface GestionAdresseLocal {
	public void ajouterAdresse(Adresse adresse);

	public void supprimerAdresse(Adresse adresse);

	public void modifierAdresse(Adresse adresse);

	public Adresse trouverParId(Long id);

	public List<Adresse> trouverAdressesParIdentite(Identite identite);

	public Adresse trouverAdressePrincipaleParIdentite(Identite identite);

	public List<Adresse> trouverHistoriqueAdressesParIdentite(
			Identite identite, int n);

	public List<Adresse> trouverHistoriqueAdressesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<Adresse> trouverPremiersHistoriqueAdressesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<Adresse> trouverHistoriqueAdressesParIdentiteEtDateMax(
			Identite identite, Date max, int n);

	public List<Adresse> trouverHistoriqueAdressesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Long trouverNombreOccurrencesActivesParIdentite(Identite identite);

	public List<Adresse> trouverPremiersHistoriqueAdressesParIdentite(
			Identite identite, int n);
}
