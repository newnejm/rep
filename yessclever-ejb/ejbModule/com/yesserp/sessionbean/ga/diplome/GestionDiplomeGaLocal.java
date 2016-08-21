package com.yesserp.sessionbean.ga.diplome;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.DiplomeGa;
import com.yesserp.domain.ga.Identite;

@Local
public interface GestionDiplomeGaLocal {

	public void ajouterDiplome(DiplomeGa diplome);

	public void supprimerDiplome(DiplomeGa diplome);

	public void modifierDiplome(DiplomeGa diplome);

	public DiplomeGa trouverParId(Long id);

	public List<DiplomeGa> trouverDiplomesParIdentite(
			Identite identite, int n);

	public List<DiplomeGa> trouverDiplomesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<DiplomeGa> trouverPremiersDiplomesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<DiplomeGa> trouverDiplomesParIdentiteEtDateMax(
			Identite identite, Date max, int n);

	public List<DiplomeGa> trouverDiplomesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public List<DiplomeGa> trouverPremiersDiplomesParIdentite(
			Identite identite, int n);
	public List<DiplomeGa> findAll();
}
