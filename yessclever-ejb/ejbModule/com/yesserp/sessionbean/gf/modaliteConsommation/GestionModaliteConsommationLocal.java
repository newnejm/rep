package com.yesserp.sessionbean.gf.modaliteConsommation;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gf.Frais;
import com.yesserp.domain.gf.ModaliteConsommation;

@Local
public interface GestionModaliteConsommationLocal {

	public void ajouterModaliteConsommation(
			ModaliteConsommation modaliteConsommation);

	public void supprimerModaliteConsommation(
			ModaliteConsommation modaliteConsommation);

	public void modifierModaliteConsommation(
			ModaliteConsommation modaliteConsommation);

	public ModaliteConsommation findById(Long id);

	public List<ModaliteConsommation> findAll();
	
	public void ajouterListeModaliteConsommation(List<ModaliteConsommation> modaliteConsommations);
	
	public List<ModaliteConsommation> findByFrais(Frais frais);
	
	public ModaliteConsommation findByType(String type);
	
	public List<ModaliteConsommation> findByTypes(String type);

}
