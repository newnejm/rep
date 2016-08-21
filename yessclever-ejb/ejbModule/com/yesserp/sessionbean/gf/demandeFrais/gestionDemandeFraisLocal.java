package com.yesserp.sessionbean.gf.demandeFrais;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gf.DemandeFrais;

@Local
public interface gestionDemandeFraisLocal {

	public void ajouterDemandeFrais(DemandeFrais demandeFrais);

	public void modifierDemandeFrais(DemandeFrais demandeFrais);

	public void supprimerDemandeFrais(DemandeFrais demandeFrais);

	public DemandeFrais findById(Long id);

	public List<DemandeFrais> findAll();

	public List<DemandeFrais> findByEtat(String etat);

	public List<DemandeFrais> findByIdentite(Identite identite);

}
