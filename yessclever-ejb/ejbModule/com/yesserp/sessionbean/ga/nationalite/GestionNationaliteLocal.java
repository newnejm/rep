package com.yesserp.sessionbean.ga.nationalite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Nationalite;

@Local
public interface GestionNationaliteLocal {

	public void ajouterNationalite(Nationalite nationalite);

	public void supprimerNationalite(Nationalite nationalite);

	public void modifierNationalite(Nationalite nationalite);

	public Nationalite trouverParId(Long id);

	public Nationalite trouverNationalitePrincipaleParIdentite(Identite identite);
	
	public List<Nationalite> trouverNationalitesActivesParIdentite(Identite identite);

	public List<Nationalite> trouverHistoriqueNationalitesParIdentite(
			Identite identite, int n);
	
	public List<Nationalite> trouverHistoriqueNationalitesParIdentiteEtDateMin(Identite identite,Date min, int n);
	
	public List<Nationalite> trouverPremiersHistoriqueNationalitesParIdentiteEtDateMin(Identite identite,Date min, int n);
	
	public List<Nationalite> trouverHistoriqueNationalitesParIdentiteEtDateMax(Identite identite,Date max, int n);
	
	public List<Nationalite> trouverHistoriqueNationalitesParIdentiteEtDateMinMax(Identite identite,Date min, Date max, int n);
	
	public Long trouverNombreOccurrencesParIdentite(Identite identite);
	
	public Long trouverNombreOccurrencesActivesParIdentite(Identite identite);

	public List<Nationalite> trouverPremiersHistoriqueNationalitesParIdentite(
			Identite identite, int n);
	public List<Nationalite> findAll();
}
