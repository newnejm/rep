package com.yesserp.sessionbean.gf.remboursement;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gf.Frais;
import com.yesserp.domain.gf.Remboursement;

@Local
public interface GestionRemboursementLocal {
	public void ajouterRemboursement(Remboursement remboursement);

	public void modifierRemboursement(Remboursement remboursement);

	public void supprimerRemboursement(Remboursement remboursement);

	public Remboursement findById(Long id);

	public List<Remboursement> findAll();

	public void ajouterListeRemboursement(List<Remboursement> remboursements);

	public List<Remboursement> findByFrais(Frais frais);

	public Remboursement findByType(String type);

	public List<Remboursement> findByTypes(String type);

}