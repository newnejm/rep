package com.yesserp.sessionbean.gf.frais;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gf.Frais;

@Local
public interface GestionFraisLocal {

	public void ajouterFrais(Frais frais);
	public void supprimerFrais(Frais frais);
	public void modifierFrais(Frais frais);
	public Frais findById(Long id);
	public List<Frais> findAll();
	public Frais findByType(String type);
	public List<Frais> findByTypes(String type);

}
