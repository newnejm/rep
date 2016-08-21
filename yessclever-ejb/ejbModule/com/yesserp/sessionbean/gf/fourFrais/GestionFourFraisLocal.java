package com.yesserp.sessionbean.gf.fourFrais;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gf.FourFrais;
import com.yesserp.domain.gf.FournisseurFrais;
import com.yesserp.domain.gf.Frais;

@Local
public interface GestionFourFraisLocal {

	public void ajouterFourfrais(FourFrais fourFrais);

	public void modifierFourFrais(FourFrais fourFrais);

	public void supprimerFourFrais(FourFrais fourFrais);

	public FourFrais findById(Long id);

	public List<FourFrais> findAll();

	public void ajouterFournisseursFrais(Long idFrais,
			List<FournisseurFrais> fournisseurFraiss, List<Date> datesDebut,
			List<Date> datesFin);

	public List<FourFrais> findByFrais(Frais frais);

	public List<FourFrais> findByFournisseur(FournisseurFrais fournisseurFrais);

	public void ajouterFournisseurFrais(Long idFrais,
			FournisseurFrais fournisseur, Date dateDebut, Date dateFin);
}
