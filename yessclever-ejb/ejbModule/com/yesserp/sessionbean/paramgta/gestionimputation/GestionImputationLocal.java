package com.yesserp.sessionbean.paramgta.gestionimputation;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.GroupeImputation;
import com.yesserp.domain.gtaparam.Imputation;

@Local
public interface GestionImputationLocal {

	public void ajouterImputation(Imputation imputation);

	public void modifierImputation(Imputation imputation);

	public void supprimerImputation(Imputation imputation);

	public Imputation findImputationByCode(String code);

	public Imputation findImputationById(int id);

	public List<Imputation> listeImputation();

	public List<Imputation> getImputationNotInGroupe(
			GroupeImputation groupeImputation);

	public List<Imputation> getImputationInGroupe(
			GroupeImputation groupeImputation);
	
	
}
