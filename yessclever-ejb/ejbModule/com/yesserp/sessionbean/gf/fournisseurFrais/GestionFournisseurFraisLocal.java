package com.yesserp.sessionbean.gf.fournisseurFrais;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gf.FournisseurFrais;

@Local
public interface GestionFournisseurFraisLocal {

	public void ajouterFournisseurFrais(FournisseurFrais fournisseurFrais);

	public void modifierFournisseurFrais(FournisseurFrais fournisseurFrais);

	public void supprimerFournisseurFrais(FournisseurFrais fournisseurFrais);

	public FournisseurFrais findById(Long id);

	public List<FournisseurFrais> findAll();

	public void ajouterListeFournisseurFrais(
			List<FournisseurFrais> fournisseurFraiss);

	public FournisseurFrais findByNom(String nom);

	public List<FournisseurFrais> findByNoms(String nom);

}
