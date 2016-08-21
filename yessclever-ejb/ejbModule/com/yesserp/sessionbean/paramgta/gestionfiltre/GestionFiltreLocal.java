package com.yesserp.sessionbean.paramgta.gestionfiltre;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.Compteur;
import com.yesserp.domain.gtaparam.Filtre;

@Local
public interface GestionFiltreLocal {
	public void ajouterFiltre(Filtre filtre);
	public void modifierFiltre(Filtre filtre);
	public Filtre rechercheFilterParNom(String formule);
	public Filtre getFilterById(int id);
	public List<Filtre>findFilterByCompteur(Compteur compteur);
	public void supprimerFiltre(Filtre filtre);
	public List<Filtre> listeFiltres();
}
