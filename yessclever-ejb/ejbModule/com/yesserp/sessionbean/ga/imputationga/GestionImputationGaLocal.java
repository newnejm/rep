package com.yesserp.sessionbean.ga.imputationga;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.ImputationGa;

@Local
public interface GestionImputationGaLocal {

	public void ajouterImputationGa(ImputationGa imputationGa);

	public void supprimerImputationGa(ImputationGa imputationGa);

	public void modifierImputationGa(ImputationGa imputationGa);

	public ImputationGa trouverParId(Long id);

	public List<ImputationGa> trouverImputationGasActifsParAffectation(
			Affectation affectation);

	public List<ImputationGa> trouverHistoriqueImputationGasParAffectation(
			Affectation affectation, int n);

	public List<ImputationGa> trouverHistoriqueImputationGasParAffectationEtDateMin(
			Affectation affectation, Date min, int n);

	public List<ImputationGa> trouverPremiersHistoriqueImputationGasParAffectationEtDateMin(
			Affectation affectation, Date min, int n);
	
	public List<ImputationGa> trouverPremiersHistoriqueImputationGasParAffectation(
			Affectation affectation, int n);


	public List<ImputationGa> trouverHistoriqueImputationGasParAffectationEtDateMax(
			Affectation affectation, Date max, int n);

	public List<ImputationGa> trouverHistoriqueImputationGasParAffectationEtDateMinMax(
			Affectation affectation, Date min, Date max, int n);

	public Long trouverNombreOccurrencesParAffectation(Affectation affectation);

	public Long trouverNombreOccurrencesActivesParAffectation(
			Affectation affectation);
}
