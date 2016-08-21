package com.yesserp.sessionbean.paramgta.anneereference;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.AnneeReference;

@Local
public interface GestionAnneeReferenceLocal {
	
	public void ajoutAnneeReference(AnneeReference anneeReference);

	public void supprimerAnneeReference(AnneeReference anneeReference);

	public void modifierAnneeReference(AnneeReference anneeReference);

	public List<AnneeReference> listerAnneeReference();

	public AnneeReference findAnneeReferenceById(int id);
}
