package com.yesserp.sessionbean.ga.vehicule;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Vehicule;

@Local
public interface GestionVehiculeLocal {

	public void ajouterVehicule(Vehicule vehicule);

	public void supprimerVehicule(Vehicule vehicule);

	public void modifierVehicule(Vehicule vehicule);

	public Vehicule trouverParId(Long id);

	public List<Vehicule> trouverVehiculesActifsParIdentite(Identite identite);

	public List<Vehicule> trouverHistoriqueVehiculesParIdentite(
			Identite identite, int n);

	public List<Vehicule> trouverHistoriqueVehiculesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<Vehicule> trouverPremiersHistoriqueVehiculesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<Vehicule> trouverHistoriqueVehiculesParIdentiteEtDateMax(
			Identite identite, Date max, int n);

	public List<Vehicule> trouverHistoriqueVehiculesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Long trouverNombreOccurrencesActivesParIdentite(Identite identite);

	public List<Vehicule> trouverPremiersHistoriqueVehiculesParIdentite(
			Identite identite, int n);
}
